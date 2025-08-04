package com.example.userservice.service.impl;

import com.example.core.exception.ValidateException;
import com.example.core.i18n.Dictionary;
import com.example.core.utils.BaseConstant;
import com.example.core.utils.ObjectUtil;
import com.example.userservice.entity.Group;
import com.example.userservice.entity.GroupRole;
import com.example.userservice.entity.Role;
import com.example.userservice.repository.GroupRoleRepository;
import com.example.userservice.service.GroupRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class GroupRoleServiceImpl implements GroupRoleService {

    @Autowired
    private GroupRoleRepository groupRoleRepository;

    @Autowired
    private Dictionary dic;

    @Override
    public Object createGroupRole(Group group, Role role) {
        validateCreate(group, role);
        GroupRole groupRole = GroupRole.builder()
                .roleId(role.getId())
                .groupId(group.getId())
                .createdAt(Timestamp.from(Instant.now()))
                .createdBy(group.getCreatedBy())
                .build();
        return null;
    }

    private void validateCreate(Group group, Role role) {
        if (ObjectUtil.objectIsNullorEmpty(group)) {
            throw new ValidateException(BaseConstant.ERORRS.NOT_NULL, dic.get(""));
        }
    }

    @Override
    public Object createByListRole(Group group, Role role) {
        return null;
    }

    @Override
    public Object createByListGroup(List<Group> groups, Role role) {
        return null;
    }
}
