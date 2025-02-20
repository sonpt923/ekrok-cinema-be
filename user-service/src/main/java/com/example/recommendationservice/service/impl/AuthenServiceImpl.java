package com.example.recommendationservice.service.impl;

import com.example.exception.AppException;
import com.example.exception.SystemException;
import com.example.exception.ValidationException;
import com.example.service.MydictionaryService;
import com.example.recommendationservice.dto.request.UserRequest;
import com.example.recommendationservice.entity.ApDomain;
import com.example.recommendationservice.entity.User;
import com.example.recommendationservice.entity.google.UserInfo;
import com.example.recommendationservice.entity.redisCache.OTPCache;
import com.example.recommendationservice.entity.redisCache.SecurityCache;
import com.example.recommendationservice.repository.UserRepository;
import com.example.recommendationservice.repository.redis.OTPCacheRepository;
import com.example.recommendationservice.repository.redis.TokenCacheRepository;
import com.example.recommendationservice.security.JwtProvider;
import com.example.recommendationservice.service.ApDomainService;
import com.example.recommendationservice.service.AuthenService;
import com.example.recommendationservice.service.feign.NotificationService;
import com.example.recommendationservice.utils.Constant;
import com.example.utils.BaseConstants;
import com.example.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
    private MydictionaryService dictionaryService;

    @Autowired
    private OTPCacheRepository otpCacheRepository;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private TokenCacheRepository tokenCacheRepository;

    @Override
    public Object login(User request) {
        User user = userRepository.findUserByUsername(request.getUsername());
        if (!StringUtil.stringIsNullOrEmty(user)) {
            if (passwordEncoder.matches(user.getPassword(), user.getPassword())) {
                try {
                    String token = jwtProvider.generateTokenRSA(request.getEmail());
                    String key = UUID.randomUUID().toString();
                    Long ttl = Long.valueOf(apDomainService.getByCode(Constant.AP_DOMAIN.OTP_CODE).getValue());
                    SecurityCache cache = new SecurityCache(key, ttl, token);
                    tokenCacheRepository.save(cache);
                    return new HashMap<>(Map.of("authen-key", key));
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new AppException("", "");
                }
            }
        }
        throw new ValidationException(BaseConstants.ERROR_DATA_NOT_FOUND,
                dictionaryService.get("ERROR.DATA_IS_EXIST"));
    }

    @Override
    public Object register(UserRequest request) {
        validateRegister(request);
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .birthDay(request.getBirthDay())
                .fullName(request.getFullName())
                .createdBy(request.getUsername())
                .build();
        ResponseEntity response = notificationService.sendNotification(null);
        if (response.getStatusCode() == HttpStatus.OK) {
            return userRepository.save(user);
        }
        throw new AppException(BaseConstants.ERROR_CREATE_STAFF, dictionaryService.get("ERROR.CREATE_ACCOUNT_FAIL"));
    }

    @Override
    public Object forgotPassword(User user) {
        if (StringUtil.stringIsNullOrEmty(user.getUsername())) {
            throw new ValidationException(BaseConstants.ERROR_NOT_NULL,
                    String.format(dictionaryService.get("ERROR.APP_IS_NOT_MANAGE"), ""));
        }
        String email = userRepository.findUserByUsernameOrEmail(user.getUsername()).getEmail();
        if (StringUtil.stringIsNullOrEmty(email)) {
            throw new ValidationException(BaseConstants.ERROR_DATA_NOT_FOUND, dictionaryService.get("ERROR.NOT_FOUND_DATA"));
        }
        Long otpTime = 0L;
        ApDomain apDomain = apDomainService.getByCode(Constant.AP_DOMAIN.OTP_CODE);
        try {
            otpTime = Long.valueOf(apDomain.getValue());
        } catch (Exception e) {
            otpTime = Constant.OTP_TIME;
        }
        OTPCache otpCache = new OTPCache(user.getUsername(), otpTime, StringUtil.generateString(Constant.OTP_LENGTH));
        otpCacheRepository.save(otpCache);
        ResponseEntity response = notificationService.sendNotification(null);
        if (response.getStatusCode() == HttpStatus.OK) {
            return null;
        }
        throw new SystemException("", "");
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
        throw new ValidationException(Constant.ERROR_PASS_NOT_COMPARE, dictionaryService.get("ERROR.CHANGE_PASS.002"));
    }

    @Override
    public Object loginByGoogle(UserInfo user) {
        return null;
    }

    @Override
    public Object registerByGoogle(UserInfo user) {
        return null;
    }


    private void validateRegister(UserRequest request) {

        if (StringUtil.stringIsNullOrEmty(request.getUsername())) {
            throw new ValidationException(BaseConstants
                    .ERROR_NOT_NULL, String.format(dictionaryService.get(""), ""));
        }

        if (StringUtil.stringIsNullOrEmty(request.getPassword())) {
            throw new ValidationException(BaseConstants.ERROR_PASSWORD_NOT_NULL
                    , String.format(dictionaryService.get(""), ""));
        }

        if (StringUtil.stringIsNullOrEmty(request.getConfirmPassword())) {
            throw new ValidationException(BaseConstants.ERROR_PASSWORD_NOT_NULL,
                    String.format(dictionaryService.get("ERROR.CHANGE_PASS.001"), ""));
        }

        if (StringUtil.stringIsNullOrEmty(request.getBirthDay())) {
            throw new ValidationException(BaseConstants
                    .ERROR_NOT_NULL, String.format(dictionaryService.get(""), ""));
        }
    }
}
