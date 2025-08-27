package com.example.subcriptionservice.controller;

import com.example.subcriptionservice.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @PostMapping("/create-history")
    public ResponseEntity createHistory() {
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @GetMapping("/get-history")
    public ResponseEntity getHistory() {
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @GetMapping("/gets-histories")
    public ResponseEntity getHistories() {
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @PostMapping("/update-history")
    public ResponseEntity updateHistory() {
        return new ResponseEntity(null, HttpStatus.OK);
    }

}
