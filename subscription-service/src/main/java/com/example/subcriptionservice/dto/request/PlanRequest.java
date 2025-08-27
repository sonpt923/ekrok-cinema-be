package com.example.subcriptionservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlanRequest {

    private Long id;

    private String code;

    private Long parentId;

    private String name;

    private String description;

    private BigDecimal price;

    private String currency;

    private Long duration;

    private Integer maxDevice;

    private String quality;

    private String resolution;

    private String createdBy;

    private String updatedBy;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private Boolean isActive;

    private Boolean isDeleted;

    private Long page;

    private Long pageSize;

}
