package com.example.movieservice.controller;

import com.example.movieservice.dto.request.CastRequest;
import com.example.movieservice.entity.Cast;
import com.example.movieservice.service.CastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cast")
public class CastController {

    @Autowired
    private CastService castService;

    @PostMapping("/create-cast")
    public ResponseEntity createCast(@RequestBody CastRequest request, @RequestHeader("Authorization") String token) {
        return new ResponseEntity(castService.createCast(request), HttpStatus.CREATED);
    }

    @PostMapping("/update-cast")
    public ResponseEntity updateCast(@RequestBody CastRequest request, @RequestHeader("Authorization") String token) {
        return new ResponseEntity(castService.updateCast(request), HttpStatus.OK);
    }

    @GetMapping("/get-cast/{id}")
    public ResponseEntity getCast(@PathVariable("id") Long castId) {
        return new ResponseEntity(castService.getCast(castId), HttpStatus.OK);
    }

    @GetMapping("/get-casts")
    public ResponseEntity getCasts(@RequestAttribute CastRequest castRequest){
        return new ResponseEntity(castService.getCasts(castRequest), HttpStatus.OK);
    }

    @DeleteMapping("/delete-cast")
    public ResponseEntity deleteCast(@RequestAttribute("id") Long castId){
        return new ResponseEntity(castService.deleteCast(castId), HttpStatus.OK);
    }

}
