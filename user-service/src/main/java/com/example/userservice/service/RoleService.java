package com.example.userservice.service;

import com.example.userservice.entity.Role;

public interface RoleService {

    Role findByRoleByCodeAndIsDeleted(String code, Boolean isDeleted);

}
