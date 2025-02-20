package com.example.recommendationservice.service;

import com.example.recommendationservice.dto.request.UserRequest;

public interface UserService {

    Object createUser(UserRequest userRequest);

    Object updateUser(UserRequest userRequest);

    Object deleteUser(UserRequest userRequest);

    Object findAccountByCondition(UserRequest userRequest);

}
