package com.example.userservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApDomainRequest {

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

    private Boolean deleted;

    private Integer page;

    private Integer pageSize;

}
