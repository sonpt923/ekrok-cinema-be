package com.example.subcriptionservice.controller;

import com.example.subcriptionservice.service.SubcriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/subcription")
public class SubcriptionController {

    @Autowired
    private SubcriptionService subcriptionService;

    @PostMapping("/create-subcription")
    public ResponseEntity createPackage() {
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @GetMapping("/get-subcription")
    public ResponseEntity getPackage() {
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @PostMapping("/update-subcription")
    public ResponseEntity updatePackage() {
        return new ResponseEntity(null, HttpStatus.OK);
    }

}
