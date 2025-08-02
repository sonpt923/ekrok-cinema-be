package com.example.userservice.service.impl;

import com.example.core.exception.SystemException;
import com.example.core.exception.ValidateException;
import com.example.core.i18n.Dictionary;
import com.example.core.utils.BaseConstant;
import com.example.userservice.dto.request.PermissionRequest;
import com.example.userservice.entity.Permission;
import com.example.userservice.repository.PermissionRepository;
import com.example.userservice.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private Dictionary dic;

    @Override
    @Transactional
    public Object createPermission(PermissionRequest request) {
        try {
            validateCreatePermission(request);
            Permission permission = Permission.builder()
                    .roleId(request.getRoleId()).path(request.getPath())
                    .isDeleted(false).method(request.getMethod()).build();
            return permissionRepository.save(permission);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ValidateException("", "");
        }
    }

    @Override
    @Transactional
    public Object updatePermission(PermissionRequest request) {
        try {
            validateUpdatePermission(request);
            Permission permission = permissionRepository.findById(request.getRoleId()).orElseThrow(
                    () -> new ValidateException("", ""));
            permission.setMethod(request.getMethod());
            permission.setPath(request.getPath());
            permission.setRoleId(request.getRoleId());
            return permissionRepository.save(permission);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SystemException("", "");
        }
    }

    @Override
    @Transactional
    public Object deletePermission(Long id) {
        if (id == null) {
            throw new ValidateException(BaseConstant.ERORRS.NOT_NULL, String.format(dic.get("SYS001")));
        }
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new ValidateException(BaseConstant.ERORRS.DATA_NOT_FOUND, "khoong tim thay {} " + id));
        permission.setIsDeleted(true);
        return permissionRepository.save(permission);
    }

    private void validateCreatePermission(PermissionRequest request) {

    }

    private void validateUpdatePermission(PermissionRequest request) {

    }

}
