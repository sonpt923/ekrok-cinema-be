package com.example.subcriptionservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "history")
public class History {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subcription_id")
    private Long subcriptionId;

    @Column(name = "action")
    private String action;

    @Column(name = "actor")
    private String actor;

    @Column(name = "note")
    private String note;

    @Column(name = "action_time")
    private Timestamp actionTime;
    
}
