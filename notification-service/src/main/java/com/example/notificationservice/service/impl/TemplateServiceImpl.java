package com.example.notificationservice.service.impl;

import com.example.core.exception.BusinessException;
import com.example.core.exception.ValidateException;
import com.example.notificationservice.dto.request.TemplateRequest;
import com.example.notificationservice.model.Template;
import com.example.notificationservice.repository.TemplateRepository;
import com.example.notificationservice.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class TemplateServiceImpl implements TemplateService {


    @Autowired
    private TemplateRepository templateRepo;

    @Override
    public Object getTemplate(String id) {
        return null;
    }

    @Override
    public Object getTemplates(TemplateRequest request) {
        return null;
    }

    @Override
    public Object createTemplate(TemplateRequest request) {
        validateCreate(request);
        Template template = templateRepo.save(Template.builder()
                .code(request.getCode())
                .name(request.getName())
                .subject(request.getSubject())
                .content(request.getContent())
                .channel(request.getChannel())
                .placeholders(request.getPlaceholders())
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .isActive(true)
                .isDeleted(false)
                .build());
        return template;
    }

    @Override
    public Object updateTemplate(TemplateRequest request) {
        Template template = templateRepo.findById(request.getId()).get();

        template.setSubject(request.getSubject());
        template.setContent(request.getContent());
        template.setChannel(request.getChannel());
        template.setPlaceholders(request.getPlaceholders());
        template.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        templateRepo.save(template);
        return null;
    }

    @Override
    public Object deleteTemplate(String id) {
        Template template = templateRepo.findById(id).get();
        if (template == null && template.getIsDeleted() == false) {
            throw new ValidateException("");
        }
        template.setIsDeleted(true);
        template = templateRepo.save(template);
        if (template.getIsDeleted() == true) {
            return true;
        }
        return false;
    }

    private void validateCreate(TemplateRequest request) {

        if (templateRepo.findTemplateByCodeAndIsDeleted(request.getCode(), false) != null) {
            throw new BusinessException("");
        }

    }

}
