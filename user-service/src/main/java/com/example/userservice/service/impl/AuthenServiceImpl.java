package com.example.userservice.service.impl;

import com.example.core.exception.BusinessException;
import com.example.core.exception.SystemException;
import com.example.core.exception.ValidateException;
import com.example.core.i18n.Dictionary;
import com.example.core.utils.BaseConstant;
import com.example.userservice.dto.request.UserRequest;
import com.example.userservice.entity.ApDomain;
import com.example.userservice.entity.User;
import com.example.userservice.fiegn.NotificationFeign;
import com.example.userservice.service.ApDomainService;
import com.example.userservice.service.AuthenService;
import com.example.userservice.service.UserService;
import com.example.userservice.utils.Constant;
import com.example.userservice.utils.DateUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class AuthenServiceImpl implements AuthenService {


    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ApDomainService apDomainService;

    @Autowired
    private NotificationFeign notificationFeign;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private Dictionary dic;


    @Override
    public Object login(UserRequest request) {
        if (request.getUsername() == null || request.getUsername().isEmpty() || request.getPassword().isEmpty()) {
            throw new ValidateException(BaseConstant.ERORRS.NOT_NULL, String.format(dic.get("SYS-001")));
        }
        User user = userService.findUserByUsername(request.getUsername());
        if (user == null) {
            throw new SystemException(BaseConstant.ERORRS.DATA_NOT_FOUND, dic.get("SYS-002"));
        }

        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            try {
                String key = Constant.USER_SESSION + ":" + request.getUsername() + ":" + UUID.randomUUID();
                Long ttl = Constant.TTL;
                if (request.getIsAdmin()) {
                    ttl = Long.valueOf(apDomainService.getByCode(Constant.AP_DOMAIN.ADM_OTP_CODE).getValue());
                } else {
                    ttl = Long.valueOf(apDomainService.getByCode(Constant.AP_DOMAIN.CLIENT_OTP_CODE).getValue());
                }
                HashMap<String, Object> jsonValue = this.userToJsonValue(user);
                redisTemplate.opsForValue().set(key, new ObjectMapper().writeValueAsString(jsonValue), ttl, TimeUnit.MINUTES);
                boolean isSetRedis = redisTemplate.hasKey(key);
                if (isSetRedis) {
                    return new HashMap<>(Map.of("X-Authen-Key", key));
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new BusinessException(BaseConstant.ERORRS.SYSTEM, dic.get(""));
            }
        }
        throw new ValidateException(BaseConstant.ERORRS.DATA_NOT_MATCH, dic.get(""));
    }

    @Override
    public Object register(UserRequest request) {
        validateRegister(request);
        User user = User.builder().provider("DEMO").providerId(1L)
                .username(request.getUsername()).email(request.getEmail())
                .birthDay(DateUtil.convertDateToTimestamp(DateUtil.stringToDate(request.getBirthDay())))
                .phone(request.getPhone())
                .firstName(request.getFirstName()).lastName(request.getLastName())
                .createdBy(Constant.SELF_CREATE).build();
        if (request.getPassword().equals(request.getConfirmPassword())) {
//            ResponseEntity response = notificationFeign.sendOTP(request);
//        if (response.getStatusCodeValue() == 200 && response.getStatusCode().equals(HttpStatus.OK)) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            userService.createUser(request);
//        }
        }
        throw new ValidateException("", String.format(dic.get("")));
    }

    @Override
    public Object forgotPassword(UserRequest request) {
        // case 1: set otp
        if (request.getFlag() == 0) {
            if (request.getUsername() == null || request.getUsername().isEmpty()) {
                throw new ValidateException("", "");
            }
            Long otpTime = Constant.OTP_TIME;
            String domainCode = request.getIsAdmin() ? Constant.AP_DOMAIN.ADM_OTP_CODE : Constant.AP_DOMAIN.CLIENT_OTP_CODE;
            ApDomain apDomain = apDomainService.getByCode(domainCode);
            if (apDomain != null) {
                otpTime = Long.parseLong(apDomain.getValue());
            }
            redisTemplate.opsForValue().set("", "", otpTime, TimeUnit.SECONDS);
            // send otp ->  notification-service
//            request.setOtp(otpCache.getValue());
//            ResponseEntity response = notificationFeign.sendOTP(request);
            return null;
        } else { // case2: xu ly
//            String otp = redisTemplate.opsForValue().get(new Object());
//            if (otp != null && !otp.isEmpty()) {
//                if (otp.equals(request.getOtp())) {
//                    changePassword(request);
//                }
//                return null;
//            }
        }
        throw new ValidateException("", "");
    }

    @Override
    public Object changePassword(UserRequest request) {
        if (request.getPassword().equals(request.getConfirmPassword())) {
            request.setPassword(passwordEncoder.encode(request.getPassword()));
            // TODO: send to notification
            return userService.createUser(request);
        }
        return null;
    }

    private void validateRegister(UserRequest request) {

        if (request.getUsername() == null || request.getUsername().isEmpty()) {
            throw new ValidateException(BaseConstant.ERORRS.NOT_NULL, String.format(dic.get("SYS-003"), "username"));
        }

        if (request.getPassword() == null || request.getPassword().isEmpty()) {
            throw new ValidateException(BaseConstant.ERORRS.NOT_NULL, String.format(dic.get("SYS-003"), "password"));
        }

        if (request.getConfirmPassword() == null || request.getConfirmPassword().isEmpty()) {
            throw new ValidateException(BaseConstant.ERORRS.NOT_NULL, String.format(dic.get("SYS-003"), "confirm password"));
        }

        if (request.getBirthDay() == null || request.getBirthDay().isEmpty()) {
            throw new ValidateException(BaseConstant.ERORRS.NOT_NULL, String.format(dic.get("SYS-003"), "birthday"));
        }

        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            throw new ValidateException(BaseConstant.ERORRS.NOT_NULL, String.format(dic.get("SYS-003"), "email"));
        }

        if (request.getPhone() == null || request.getPhone().isEmpty()) {
            throw new ValidateException(BaseConstant.ERORRS.NOT_NULL, String.format(dic.get("SYS-003"), "phone"));
        }

        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            throw new ValidateException(BaseConstant.ERORRS.NOT_NULL, String.format(dic.get("SYS-003"), "email"));
        }

        if (userService.findUserByEmail(request.getEmail()) != null) {
            throw new ValidateException(BaseConstant.ERORRS.DATA_USING, String.format(dic.get("email")));
        }

        if (userService.findUserByEmail(request.getPhone()) != null) {
            throw new ValidateException(BaseConstant.ERORRS.DATA_USING, String.format(dic.get("phone")));
        }

        if (userService.findUserByUsername(request.getUsername()) != null) {
            throw new ValidateException(BaseConstant.ERORRS.DATA_USING, String.format(dic.get("username")));
        }

    }


    private HashMap<String, Object> userToJsonValue(User user) {
        HashMap<String, Object> jsonValue = new HashMap<>();
        jsonValue.put("username", user.getUsername());
        return jsonValue;
    }

}
