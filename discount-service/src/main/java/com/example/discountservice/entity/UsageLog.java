package com.example.discountservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "usage_log")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsageLog {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "campaign_id")
    private Long campaignId;

    @Column(name = "voucher_id")
    private Long voucherId;

    @Column(name = "benefit_value")
    private BigDecimal benefitValue;

    @Column(name = "used_at")
    private String usedAt;

    @Column(name = "rollback_flag")
    private Boolean rollbackFlag;




}
