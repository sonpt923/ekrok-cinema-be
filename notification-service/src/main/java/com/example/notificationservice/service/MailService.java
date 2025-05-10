package com.example.notificationservice.service;

import com.example.notificationservice.dto.request.MailOTPRequest;
import com.example.notificationservice.dto.request.MailRequest;
import com.example.notificationservice.model.Template;

public interface MailService {

    Object sendOTP(MailOTPRequest request);

}
