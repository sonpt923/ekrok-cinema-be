package com.example.userservice.controller;

import com.example.config.EnableWrapResponse;
import com.example.userservice.dto.request.UserRequest;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableWrapResponse
@RequestMapping("/user-info")
public class UserInfoController {

    @Autowired
    private UserService userService;

    @GetMapping("/info")
    public ResponseEntity getUserInfo(@RequestHeader("username") String username) {
        return new ResponseEntity(userService.userInfo(username), HttpStatus.OK);
    }

    @PostMapping("/change-password")
    public ResponseEntity changePassword(@RequestHeader("authen-key") String authenKey) {
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @PostMapping("/clear-session")
    public ResponseEntity clearSession(@RequestBody String[] session, @RequestHeader("authen-key") String authenKey){
        return new ResponseEntity(userService.revolkSession(session), HttpStatus.OK);
    }

    @PostMapping("/update-info")
    public ResponseEntity updateUserInfo() {
        return new ResponseEntity(null, HttpStatus.OK);
    }

}
