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
import com.example.userservice.service.GroupService;
import com.example.userservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class GroupRoleServiceImpl implements GroupRoleService {

    @Autowired
    private GroupRoleRepository groupRoleRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private Dictionary dic;


    @Override
    public Object createByGroupAndRole(List<Group> groups, List<Role> roles) {
        validateCreate(groups, roles);
        List<GroupRole> groupRoles = new ArrayList<>();
        for (Group group : groups) {
            for (Role role : roles) {
                GroupRole groupRole = GroupRole.builder()
                        .roleId(role.getId())
                        .groupId(group.getId())
                        .createdAt(Timestamp.from(Instant.now()))
                        .createdBy(group.getCreatedBy())
                        .build();
                groupRoles.add(groupRole);
            }
        }
        return groupRoleRepository.saveAll(groupRoles);
    }

    private void validateCreate(List<Group> groups, List<Role> roles) {
        if (ObjectUtil.objectIsNullorEmpty(groups)) {
            throw new ValidateException(BaseConstant.ERORRS.NOT_NULL, dic.get(""));
        }

        if (ObjectUtil.objectIsNullorEmpty(roles)) {
            throw new ValidateException(BaseConstant.ERORRS.NOT_NULL, dic.get(""));
        }



    }


}
