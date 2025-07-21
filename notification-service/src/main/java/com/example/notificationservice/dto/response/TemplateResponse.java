package com.example.notificationservice.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class TemplateResponse {

    private String id;

    private String code;

    private String subject;

    private String content;

    private String channel;

    private Map<String, String> defaultPlaceholders;

    private boolean isActive;

}
