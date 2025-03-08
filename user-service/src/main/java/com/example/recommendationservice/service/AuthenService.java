package com.example.recommendationservice.service;

import com.example.recommendationservice.dto.request.UserRequest;
import com.example.recommendationservice.entity.User;
import com.example.recommendationservice.entity.google.GoogleInfo;

public interface AuthenService {

    Object login(User user) throws Exception;

    Object register(UserRequest request);

    Object forgotPassword(UserRequest request);

    Object changePassword(UserRequest user);

    Object loginByGoogle(GoogleInfo user);

    Object registerByGoogle(GoogleInfo user);

}
