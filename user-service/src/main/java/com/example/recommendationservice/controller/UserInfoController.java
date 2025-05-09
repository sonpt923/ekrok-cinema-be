package com.example.recommendationservice.controller;

import com.example.config.EnableWrapResponse;
import com.example.recommendationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableWrapResponse
@RequestMapping("/")
public class UserInfoController {

    @Autowired
    private UserService userService;

    @GetMapping("/info")
    public ResponseEntity getUserInfo() {
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @PostMapping("/change-password")
    public ResponseEntity changePassword() {
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @PostMapping("/clear-session")
    public ResponseEntity clearSession(@RequestBody String[] session){
        return new ResponseEntity(userService.revolkSession(session), HttpStatus.OK);
    }

    @PostMapping("/update-info")
    public ResponseEntity updateUserInfo() {
        return new ResponseEntity(null, HttpStatus.OK);
    }

}
