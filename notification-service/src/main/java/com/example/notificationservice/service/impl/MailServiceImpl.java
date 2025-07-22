package com.example.notificationservice.service.impl;

import com.example.notificationservice.repository.TemplateRepository;
import com.example.notificationservice.service.MailService;
import com.example.notificationservice.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateService templateService;

//    public void sendMailFromTemplate(String templateCode, String toEmail, Map<String, String> data) {
//        Template template = templateRepo.findByCodeAndIsActive(templateCode, true)
//                .orElseThrow(() -> new RuntimeException("Template not found"));
//
//        String subject = resolvePlaceholders(template.getSubject(), data, template.getDefaultPlaceholders());
//        String body = resolvePlaceholders(template.getContent(), data, template.getDefaultPlaceholders());
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(toEmail);
//        message.setSubject(subject);
//        message.setText(body);
//        message.setFrom("your-verified-email@yourdomain.com"); // phải verify ở SES
//
//        mailSender.send(message);
//    }

    private String resolvePlaceholders(String text, Map<String, String> data, Map<String, String> defaults) {
        Pattern pattern = Pattern.compile("\\{\\{(.*?)}}");
        Matcher matcher = pattern.matcher(text);
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            String key = matcher.group(1).trim();
            String value = data.getOrDefault(key, defaults != null ? defaults.getOrDefault(key, "") : "");
            matcher.appendReplacement(buffer, value);
        }

        matcher.appendTail(buffer);
        return buffer.toString();
    }

}
