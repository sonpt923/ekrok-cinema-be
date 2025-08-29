package com.example.subcriptionservice.controller;

import com.example.subcriptionservice.dto.request.PlanRequest;
import com.example.subcriptionservice.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private PlanService planService;

    @PostMapping("/create-plan")
    public ResponseEntity createPlan(@RequestBody PlanRequest request) {
        return new ResponseEntity(planService.createPlan(request), HttpStatus.CREATED);
    }

    @GetMapping("/get-plan/{id}")
    public ResponseEntity getPlan(@PathVariable("id") Long id) {
        return new ResponseEntity(planService.getPlan(id), HttpStatus.OK);
    }

    @GetMapping("/get-plans")
    public ResponseEntity getPlans(@RequestAttribute PlanRequest request) {
        return new ResponseEntity(planService.getPlans(request), HttpStatus.OK);
    }

    @PostMapping("/update-plan")
    public ResponseEntity updatePlan(@RequestBody PlanRequest request) {
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @DeleteMapping("/delete-plan")
    public ResponseEntity deletePlan(@PathVariable("id") Long id){
        return new ResponseEntity(null, HttpStatus.OK);
    }

}
