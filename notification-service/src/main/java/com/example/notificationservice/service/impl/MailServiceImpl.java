package com.example.notificationservice.service.impl;

import com.example.exception.ValidationException;
import com.example.notificationservice.dto.request.MailRequest;
import com.example.notificationservice.model.Template;
import com.example.notificationservice.repository.TemplateRepository;
import com.example.notificationservice.repository.customize.TemplateRepoCustom;
import com.example.notificationservice.service.MailService;
import com.example.service.MydictionaryService;
import com.example.utils.BaseConstants;
import com.example.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private TemplateRepoCustom templateRepoCustom;

    @Autowired
    private MydictionaryService dictionaryService;

    @Override
    public Object getTemplate(Long id) {
        return templateRepository.findById(id).get();
    }

    @Override
    public Object getTemplates(MailRequest request) {
        return null;
    }

    @Override
    public Object createTemplate(Template request) {
        String code = request.getCode();
        if (StringUtil.stringIsNullOrEmty(code)) {
            code = StringUtil.generateString(9);
        }
        request.setCode(code);
        return templateRepository.save(request);
    }

    @Override
    public Object updateTemplate(MailRequest request) {
        return null;
    }

    @Override
    public Object deleteTemplate(MailRequest request) {
        return null;
    }

    @Override
    public Object sendOTP(MailRequest request) {
        return null;
    }

    private void validaetCreateTemplate(Template template) {
        if (StringUtil.stringIsNullOrEmty(template.getSubject())) {
            throw new ValidationException(BaseConstants.ERROR_NOT_NULL, dictionaryService.get("ERROR_NOT_NULL"));
        }

        if (StringUtil.stringIsNullOrEmty(template.getContent())) {
            throw new ValidationException(BaseConstants.ERROR_NOT_NULL, dictionaryService.get("ERROR_NOT_NULL"));
        }

    }
}
