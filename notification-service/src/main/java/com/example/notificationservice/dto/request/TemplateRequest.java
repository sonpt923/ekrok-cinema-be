package com.example.notificationservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TemplateRequest {

    private String id;

    private String code;

    private String name;

    private String channel;

    private String subject;

    private String content;

    private Map<String, String> placeholders;

    private Integer page;

    private Integer pageSize;

}
