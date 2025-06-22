package com.example.notificationservice.service.impl;

import com.example.notificationservice.dto.request.MailOTPRequest;
import com.example.notificationservice.dto.request.MailRequest;
import com.example.notificationservice.model.Template;
import com.example.notificationservice.repository.MailTemplateRepository;
import com.example.notificationservice.repository.customize.MailTemplateRepositoryCustom;
import com.example.notificationservice.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private MailTemplateRepository mailTemplateRepository;

    @Autowired
    private MailTemplateRepositoryCustom mailTemplateRepositoryCustom;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private void validateCreate(Template template) {
    }

    @Override
    public Object sendOTP(MailOTPRequest request) {
        return null;
    }
}
