package com.example.userservice.service.impl;

import com.example.userservice.dto.request.UserRequest;
import com.example.userservice.entity.User;
import com.example.userservice.entity.google.UserInfo;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.ApDomainService;
import com.example.userservice.service.AuthenService;
import com.example.userservice.service.feign.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenServiceImpl implements AuthenService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ApDomainService apDomainService;

    @Autowired
    private NotificationService notificationService;

    @Override
    public Object login(User request) {
        return null;
    }

    @Override
    public Object register(UserRequest request) {
        return null;
    }

    @Override
    public Object forgotPassword(User user) {
        return null;
    }

    @Override
    public Object changePassword(UserRequest request) {
        return null;
    }

    @Override
    public Object loginByGoogle(UserInfo user) {
        return null;
    }

    @Override
    public Object registerByGoogle(UserInfo user) {
        return null;
    }

}
