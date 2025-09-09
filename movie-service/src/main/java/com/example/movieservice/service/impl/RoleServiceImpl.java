package com.example.movieservice.service.impl;

import com.example.core.dto.response.ListDataResponse;
import com.example.movieservice.dto.request.RoleRequest;
import com.example.movieservice.entity.Role;
import com.example.movieservice.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public Role createRole(RoleRequest request) {
        return null;
    }

    @Override
    public Role updateRole(RoleRequest request) {
        return null;
    }

    @Override
    public ListDataResponse<Role> getRoles(RoleRequest request) {
        return null;
    }

    @Override
    public Role getRole(Long id) {
        return null;
    }

    @Override
    public Boolean deleteRole(Long id) {
        return null;
    }
}
