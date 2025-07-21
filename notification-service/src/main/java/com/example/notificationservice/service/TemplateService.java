package com.example.notificationservice.service;

import com.example.notificationservice.dto.request.TemplateRequest;

public interface TemplateService {

    Object getTemplate(String id);

    Object getTemplates(TemplateRequest request);

    Object createTemplate(TemplateRequest request);

    Object updateTemplate(TemplateRequest request);

    Object deleteTemplate(String id);
}
