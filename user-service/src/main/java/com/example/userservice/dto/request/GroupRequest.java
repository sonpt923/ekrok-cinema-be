package com.example.userservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupRequest {

    private Long id;

    private String code;

    private String name;

    private Long parentId;

    private Boolean isDeleted;

    private Integer status;

    private String createdBy;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private String updatedBy;

    private String description;

    private List<RoleRequest> roleRequest;

    private Integer page;

    private Integer pageSize;

}
