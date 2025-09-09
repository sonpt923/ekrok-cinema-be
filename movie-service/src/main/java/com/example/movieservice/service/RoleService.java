package com.example.movieservice.service;

import com.example.core.dto.response.ListDataResponse;
import com.example.movieservice.dto.request.RoleRequest;
import com.example.movieservice.entity.Role;

public interface RoleService {

    Role createRole(RoleRequest request);

    Role updateRole(RoleRequest request);

    ListDataResponse<Role> getRoles(RoleRequest request);

    Role getRole(Long id);

    Boolean deleteRole(Long id);



     

}
