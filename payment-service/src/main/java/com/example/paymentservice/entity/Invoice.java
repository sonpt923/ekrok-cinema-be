package com.example.paymentservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

// Hóa đơn
@Entity
@Table(name = "invoice")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Invoice {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID code;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "package_id")
    private Long packageId;

    @Column(name = "amount")
    private BigDecimal amount;

}
