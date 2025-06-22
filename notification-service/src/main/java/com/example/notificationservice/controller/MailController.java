package com.example.notificationservice.controller;

import com.example.notificationservice.dto.request.MailOTPRequest;
import com.example.notificationservice.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping("/send-otp")
    ResponseEntity sendOTP(@RequestBody MailOTPRequest otpRequest) {
        return new ResponseEntity(mailService.sendOTP(otpRequest), HttpStatus.OK);
    }

}
