package com.example.userservice.service;

import com.example.userservice.dto.request.PermissionRequest;

public interface PermissionService {

    Object createPermission(PermissionRequest request);

    Object updatePermission(PermissionRequest request);

    Object deletePermission(Long id);

}
