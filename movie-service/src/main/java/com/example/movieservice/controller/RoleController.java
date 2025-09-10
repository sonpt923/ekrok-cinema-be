package com.example.movieservice.controller;

import com.example.movieservice.dto.request.RoleRequest;
import com.example.movieservice.service.RoleService;
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
    public ResponseEntity createRole(@RequestBody RoleRequest request, @RequestHeader String username) {
        return new ResponseEntity(roleService.createRole(request), HttpStatus.OK);
    }

    @PostMapping("/update-role")
    public ResponseEntity updateRole(@RequestBody RoleRequest request, @RequestHeader String username) {
        return new ResponseEntity(roleService.updateRole(request), HttpStatus.OK);
    }

    @GetMapping("/get-roles")
    public ResponseEntity getRoles(@RequestBody RoleRequest request) {
        return new ResponseEntity(roleService.getRoles(request), HttpStatus.OK);
    }

    @GetMapping("/get-role")
    public ResponseEntity getRole(@RequestParam Long id) {
        return new ResponseEntity(roleService.getRole(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete-role")
    public ResponseEntity deleteRole(@RequestParam Long id) {
        return new ResponseEntity(roleService.deleteRole(id), HttpStatus.OK);
    }

}
