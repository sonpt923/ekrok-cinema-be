package com.example.userservice.service;

import com.example.userservice.dto.request.GroupRequest;
import com.example.userservice.entity.Role;

public interface RoleService {

    Role findByRoleByCodeAndIsDeleted(String code, Boolean isDeleted);

    Object createRole(GroupRequest request, String username);

    Object updateRole(GroupRequest request, String username);

    Object getRoles(GroupRequest request, String username);

    Object deleteRole(Long id, String username);

    Object getRole(Long id, String username);
}
