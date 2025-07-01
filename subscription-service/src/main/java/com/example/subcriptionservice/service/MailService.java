package com.example.subcriptionservice.service;

import com.example.subcriptionservice.dto.request.MailRequest;

public interface MailService {

    void sendOTP(MailRequest request);

    void sendBookingMail(MailRequest request);

}
