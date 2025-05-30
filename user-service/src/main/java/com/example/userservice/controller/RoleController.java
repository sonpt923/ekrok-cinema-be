package com.example.userservice.controller;

import com.example.userservice.dto.request.RoleRequest;
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
    public ResponseEntity createRole(@RequestBody RoleRequest demo, @RequestHeader("Authorization") String token) {
        return new ResponseEntity(roleService.createRole(demo), HttpStatus.OK);
    }

}
