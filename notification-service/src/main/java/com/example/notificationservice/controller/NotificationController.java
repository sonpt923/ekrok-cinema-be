package com.example.notificationservice.controller;

import com.example.notificationservice.model.Notification;
import com.example.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/get-notify")
    public ResponseEntity getNotifyByUsername() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity createNotify(@RequestBody Notification notification) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/update-status")
    public ResponseEntity updateNotify(@RequestBody Notification notification) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
