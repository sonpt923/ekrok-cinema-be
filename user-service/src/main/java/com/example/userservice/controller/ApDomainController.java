package com.example.userservice.controller;

import com.example.userservice.dto.request.ApDomainRequest;
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

    @PostMapping("create-ap-domain")
    public ResponseEntity createApDomain(ApDomainRequest request) {
        return new ResponseEntity(apDomainService.createApDomain(request), HttpStatus.OK);
    }

    @PostMapping("/update-ap-domain")
    public ResponseEntity updateApDomain(ApDomainRequest request) {
        return new ResponseEntity(apDomainService.update(request), HttpStatus.OK);
    }

    @GetMapping("/get-ap-domain-by-code")
    public ResponseEntity getApDomain(@RequestParam("code") String code) {
        return new ResponseEntity(apDomainService.getByCode(code), HttpStatus.OK);
    }

    @GetMapping("/get-list-app-domain")
    public ResponseEntity getListApDomain(@RequestAttribute ApDomainRequest request) {
        return new ResponseEntity(apDomainService.getApDomainByCondition(request), HttpStatus.OK);
    }

    @PostMapping("/add-parent-to-app-domain")
    public ResponseEntity addParentToAppDomain(@RequestBody ApDomainRequest request) {
        return new ResponseEntity(null, HttpStatus.OK);
    }


}
