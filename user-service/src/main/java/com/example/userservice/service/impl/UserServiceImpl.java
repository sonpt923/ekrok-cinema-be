package com.example.userservice.service.impl;

import com.example.core.config.AwsConfig;
import com.example.userservice.dto.request.UserRequest;
import com.example.userservice.dto.respond.UserResponse;
import com.example.userservice.entity.User;
import com.example.userservice.fiegn.NotificationFeign;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.repository.customize.UserRepositoryCustom;
import com.example.userservice.service.GroupUserService;
import com.example.userservice.service.MydictionaryService;
import com.example.userservice.service.UserService;
import com.example.userservice.utils.Constant;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public User findUserByUsername(String username) {
        return repository.findUserByUsername(username);
    }

    @Override
    public UserResponse userInfo(String username) {
        return convertUserToResponse(repository.findUserByUsername(username));
    }

    @Override
    @Transactional
    public Object createUser(UserRequest userRequest) {
        validateCreateUser(userRequest);
        String fullName = (userRequest.getFirstName() + " " + userRequest.getLastName());
        File file = new File(Base64.decodeBase64(userRequest.getImage()).toString());
        String username = this.genUsernameFromFullname(fullName);
        String password = passwordEncoder.encode(userRequest.getPassword());
        User user = User.builder()
                .birthDay(null).email(userRequest.getEmail())
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
        String password = passwordEncoder.encode(userRequest.getPassword());
        User user = User.builder()
//                .birthDay(userRequest.getBirthDay()).email(userRequest.getEmail())
                .lastName(userRequest.getLastName()).firstName(userRequest.getFirstName())
                .image("").status(Constant.user.ACTIVE).password(password)
                .username(userRequest.getUsername()).build();
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


    public Object revolkSession(String[] session) {
        // kiem tra user id co quyen revolk khong? admin hoac user

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
//
//        if (StringUtil.stringIsNullOrEmty(userRequest.getFirstName())) {
//            throw new ValidationException(BaseConstants.ERROR_NOT_NULL, String.format(dictionary.get(""), "first name"));
//        }
//
//        if (StringUtil.stringIsNullOrEmty(userRequest.getLastName())) {
//            throw new ValidationException(BaseConstants.ERROR_NOT_NULL, String.format(dictionary.get(""), "name name"));
//        }
//
//        if (StringUtil.stringIsNullOrEmty(userRequest.getEmail())) {
//            throw new ValidationException(BaseConstants.ERROR_NOT_NULL, String.format(dictionary.get(""), "email"));
//        }
//
//        if (StringUtil.stringIsNullOrEmty(userRequest.getPhone())) {
//            throw new ValidationException(BaseConstants.ERROR_NOT_NULL, String.format(dictionary.get("")));
//        }

    }

    private void validateUpdateUser(UserRequest userRequest) {
//        if (StringUtil.stringIsNullOrEmty(userRequest.getFirstName())) {
//            throw new ValidationException(BaseConstants.ERROR_NOT_NULL, String.format(dictionary.get(""), "first name"));
//        }
//
//        if (StringUtil.stringIsNullOrEmty(userRequest.getLastName())) {
//            throw new ValidationException(BaseConstants.ERROR_NOT_NULL, String.format(dictionary.get(""), "name name"));
//        }
//
//        if (StringUtil.stringIsNullOrEmty(userRequest.getEmail())) {
//            throw new ValidationException(BaseConstants.ERROR_NOT_NULL, String.format(dictionary.get(""), "email"));
//        }
//
//        if (StringUtil.stringIsNullOrEmty(userRequest.getPhone())) {
////            throw new ValidationException(BaseConstants.ERROR_NOT_NULL, String.format(dictionary))
//        }
    }

    private UserResponse convertUserToResponse(User user) {
        return UserResponse.builder()
                .id(user.getId()).username(user.getUsername())
                .firstName(user.getFirstName()).lastName(user.getLastName())
                .build();
    }

    public static String genUsernameFromFullname(String fullname) {
        String[] em = fullname.split("\\s");
        String username = "";
        username = em[0].toString();
        return username.toLowerCase();
    }

}
