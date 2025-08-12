package com.example.userservice.service.impl;

import com.example.userservice.entity.*;
import com.example.userservice.repository.GroupRepository;
import com.example.userservice.repository.GroupUserRepository;
import com.example.userservice.service.GroupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class GroupUserServiceImpl implements GroupUserService {

    @Autowired
    private GroupUserRepository groupUserRepo;

    @Override
    public Object createByGroupsAndUsers(List<Group> groups, List<User> users) {
        validateCreate(groups, users);
        List<GroupUser> groupUsers = new ArrayList<>();
        for (Group group : groups) {
            for (User user : users) {
                GroupUser groupUser = GroupUser.builder()
                        .userId(user.getId())
                        .groupId(group.getId())
                        .createdAt(Timestamp.from(Instant.now()))
                        .createdBy(group.getCreatedBy())
                        .build();
                groupUsers.add(groupUser);
            }
        }
        return groupUserRepo.saveAll(groupUsers);
    }

    @Override
    public Object createGroupUser(Group group, User user) {
        return null;
    }


    private void validateCreate(List<Group> groups, List<User> users){

    }

}
