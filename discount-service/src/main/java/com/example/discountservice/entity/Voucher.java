package com.example.discountservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "voucher")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Voucher {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "campaign_id")
    private Long campaignId;

    @Column(name = "code")
    private String code;

    @Column(name = "code_type")
    private String codeType;

    // neu gift thi co 1 user cu the
    @Column(name = "assigned_user_id")
    private Long assignedUserId;

    // neu gift thi chi cho user day dung
    @Column(name = "strict_binding")
    private Boolean strictBinding;

    @Column(name = "max_count")
    private Long maxCount;

    @Column(name = "max_usage")
    private Long maxUsage;

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
