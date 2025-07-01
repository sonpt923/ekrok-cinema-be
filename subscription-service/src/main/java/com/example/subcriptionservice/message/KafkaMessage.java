package com.example.subcriptionservice.message;

import com.example.subcriptionservice.dto.request.MailRequest;
import com.example.subcriptionservice.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessage {

    @Autowired
    private MailService mailService;

    @KafkaListener(topics = "test", groupId = "test-group")
    public void listenTest(String message) {
        System.out.println("message received: " + message);
    }

    @KafkaListener(topics = "otp", groupId = "otp-group")
    public void listenSendOTP(MailRequest request) {
        mailService.sendOTP(request);
    }

    @KafkaListener(topics = "booking", groupId = "booking-group")
    public void listenSendBookingMail(MailRequest request) {
        mailService.sendBookingMail(request);
    }

}
