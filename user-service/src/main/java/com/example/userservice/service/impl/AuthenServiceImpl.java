package com.example.userservice.service.impl;

import com.example.userservice.dto.request.UserRequest;
import com.example.userservice.entity.ApDomain;
import com.example.userservice.entity.User;
import com.example.userservice.fiegn.NotificationFeign;
import com.example.userservice.service.ApDomainService;
import com.example.userservice.service.AuthenService;
import com.example.userservice.service.MydictionaryService;
import com.example.userservice.service.UserService;
import com.example.userservice.utils.Constant;
import com.example.userservice.utils.DateUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
    private MydictionaryService dic;

    @Override
    public Object login(UserRequest request) {
        User user = userService.findUserByUsername(request.getUsername());
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
            userService.createUser(request);
//        }
        }
        return null;
    }

    @Override
    public Object forgotPassword(UserRequest request) {
        // case 1: set otp
        if (request.getFlag() == 0) {
            Assert.isNull(request.getUsername(), dic.get("ERROR.APP_IS_NOT_MANAGE"));
            Long otpTime = Constant.OTP_TIME;
            ApDomain apDomain = apDomainService.getByCode(Constant.AP_DOMAIN.OTP_CODE);
            if(apDomain != null){
                otpTime = Long.valueOf(apDomain.getValue());
            }
            redisTemplate.opsForValue().set("", "", otpTime, TimeUnit.SECONDS);
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
        Assert.isNull(request.getFlag(), "Khong duoc bo trong truong flag");
        return null;
    }

    @Override
    public Object changePassword(UserRequest request) {
        Assert.isNull(request.getPassword(), "password is not null");
        Assert.isNull(request.getConfirmPassword(), "confirm password is not null");
        if (request.getPassword().equals(request.getConfirmPassword())) {
            request.setPassword(passwordEncoder.encode(request.getPassword()));
            // TODO: send to notification
            return userService.createUser(request);
        }
        return null;
    }

    private void validateRegister(UserRequest request) {

        Assert.hasText(request.getUsername(),
                String.format(dic.get("ERROR.USERNAME.EXISTS"), "username"));

        Assert.hasText(request.getPassword(),
                String.format(dic.get("ERROR.PASSWORD.NOT_NULL"), "password"));

        Assert.hasText(request.getConfirmPassword(),
                String.format(dic.get("ERROR.CONFIRM_PASSWORD.NOT_NULL"), "confirmPassword"));

        Assert.hasText(request.getBirthDay(),
                String.format(dic.get("ERROR.BIRTHDAY.NOT_NULL"), "birthDay"));

        Assert.hasText(request.getEmail(),
                String.format(dic.get("ERROR.EMAIL.NOT_NULL"), "email"));

        Assert.hasText(request.getPhone(),
                String.format(dic.get("ERROR.PHONE.NOT_NULL"), "phone"));

        Assert.isNull(userService.findUserByUsername(request.getUsername()),
                String.format(dic.get("ERROR.USERNAME.EXISTS"), request.getUsername()));

//        Assert.isNull(userService.findUserByPhone(request.getPhone()),
//                String.format(dic.get("ERROR.PHONE.EXISTS"), request.getPhone()));


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
