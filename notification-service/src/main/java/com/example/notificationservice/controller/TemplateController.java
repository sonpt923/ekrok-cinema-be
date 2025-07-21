package com.example.notificationservice.controller;

import com.example.notificationservice.dto.request.TemplateRequest;
import com.example.notificationservice.dto.response.TemplateResponse;
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

    @PostMapping("create-template")
    public ResponseEntity<Object> createTemplate(@RequestBody TemplateRequest request) {
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTemplates(@RequestAttribute String id) {
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTemplate(@PathVariable String id, @RequestBody TemplateRequest request) {
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @DeleteMapping("delte-template")
    public ResponseEntity<Object> deleteTemplate(@PathVariable("id") String id){
        return new ResponseEntity<>(templateService.deleteTemplate(id), HttpStatus.OK);
    }

}
