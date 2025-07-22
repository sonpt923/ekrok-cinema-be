package com.example.userservice.controller.PublicAPI;

import com.example.core.exception.ValidateException;
import com.example.core.utils.BaseConstant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping("/test")
    public ResponseEntity test() {
        throw new ValidateException(BaseConstant.ERORRS.LOGIC, "oke nhé cu");
    }

}
