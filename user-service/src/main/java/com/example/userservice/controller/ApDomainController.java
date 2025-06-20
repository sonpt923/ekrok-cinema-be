package com.example.userservice.controller;

import com.example.userservice.entity.ApDomain;
import com.example.userservice.service.ApDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ap-domain")
public class ApDomainController {

    @Autowired
    private ApDomainService apDomainService;

    @GetMapping("/get-ap-domain")
    public ResponseEntity getApDomainByCode(@RequestParam("code") String code, @RequestHeader("Authorization") String token) {
        return new ResponseEntity(apDomainService.getByCodeAndPermission(code, token), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateApDomain(@RequestBody ApDomain apDomain, @RequestHeader("Authorization") String token) {
        return new ResponseEntity(apDomainService.update(apDomain, token), HttpStatus.OK);
    }


}
