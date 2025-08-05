package com.example.userservice.controller.PublicAPI;

import com.example.core.exception.ValidateException;
import com.example.core.utils.BaseConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping("/test")
    public ResponseEntity<Object> test() {
        return new ResponseEntity<>(Map.of("msg", "helllooo"), HttpStatus.OK);
    }

}
