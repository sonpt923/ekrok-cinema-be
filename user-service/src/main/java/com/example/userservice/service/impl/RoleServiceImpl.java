package com.example.userservice.service.impl;

import com.example.userservice.dto.request.GroupRequest;
import com.example.userservice.entity.Role;
import com.example.userservice.repository.RoleRepository;
import com.example.userservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepo;

    @Override
    public Role findByRoleByCodeAndIsDeleted(String code, Boolean isDeleted) {
        return roleRepo.findRoleByCodeAndIsDeleted(code, isDeleted);
    }

    @Override
    public Object createRole(GroupRequest request, String username) {
        return null;
    }

    @Override
    public Object updateRole(GroupRequest request, String username) {
        return null;
    }

    @Override
    public Object getRoles(GroupRequest request, String username) {
        return null;
    }

    @Override
    public Object deleteRole(Long id, String username) {
        return null;
    }

    @Override
    public Object getRole(Long id, String username) {
        return null;
    }
}
