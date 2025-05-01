package com.example.recommendationservice.service.impl;

import com.example.config.AwsConfig;
import com.example.exception.SystemException;
import com.example.exception.ValidationException;
import com.example.recommendationservice.feign.NotificationFeign;
import com.example.service.MydictionaryService;
import com.example.recommendationservice.dto.request.UserRequest;
import com.example.recommendationservice.entity.User;
import com.example.recommendationservice.repository.UserRepository;
import com.example.recommendationservice.repository.customize.UserRepositoryCustom;
import com.example.recommendationservice.service.GroupUserService;
import com.example.recommendationservice.service.UserService;
import com.example.recommendationservice.utils.Constant;
import com.example.utils.BaseConstants;
import com.example.utils.StringUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private AwsConfig awsConfig;

    @Autowired
    private MydictionaryService dictionary;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private NotificationFeign notificationFeign;

    @Autowired
    private GroupUserService groupUserService;

    @Autowired
    private UserRepositoryCustom userRepositoryCustom;

    @Override
    @Transactional
    public Object createUser(UserRequest userRequest) {
        validateCreateUser(userRequest);
        String fullName = (userRequest.getFirstName() + " " + userRequest.getLastName());
        File file = new File(Base64.decodeBase64(userRequest.getImage()).toString());
        String username = StringUtil.genUsernameFromFullname(fullName);
        String password = passwordEncoder.encode(userRequest.getPassword());
        User user = User.builder()
                .birthDay(userRequest.getBirthDay()).email(userRequest.getEmail())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName()).image("")
                .status(userRequest.getStatus()).password(password)
                .username(username).build();
        //TODO: chuyen sang su dung luong su dung kafka: user-service -> kafka -> notification
//        ResponseEntity response = notificationService.sendNotification(null);
//        if (response.getStatusCode() != HttpStatus.OK) {
//            throw new SystemException("", "");
//        }
        //TODO:  them user vao nhom duoc chi dinh
        user = repository.save(user);
        return user;
    }

    @Override
    @Transactional
    public Object updateUser(UserRequest userRequest) {
        validateUpdateUser(userRequest);
        File file = new File(Base64.decodeBase64(userRequest.getImage()).toString());
        String username = StringUtil.genUsernameFromFullname(userRequest.getFirstName() + " " + userRequest.getLastName());
        String password = passwordEncoder.encode(userRequest.getPassword());
        User user = User.builder()
                .birthDay(userRequest.getBirthDay()).email(userRequest.getEmail())
                .lastName(userRequest.getLastName()).firstName(userRequest.getFirstName())
                .image("").status(Constant.user.ACTIVE).password(password)
                .username(username).build();
//        ResponseEntity response = notificationFeign.sendNotification(null);
//        if (response.getStatusCode() != HttpStatus.OK) {
//            throw new SystemException("", "");
//        }
        // them user vao nhom duoc chi dinh
        user = repository.save(user);
        return null;
    }

    @Override
    @Transactional
    public Object deleteUser(UserRequest userRequest) {
        // TODO:
        // lấy danh sách nhóm quyền từ cache
        // kiểm tra xem có được xóa hay không
        if (StringUtil.stringIsNullOrEmty(userRequest.getId())) {
        }
        return null;
    }

    @Override
    public Object findAccountByCondition(UserRequest userRequest) {
        // TODO:
        // lây nhóm quyền từ cache
        // kiểm tra quyền search
        // kiểm tra xe được search đến đâu
        return userRepositoryCustom.findAccountByCondition(userRequest);
    }

    @Override
    public Object revolkToken(UserRequest userRequest) {
        return null;
    }

    @Override
    public Object deleteAccount(UserRequest userRequest) {
        // start luong = 1
        // lưu otp vào redis
        // -> call sang notification send mã xác minh
        // start luong = 2
        // check otp
        // neu dung
        return null;
    }

    private void validateCreateUser(UserRequest userRequest) {

        if (StringUtil.stringIsNullOrEmty(userRequest.getFirstName())) {
            throw new ValidationException(BaseConstants.ERROR_NOT_NULL, String.format(dictionary.get(""), "first name"));
        }

        if (StringUtil.stringIsNullOrEmty(userRequest.getLastName())) {
            throw new ValidationException(BaseConstants.ERROR_NOT_NULL, String.format(dictionary.get(""), "name name"));
        }

        if (StringUtil.stringIsNullOrEmty(userRequest.getEmail())) {
            throw new ValidationException(BaseConstants.ERROR_NOT_NULL, String.format(dictionary.get(""), "email"));
        }

        if (StringUtil.stringIsNullOrEmty(userRequest.getPhone())) {
            throw new ValidationException(BaseConstants.ERROR_NOT_NULL, String.format(dictionary.get("")));
        }

    }

    private void validateUpdateUser(UserRequest userRequest) {
        if (StringUtil.stringIsNullOrEmty(userRequest.getFirstName())) {
            throw new ValidationException(BaseConstants.ERROR_NOT_NULL, String.format(dictionary.get(""), "first name"));
        }

        if (StringUtil.stringIsNullOrEmty(userRequest.getLastName())) {
            throw new ValidationException(BaseConstants.ERROR_NOT_NULL, String.format(dictionary.get(""), "name name"));
        }

        if (StringUtil.stringIsNullOrEmty(userRequest.getEmail())) {
            throw new ValidationException(BaseConstants.ERROR_NOT_NULL, String.format(dictionary.get(""), "email"));
        }

        if (StringUtil.stringIsNullOrEmty(userRequest.getPhone())) {
//            throw new ValidationException(BaseConstants.ERROR_NOT_NULL, String.format(dictionary))
        }
    }

}
