package com.example.recommendationservice.service;

import com.example.recommendationservice.dto.request.UserRequest;
import com.example.recommendationservice.entity.User;

public interface AuthenService {

    Object login(UserRequest user) throws Exception;

    Object register(UserRequest request);

    Object forgotPassword(UserRequest request);

    Object changePassword(UserRequest user);

}
