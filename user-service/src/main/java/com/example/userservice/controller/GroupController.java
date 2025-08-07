package com.example.userservice.controller;

import com.example.userservice.dto.request.GroupRequest;
import com.example.userservice.entity.Group;
import com.example.userservice.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping("/create-group")
    public ResponseEntity createGroup(@RequestBody GroupRequest request, @RequestAttribute("X-Username") String username) {
        return new ResponseEntity(groupService.createGroup(request, username), HttpStatus.OK);
    }

    @PostMapping("/update-group")
    public ResponseEntity updateGroup(@RequestBody GroupRequest request, @RequestAttribute("X-Username") String username) {
        return new ResponseEntity(groupService.updateGroup(request, username), HttpStatus.OK);
    }

    @GetMapping("/get-group")
    public ResponseEntity getGroup(@RequestAttribute("group-id") Long groupId,  @RequestAttribute("X-Username") String username) {
        return new ResponseEntity(groupService.getGroup(groupId, username), HttpStatus.OK);
    }

    @PostMapping("/get-groups")
    public ResponseEntity getGroups(@RequestAttribute GroupRequest request,  @RequestAttribute("X-Username") String username) {
        return new ResponseEntity(groupService.getGroups(request, username), HttpStatus.OK);
    }

    @PostMapping("/delete-group")
    public ResponseEntity deleteGroup(@RequestAttribute("group-id") Long groupId,  @RequestAttribute("X-Username") String username) {
        return new ResponseEntity(groupService.deleteGroup(groupId, username), HttpStatus.OK);
    }

}
