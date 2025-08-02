package com.example.userservice.controller;

import com.example.userservice.dto.request.PermissionRequest;
import com.example.userservice.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping("/create-permission")
    public ResponseEntity createPermission(@RequestBody PermissionRequest request){
        return new ResponseEntity(permissionService.createPermission(request), HttpStatus.CREATED);
    }

    @PostMapping("/update-permission")
    public ResponseEntity updatePermision(@RequestBody PermissionRequest request){
        return new ResponseEntity(permissionService.updatePermission(request), HttpStatus.OK);
    }

    @DeleteMapping("/delete-permission")
    public ResponseEntity deletePermision(@RequestAttribute Long id){
        return new ResponseEntity(permissionService.deletePermission(id), HttpStatus.OK);
    }

}
