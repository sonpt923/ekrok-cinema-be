package com.example.userservice.service;

import com.example.userservice.entity.Group;
import com.example.userservice.entity.User;

import java.util.List;

public interface GroupUserService {

    Object createByGroupsAndUsers(List<Group> groups, List<User> users);

    Object createGroupUser(Group group, User user);

}
