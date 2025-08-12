package com.example.userservice.service;

import com.example.userservice.entity.Group;
import com.example.userservice.entity.Role;

import java.util.List;

public interface GroupRoleService {

    Object createByGroupAndRole(List<Group> groups, List<Role> roles);

    Object updateByGroupAndRole(List<Group> groups, List<Role> roles);

    Object deleteByGroupAndRole(List<Group> groups, List<Role> roles);

}
