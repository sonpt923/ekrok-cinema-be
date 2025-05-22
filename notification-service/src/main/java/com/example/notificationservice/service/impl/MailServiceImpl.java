package com.example.notificationservice.service.impl;

import com.example.notificationservice.dto.request.MailOTPRequest;
import com.example.notificationservice.dto.request.MailRequest;
import com.example.notificationservice.repository.TemplateRepository;
import com.example.notificationservice.service.MailService;
import com.example.notificationservice.util.Constant;
import com.example.service.MydictionaryService;
import com.example.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import java.util.Map;

@Service
public class MailServiceImpl implements MailService {

    @Value("${}")
    private String sender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private TemplateRepository templateRepository;


    @Autowired
    private MydictionaryService dictionaryService;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public Object sendOTP(MailOTPRequest request) {
        StringBuilder otpSession = new StringBuilder(Constant.OTP + ":");
        switch (request.getType()) {
            case 1: {
                otpSession.append("register:" + request.getUsername());
                Long otp = Long.valueOf(StringUtil.generateString(Constant.OTP_LENGTH));
                Map<String, Object> otpRedis = (Map<String, Object>) redisTemplate.opsForValue().getAndSet(otpSession, otp);
                if (otpRedis == null) {
                    redisTemplate.opsForValue().
                }
            }
            case 2: {

            }
            case 3: {

            }
        }
        return null;
    }

    public Object sendMail(MailRequest mailRequest) {
//        try {
//            MimeMessage message = javaMailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//
//            helper.setFrom(sender, "DOUBLE SHOP");
//            helper.setSubject("TAO TAI KHOAN");
//
//
//            Context context = new Context();
////            context.setVariable("account", customer.getUsername());
////            context.setVariable("password", passwordEncoder.encode(customer.getPassword()));
//
//            String template = templateEngine.process("create-account", context);
//            helper.setText(template, true);
//
//            javaMailSender.send(message);
//            return BaseConstants.SUCCESS;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return e.getMessage();
//        }
    }

}
