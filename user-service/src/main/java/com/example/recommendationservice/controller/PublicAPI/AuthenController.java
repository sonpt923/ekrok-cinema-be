package com.example.recommendationservice.controller.PublicAPI;

import com.example.config.EnableWrapResponse;
import com.example.recommendationservice.dto.request.UserRequest;
import com.example.recommendationservice.entity.User;
import com.example.recommendationservice.entity.google.GoogleInfo;
import com.example.recommendationservice.service.AuthenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableWrapResponse
@RequestMapping("/auth")
public class AuthenController {

    @Autowired
    private AuthenService authenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) throws Exception {
        return new ResponseEntity(authenService.login(user), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserRequest request) {
        return new ResponseEntity(authenService.register(request), HttpStatus.OK);
    }

    @PostMapping("/register-by-google")
    public ResponseEntity registerByGoogle(@RequestBody GoogleInfo userInfo) {
        return new ResponseEntity(authenService.loginByGoogle(userInfo), HttpStatus.OK);
    }

    @PostMapping("/login-by-google")
    public ResponseEntity loginByGoogle(@RequestBody  GoogleInfo userInfo) {
        return new ResponseEntity(authenService.registerByGoogle(userInfo), HttpStatus.OK);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity forgotPassword(@RequestBody UserRequest request) {
        return new ResponseEntity(authenService.forgotPassword(request), HttpStatus.OK);
    }

}
