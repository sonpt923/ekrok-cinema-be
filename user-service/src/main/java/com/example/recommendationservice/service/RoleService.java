package com.example.recommendationservice.service;

import com.example.recommendationservice.dto.request.RoleRequest;
import com.example.recommendationservice.entity.Role;

public interface RoleService {

    Object createRole(RoleRequest request);

    Object updateRole(RoleRequest request);

    Object delete(RoleRequest request);

}
