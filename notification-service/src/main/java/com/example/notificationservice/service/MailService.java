package com.example.notificationservice.service;

import com.example.notificationservice.dto.request.MailRequest;
import com.example.notificationservice.model.Template;

public interface MailService {

    Object getTemplate(Long id);

    Object getTemplates(MailRequest request);

    Object createTemplate(Template request);

    Object updateTemplate(MailRequest request);

    Object deleteTemplate(MailRequest request);

    Object sendOTP(MailRequest request);

}
