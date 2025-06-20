package com.example.userservice.service.impl;

import com.example.userservice.config.AwsConfig;
import com.example.userservice.dto.request.UserRequest;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.repository.customize.UserRepositoryCustom;
import com.example.userservice.service.GroupUserService;
import com.example.userservice.service.UserService;
import com.example.userservice.service.feign.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private AwsConfig awsConfig;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private GroupUserService groupUserService;

    @Autowired
    private UserRepositoryCustom userRepositoryCustom;

    @Override
    @Transactional
    public Object createUser(UserRequest userRequest) {
        return null;
    }

    @Override
    @Transactional
    public Object updateUser(UserRequest userRequest) {
        return null;
    }

    @Override
    @Transactional
    public Object deleteUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public Object findAccountByCondition(UserRequest userRequest) {
        // lây nhóm quyền từ cache
        // kiểm tra quyền search
        // kiểm tra xe được search đến đâu
        return null;
    }
}
