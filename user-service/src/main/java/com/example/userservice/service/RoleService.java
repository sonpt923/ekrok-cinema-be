package com.example.userservice.service;

import com.example.userservice.dto.request.RoleRequest;

public interface RoleService {

    Object createRole(RoleRequest request);

    Object updateRole(RoleRequest request);

    Object delete(RoleRequest request);

}
