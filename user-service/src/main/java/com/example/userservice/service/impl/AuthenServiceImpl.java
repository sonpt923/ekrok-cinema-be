package com.example.userservice.service.impl;

import com.example.userservice.dto.request.UserRequest;
import com.example.userservice.entity.ApDomain;
import com.example.userservice.entity.User;
import com.example.userservice.fiegn.NotificationFeign;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.ApDomainService;
import com.example.userservice.service.AuthenService;
import com.example.userservice.service.MydictionaryService;
import com.example.userservice.utils.Constant;
import com.example.userservice.utils.DateUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.util.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class AuthenServiceImpl implements AuthenService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ApDomainService apDomainService;

    @Autowired
    private NotificationFeign notificationFeign;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private MydictionaryService dic;

    @Override
    public Object login(UserRequest request) {
        User user = userRepository.findUserByUsername(request.getUsername());
        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            try {
                String key = Constant.USER_SESSION + ":" + request.getUsername() + ":" + UUID.randomUUID();
                Long ttl = Constant.TTL;
                if (request.getIsAdmin()) {
                    Long.valueOf(apDomainService.getByCode(Constant.AP_DOMAIN.OTP_CODE).getValue());
                } else {
                    Long.valueOf(apDomainService.getByCode(Constant.AP_DOMAIN.OTP_CODE).getValue());
                }
                HashMap<String, Object> jsonValue = this.userToJsonValue(user);
                redisTemplate.opsForValue().set(key, new ObjectMapper().writeValueAsString(jsonValue), ttl, TimeUnit.MINUTES);
                boolean isSetRedis = redisTemplate.hasKey(key);
                if (isSetRedis) {
                    return new HashMap<>(Map.of("authen-key", key));
                }
            } catch (Exception e) {
                e.printStackTrace();
//                throw new AppException("", "");
            }
        }
//        throw new ValidationException(BaseConstants.ERROR_DATA_NOT_FOUND,
//                dic.get("ERROR.DATA_IS_EXIST"));
        return null;
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
            userRepository.save(user);
//        }
        }
//        throw new Exception("", dic.get("ERROR.CREATE_ACCOUNT_FAIL"));
        return null;
    }

    @Override
    public Object forgotPassword(UserRequest request) {
        // case 1: gui otp
        if (request.getFlag() == 0) {
            Assert.isNull(request.getUsername(), dic.get("ERROR.APP_IS_NOT_MANAGE"));
            Long otpTime = 0L;
            ApDomain apDomain = apDomainService.getByCode(Constant.AP_DOMAIN.OTP_CODE);
            try {
                otpTime = Long.valueOf(apDomain.getValue());
            } catch (Exception e) {
                otpTime = Constant.OTP_TIME;
            }
            ;
            // send otp ->  notification-service
//            request.setOtp(otpCache.getValue());
//            ResponseEntity response = notificationFeign.sendOTP(request);
            return null;
        } else { // case2: xu ly
//            OTPCache otp = otpCacheRepository.findById(request.getUsername()).get();
//            if (otp != null) {
//                if (otp.getValue().equals(request.getOtp())) {
//                    changePassword(request);
//                }
//                return null;
//            } else {
//                throw new SystemException(null);
//            }
        }
        return null;
    }

    @Override
    public Object changePassword(UserRequest request) {
//        if (StringUtil.stringIsNullOrEmty(request.getPassword())
//                || StringUtil.stringIsNullOrEmty(request.getConfirmPassword())) {
//            throw new ValidationException(BaseConstants.ERROR_NOT_NULL, String.format(Constant.ERROR_NOT_NULL, "password"));
//        }
//        if (request.getPassword().equals(request.getConfirmPassword())) {
//            User user = userRepository.findUserByUsername(request.getUsername());
//            user.setPassword(passwordEncoder.encode(request.getPassword()));
//            return userRepository.save(user);
//        }
//        throw new ValidationException(Constant.ERROR_PASS_NOT_COMPARE, dic.get("ERROR.CHANGE_PASS.002"));
    }

    private void validateRegister(UserRequest request) {

//        if (StringUtil.stringIsNullOrEmty(request.getUsername())) {
//            throw new ValidationException(BaseConstants
//                    .ERROR_NOT_NULL, String.format(dic.get(""), ""));
//        }
//
//        if (StringUtil.stringIsNullOrEmty(request.getPassword())) {
//            throw new ValidationException(BaseConstants.ERROR_PASSWORD_NOT_NULL
//                    , String.format(dic.get(""), ""));
//        }
//
//        if (StringUtil.stringIsNullOrEmty(request.getConfirmPassword())) {
//            throw new ValidationException(BaseConstants.ERROR_PASSWORD_NOT_NULL,
//                    String.format(dic.get("ERROR.CHANGE_PASS.001"), ""));
//        }
//
//        if (StringUtil.stringIsNullOrEmty(request.getBirthDay())) {
//            throw new ValidationException(BaseConstants
//                    .ERROR_NOT_NULL, String.format(dic.get(""), ""));
//        }
//
//        if (StringUtil.stringIsNullOrEmty(request.getEmail())) {
//            throw new ValidationException(BaseConstants
//                    .ERROR_NOT_NULL, String.format(dic.get(""), ""));
//        }
//
//        if (StringUtil.stringIsNullOrEmty(request.getPhone())) {
//            throw new ValidationException(BaseConstants.ERROR_NOT_NULL, String.format(dic.get(""), ""));
//        }
//
//        if (userRepository.findUserByUsername(request.getUsername()) != null) {
//            throw new ValidationException(BaseConstants.ERROR_NOT_NULL, String.format(""));
//        }
//
////        if (!DateUtil.isDate(request.getBirthDay())) {
////            throw new ValidationException(null);
////        }
//
//        if (userRepository.findUserByPhone(request.getPhone()) != null) {
//            throw new ValidationException(null);
//        }
    }


    private HashMap<String, Object> userToJsonValue(User user) {
        HashMap<String, Object> jsonValue = new HashMap<>();
        jsonValue.put("username", user.getUsername());
        jsonValue.put("roles", "");
        jsonValue.put("group", "");
        jsonValue.put("email", user.getEmail());
        jsonValue.put("image", user.getImage());
        jsonValue.put("fristName", user.getFirstName());
        jsonValue.put("lastName", user.getLastName());
        return jsonValue;
    }

}
