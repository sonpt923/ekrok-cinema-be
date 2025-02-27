package com.example.subcripitonservice.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Data
@Getter
@Setter
@Entity
@Table(name = "user_subcription")
public class UserSubcription {

    @Id
    @Column(name = "subcription_id")
    private Long subcriptionId;

    @Id
    @Column(name = "user_id")
    private Long userId;

    // active, expired, cancelled
    @Column(name = "status")
    private Long status;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at")
    private Date updated_at;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "deleted_by")
    private String deletedBy;

}
