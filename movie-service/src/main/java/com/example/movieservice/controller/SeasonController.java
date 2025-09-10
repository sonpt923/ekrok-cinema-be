package com.example.movieservice.controller;

import com.example.movieservice.dto.request.RoleRequest;
import com.example.movieservice.dto.request.SeasonRequest;
import com.example.movieservice.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seasion")
public class SeasonController {

    @Autowired
    private SeasonService seasonService;

    @PostMapping("/create-season")
    public ResponseEntity createRole(@RequestBody SeasonRequest request, @RequestHeader String username) {
        return new ResponseEntity(seasonService.createSeason(request), HttpStatus.OK);
    }

    @PostMapping("/update-season")
    public ResponseEntity updateRole(@RequestBody SeasonRequest request, @RequestHeader String username) {
        return new ResponseEntity(seasonService.updateSeason(request), HttpStatus.OK);
    }

    @GetMapping("/get-seasons")
    public ResponseEntity getRoles(@RequestBody SeasonRequest request) {
        return new ResponseEntity(seasonService.getSeasons(request), HttpStatus.OK);
    }

    @GetMapping("/get-season")
    public ResponseEntity getRole(@RequestParam Long id) {
        return new ResponseEntity(seasonService.getSeason(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete-season")
    public ResponseEntity deleteRole(@RequestParam Long id) {
        return new ResponseEntity(seasonService.deleteSeason(id), HttpStatus.OK);
    }

}
