package com.example.notificationservice.service.impl;

import com.example.notificationservice.dto.request.MailRequest;
import com.example.notificationservice.dto.request.TemplateRequest;
import com.example.notificationservice.model.Template;
import com.example.notificationservice.repository.TemplateRepository;
import com.example.notificationservice.service.TemplateService;
import com.example.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateRepository templateRepository;


    @Override
    public Object getTemplate(String id) {
        return templateRepository.findById(id).get();
    }

    @Override
    public Object getTemplates(TemplateRequest request) {
        return templateRepository.findAll();
    }

    @Override
    public Object createTemplate(TemplateRequest request) {
        String code = request.getCode();
        if (StringUtil.stringIsNullOrEmty(code)) {
            code = StringUtil.generateString(9);
        }
        request.setCode(code);
        return templateRepository.save(null);
    }

    // TODO
    @Override
    public Object updateTemplate(TemplateRequest request) {
        return null;
    }

    // TODO
    @Override
    public Object deleteTemplate(TemplateRequest request) {
        return null;
    }
}
