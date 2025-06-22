package com.example.notificationservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MailRequest {

    private Long id;

    private String code;

    private String name;

    private String channel;

    private Long page;

    private Long pageSize;

}
