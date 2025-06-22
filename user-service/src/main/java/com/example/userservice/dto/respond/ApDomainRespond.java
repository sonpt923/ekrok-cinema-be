package com.example.userservice.dto.respond;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApDomainRespond {

    private String type;

    private String code;

    private String name;

    private String description;

    private Integer status;

    private String value;

    private Long domainParentId;

    private String createdBy;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private String updatedBy;


}
