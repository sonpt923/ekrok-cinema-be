package com.example.userservice.service.impl;

import com.example.core.exception.ValidateException;
import com.example.core.i18n.Dictionary;
import com.example.core.utils.BaseConstant;
import com.example.core.utils.ObjectUtil;
import com.example.userservice.dto.request.GroupRequest;
import com.example.userservice.dto.request.RoleRequest;
import com.example.userservice.entity.Group;
import com.example.userservice.entity.Role;
import com.example.userservice.fiegn.NotificationFeign;
import com.example.userservice.repository.GroupRepository;
import com.example.userservice.repository.customize.GroupRepoCustom;
import com.example.userservice.service.GroupRoleService;
import com.example.userservice.service.GroupService;
import com.example.userservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupRoleService groupRoleService;

    @Autowired
    private GroupRepoCustom groupRepoCustom;

    @Autowired
    private Dictionary dic;

    @Autowired
    private RoleService roleService;


    @Autowired
    private NotificationFeign notificationFeign;

    @Override
    @Transactional
    public Object createGroup(GroupRequest request, String username) {
        validateCreate(request);
        Group group = Group.builder()
                .code(request.getCode())
                .name(request.getName())
                .description(request.getDescription())
                .createdAt(Timestamp.from(Instant.now()))
                .createdBy(username)
                .isDeleted(false)
                .status(request.getStatus())
                .parentCode(request.getParentCode())
                .build();
        group = groupRepository.save(group);
        List<Role> roles = new ArrayList<>();
        for (RoleRequest roleRequest : request.getRoleRequest()) {
            Role role = roleService.findByRoleByCodeAndIsDeleted(roleRequest.getCode(), false);
            if (!ObjectUtil.objectIsNullorEmpty(role)) {
                roles.add(role);
            }
        }
        return groupRoleService.createByGroupAndRole(List.of(group), roles);
    }

    @Override
    public Object updateGroup(GroupRequest request) {
        validateUpdate(request);
        return null;
    }

    @Override
    public Object getGroups(GroupRequest request) {
        request.setIsDeleted(false);
        return groupRepoCustom.findGroups(request);
    }

    @Override
    public Object deleteGroup(Long id) {
        return null;
    }

    @Override
    public Object getGroup(Long id) {
        return null;
    }

    private void validateCreate(GroupRequest request) {

        if (ObjectUtil.objectIsNullorEmpty(request.getCode())) {
            throw new ValidateException("", "");
        }

        if (ObjectUtil.objectIsNullorEmpty(request.getName())) {
            throw new ValidateException("", "");
        }

        Group group = groupRepository.findByCodeAndStatus(request.getCode(), false);
        if (group != null) {
            throw new ValidateException(BaseConstant.ERORRS.DATA_USING, dic.get(""));
        }

        if (ObjectUtil.objectIsNullorEmpty(request.getCode())) {

        }

    }

    private void validateUpdate(GroupRequest request) {

    }

}
