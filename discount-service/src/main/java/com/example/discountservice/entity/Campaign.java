package com.example.discountservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "campaign")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Campaign {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    // 'DISCOUNT','GIFT','REFERRAL','AUTOMATIC'
    @Column(name = "campaign_type")
    private String campaignType;

    @Column(name = "scope_type")
    private String scopeType;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "scope_value")
    private String scopeValue;

    @Column(name = "max_usage")
    private Long maxUsage;

    @Column(name = "max_usage_per_user")
    private Long maxUsagePerUser;

    // co cho cong don khong
    @Column(name = "stackable")
    private Boolean stackable;

    @Column(name = "status")
    private Long status;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at")
    private String updatedAt;

    @Column(name = "updaetd_by")
    private String updatedBy;

    @Column(name = "is_deleted")
    private Boolean isDeleted;


}
