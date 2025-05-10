package com.example.notificationservice.service.impl;

import com.example.exception.ValidationException;
import com.example.notificationservice.dto.request.MailOTPRequest;
import com.example.notificationservice.dto.request.MailRequest;
import com.example.notificationservice.model.Template;
import com.example.notificationservice.repository.TemplateRepository;
import com.example.notificationservice.service.MailService;
import com.example.service.MydictionaryService;
import com.example.utils.BaseConstants;
import com.example.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private TemplateRepository templateRepository;


    @Autowired
    private MydictionaryService dictionaryService;


    // TODO
    @Override
    public Object sendOTP(MailOTPRequest request) {
        return null;
    }
}
