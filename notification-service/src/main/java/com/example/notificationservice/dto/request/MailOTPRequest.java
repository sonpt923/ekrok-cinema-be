package com.example.notificationservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MailOTPRequest {

    private String username;

    private String firstName;

    private String LastName;

    // reset, delete...
    private Integer type;

}
