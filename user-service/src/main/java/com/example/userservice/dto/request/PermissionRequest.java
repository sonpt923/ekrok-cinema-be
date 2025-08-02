package com.example.userservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PermissionRequest {

    private String code;

    private String method;

    private String path;

    private Long roleId;

    private Boolean isDeleted;

    private Long page;

    private Long pageSize;

}
