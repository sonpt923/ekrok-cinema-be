package com.example.userservice.service;

import com.example.userservice.dto.request.UserRequest;
import com.example.userservice.dto.respond.UserResponse;
import com.example.userservice.entity.User;

public interface UserService {

    User findUserByUsername(String username);

    User findUserByEmail(String email);

    User findUserByPhone(String phone);

    UserResponse userInfo(String authenKey);

    Object createUser(UserRequest userRequest);

    Object updateUser(UserRequest userRequest);

    Object deleteUser(UserRequest userRequest);

    Object findAccountByCondition(UserRequest userRequest);

    Object revolkSession(String[] session);

    Object deleteAccount(UserRequest userRequest);


}
