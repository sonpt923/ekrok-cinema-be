package com.example.userservice.controller;

import com.example.userservice.dto.request.GroupRequest;
import com.example.userservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/create-role")
    public ResponseEntity createGroup(@RequestBody GroupRequest request, @RequestAttribute("X-Username") String username) {
        return new ResponseEntity(roleService.createRole(request, username), HttpStatus.OK);
    }

    @PostMapping("/update-role")
    public ResponseEntity updateGroup(@RequestBody GroupRequest request, @RequestAttribute("X-Username") String username) {
        return new ResponseEntity(roleService.updateRole(request, username), HttpStatus.OK);
    }

    @GetMapping("/get-role")
    public ResponseEntity getGroup(@RequestAttribute("group-id") Long groupId,  @RequestAttribute("X-Username") String username) {
        return new ResponseEntity(roleService.getRole(groupId, username), HttpStatus.OK);
    }

    @PostMapping("/get-roles")
    public ResponseEntity getGroups(@RequestAttribute GroupRequest request,  @RequestAttribute("X-Username") String username) {
        return new ResponseEntity(roleService.getRoles(request, username), HttpStatus.OK);
    }

    @PostMapping("/delete-role")
    public ResponseEntity deleteGroup(@RequestAttribute("group-id") Long groupId,  @RequestAttribute("X-Username") String username) {
        return new ResponseEntity(roleService.deleteRole(groupId, username), HttpStatus.OK);
    }

}
