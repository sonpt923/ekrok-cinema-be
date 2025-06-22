package com.example.notificationservice.controller;

import com.example.notificationservice.dto.request.TemplateRequest;
import com.example.notificationservice.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @GetMapping("/get-templates")
    public ResponseEntity getAllTemplate(TemplateRequest templateRequest) {
        return new ResponseEntity(templateService.getTemplates(templateRequest), HttpStatus.OK);
    }

    @PostMapping("/create-template")
    public ResponseEntity createTemplate(@RequestBody TemplateRequest request) {
        return new ResponseEntity<>(templateService.createTemplate(request), HttpStatus.OK);
    }

    @PostMapping("/update-template")
    public ResponseEntity updateTemplate(@RequestBody TemplateRequest request) {
        return new ResponseEntity<>(templateService.updateTemplate(request), HttpStatus.OK);
    }

    @PostMapping("/delete-template")
    public ResponseEntity deleteTemplate(@RequestBody TemplateRequest request) {
        return new ResponseEntity<>(templateService.deleteTemplate(request), HttpStatus.OK);
    }


}
