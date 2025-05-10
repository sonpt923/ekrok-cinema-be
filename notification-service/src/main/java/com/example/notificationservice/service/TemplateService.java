package com.example.notificationservice.service;


import com.example.notificationservice.dto.request.MailRequest;
import com.example.notificationservice.dto.request.TemplateRequest;
import com.example.notificationservice.model.Template;

public interface TemplateService {

    Object getTemplate(String id);

    Object getTemplates(TemplateRequest request);

    Object createTemplate(TemplateRequest request);

    Object updateTemplate(TemplateRequest request);

    Object deleteTemplate(TemplateRequest request);

}
