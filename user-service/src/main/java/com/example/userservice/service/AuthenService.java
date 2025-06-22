package com.example.userservice.service;

import com.example.userservice.dto.request.UserRequest;

public interface AuthenService {

    Object login(UserRequest user) throws Exception;

    Object register(UserRequest request);

    Object forgotPassword(UserRequest request);

    Object changePassword(UserRequest user);

}
