package com.example.discountservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "benefit")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Benefit {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "campaign_id")
    private Long campaignId;

    // percent, amount, days,
    @Column(name = "benefit_type")
    private String benefitType;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "priority")
    private Long priority;

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
