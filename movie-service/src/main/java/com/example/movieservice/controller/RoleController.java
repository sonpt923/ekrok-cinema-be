package com.example.roleService.controller;

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
    public ResponseEntity createMovie(@RequestBody RoleRequest request, @RequestHeader String username) {
        return new ResponseEntity(roleService.createMovie(request, username), HttpStatus.OK);
    }

    @PostMapping("/update-movie")
    public ResponseEntity updateMovie(@RequestBody RoleRequest request, @RequestHeader String username) {
        return new ResponseEntity(roleService.updateMovie(request, username), HttpStatus.OK);
    }

    @GetMapping("/get-movies")
    public ResponseEntity getMovies(@RequestBody RoleRequest request) {
        return new ResponseEntity(roleService.getMovies(request), HttpStatus.OK);
    }

    @GetMapping("/get-movie/{id}")
    public ResponseEntity getMovie(@RequestParam("id") Long id) {
        return new ResponseEntity(roleService.getMovie(id), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteMovie(@RequestAttribute Long id) {
        return new ResponseEntity(roleService.deleteMovie(id), HttpStatus.OK);
    }

}
