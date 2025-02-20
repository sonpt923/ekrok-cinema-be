package com.example.recommendationservice.service;

import com.example.recommendationservice.dto.request.UserRequest;
import com.example.recommendationservice.entity.User;
import com.example.recommendationservice.entity.google.UserInfo;

public interface AuthenService {

    Object login(User user) throws Exception;

    Object register(UserRequest request);

    Object forgotPassword(User user);

    Object changePassword(UserRequest user);

    Object loginByGoogle(UserInfo user);

    Object registerByGoogle(UserInfo user);

}
