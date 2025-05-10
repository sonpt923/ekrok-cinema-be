package com.example.userservice.controller;

import com.example.userservice.dto.request.ApDomainRequest;
import com.example.userservice.service.ApDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ap-domain")
public class ApDomainController {

    @Autowired
    private ApDomainService apDomainService;

    @PostMapping("create-ap-domain")
    public ResponseEntity createApDomain(ApDomainRequest request) {
        return new ResponseEntity(apDomainService.createApDomain(null), HttpStatus.OK);
    }

    @PostMapping("/update-ap-domain")
    public ResponseEntity updateApDomain(ApDomainRequest request) {
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @GetMapping("/get-ap-domain-by-code")
    public ResponseEntity getApDomain(ApDomainRequest request){
        return new ResponseEntity(apDomainService.getByCode(request.getCode()), HttpStatus.OK);
    }

    @GetMapping("/get-list-app-domain")
    public ResponseEntity getListApDomain(ApDomainRequest request){
        return new ResponseEntity(null, HttpStatus.OK);
    }

}
