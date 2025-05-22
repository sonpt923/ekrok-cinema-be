package com.example.userservice.service.impl;

import com.example.exception.AppException;
import com.example.exception.SystemException;
import com.example.exception.ValidationException;
import com.example.service.MydictionaryService;
import com.example.userservice.dto.request.UserRequest;
import com.example.userservice.entity.ApDomain;
import com.example.userservice.entity.User;
import com.example.userservice.entity.redisCache.OTPCache;
import com.example.userservice.entity.redisCache.TokenCache;
import com.example.userservice.feign.NotificationFeign;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.repository.redis.OTPCacheRepository;
import com.example.userservice.repository.redis.TokenCacheRepository;
import com.example.userservice.security.JwtProvider;
import com.example.userservice.service.ApDomainService;
import com.example.userservice.service.AuthenService;
import com.example.userservice.utils.Constant;
import com.example.utils.BaseConstants;
import com.example.utils.DateUtil;
import com.example.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AuthenServiceImpl implements AuthenService {

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ApDomainService apDomainService;

    @Autowired
    private MydictionaryService dic;

    @Autowired
    private OTPCacheRepository otpCacheRepository;

    @Autowired
    private NotificationFeign notificationFeign;

    @Autowired
    private TokenCacheRepository tokenCacheRepository;

    @Override
    public Object login(UserRequest request) {
        Assert.isNull(request, "request can not be null or empty");
        User user = userRepository.findUserByUsername(request.getUsername());
        if (passwordEncoder.matches(user.getPassword(), user.getPassword())) {
            try {
                String token = jwtProvider.generateTokenRSA(request.getEmail());
                String key = UUID.randomUUID().toString();
                Long ttl = Constant.TTL;
                if (request.getIsAdmin()) {
                    Long.valueOf(apDomainService.getByCode(Constant.AP_DOMAIN.OTP_CODE).getValue());
                } else {
                    Long.valueOf(apDomainService.getByCode(Constant.AP_DOMAIN.OTP_CODE).getValue());
                }
                TokenCache cache = new TokenCache(key, ttl, token);
                tokenCacheRepository.save(cache);
                return new HashMap<>(Map.of("authen-key", key));
            } catch (Exception e) {
                e.printStackTrace();
                throw new AppException("", "");
            }
        }
        throw new ValidationException(BaseConstants.ERROR_DATA_NOT_FOUND,
                dic.get("ERROR.DATA_IS_EXIST"));
    }

    @Override
    public Object register(UserRequest request) {
        validateRegister(request);
        User user = User.builder().username(request.getUsername()).email(request.getEmail())
                .birthDay(DateUtil.convertDateToTimestamp(DateUtil.stringToDate(request.getBirthDay())))
                .phone(request.getPhone())
                .firstName(request.getFirstName()).lastName(request.getLastName())
                .createdBy(Constant.SELF_CREATE).build();
        // TODO: register user
        ResponseEntity response = notificationFeign.sendOTP(request);
        if (response.getStatusCodeValue() == 200 && response.getStatusCode().equals(HttpStatus.OK)) {
            userRepository.save(user);
        }
        throw new AppException(BaseConstants.ERROR_CREATE_STAFF, dic.get("ERROR.CREATE_ACCOUNT_FAIL"));
    }

    @Override
    public Object forgotPassword(UserRequest request) {
        // case 1: gui otp
        if (request.getFlag() == 0) {
            if (StringUtil.stringIsNullOrEmty(request.getUsername())) {
                throw new ValidationException(BaseConstants.ERROR_NOT_NULL,
                        String.format(dic.get("ERROR.APP_IS_NOT_MANAGE"), ""));
            }
            Long otpTime = 0L;
            ApDomain apDomain = apDomainService.getByCode(Constant.AP_DOMAIN.OTP_CODE);
            try {
                otpTime = Long.valueOf(apDomain.getValue());
            } catch (Exception e) {
                otpTime = Constant.OTP_TIME;
            }
            OTPCache otpCache = new OTPCache(request.getUsername(), StringUtil.generateString(Constant.OTP_LENGTH), otpTime);
            otpCacheRepository.save(otpCache);
            // send otp ->  notification-service
            request.setOtp(otpCache.getValue());
//            ResponseEntity response = notificationFeign.sendOTP(request);
            return null;
        } else { // case2: xu ly
            OTPCache otp = otpCacheRepository.findById(request.getUsername()).get();
            if (otp != null) {
                if (otp.getValue().equals(request.getOtp())) {
                    changePassword(request);
                }
                return null;
            } else {
                throw new SystemException(null);
            }
        }
    }

    @Override
    public Object changePassword(UserRequest request) {
        if (StringUtil.stringIsNullOrEmty(request.getPassword())
                || StringUtil.stringIsNullOrEmty(request.getConfirmPassword())) {
            throw new ValidationException(BaseConstants.ERROR_NOT_NULL, String.format(Constant.ERROR_NOT_NULL, "password"));
        }
        if (request.getPassword().equals(request.getConfirmPassword())) {
            User user = userRepository.findUserByUsername(request.getUsername());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            return userRepository.save(user);
        }
        throw new ValidationException(Constant.ERROR_PASS_NOT_COMPARE, dic.get("ERROR.CHANGE_PASS.002"));
    }

    private void validateRegister(UserRequest request) {

        if (StringUtil.stringIsNullOrEmty(request.getUsername())) {
            throw new ValidationException(BaseConstants
                    .ERROR_NOT_NULL, String.format(dic.get(""), ""));
        }

        if (StringUtil.stringIsNullOrEmty(request.getPassword())) {
            throw new ValidationException(BaseConstants.ERROR_PASSWORD_NOT_NULL
                    , String.format(dic.get(""), ""));
        }

        if (StringUtil.stringIsNullOrEmty(request.getConfirmPassword())) {
            throw new ValidationException(BaseConstants.ERROR_PASSWORD_NOT_NULL,
                    String.format(dic.get("ERROR.CHANGE_PASS.001"), ""));
        }

        if (StringUtil.stringIsNullOrEmty(request.getBirthDay())) {
            throw new ValidationException(BaseConstants
                    .ERROR_NOT_NULL, String.format(dic.get(""), ""));
        }

        if (StringUtil.stringIsNullOrEmty(request.getEmail())) {
            throw new ValidationException(BaseConstants
                    .ERROR_NOT_NULL, String.format(dic.get(""), ""));
        }

        if (StringUtil.stringIsNullOrEmty(request.getPhone())) {
            throw new ValidationException(BaseConstants.ERROR_NOT_NULL, String.format(dic.get(""), ""));
        }

        if (userRepository.findUserByUsername(request.getUsername()) != null) {
            throw new ValidationException(BaseConstants.ERROR_NOT_NULL, String.format(""));
        }

        if (!DateUtil.isDate(request.getBirthDay())) {
            throw new ValidationException(null);
        }

        if (userRepository.findUserByPhone(request.getPhone()) != null) {
            throw new ValidationException(null);
        }


    }
}
