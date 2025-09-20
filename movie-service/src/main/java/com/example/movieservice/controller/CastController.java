package com.example.movieservice.controller;

import com.example.movieservice.dto.request.CastRequest;
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
    public ResponseEntity createCast(@RequestBody CastRequest request, @RequestAttribute("username") String username) {
        return new ResponseEntity(castService.createCast(request, username), HttpStatus.CREATED);
    }

    @PostMapping("/update-cast")
    public ResponseEntity updateCast(@RequestBody CastRequest request, @RequestAttribute("username") String username) {
        return new ResponseEntity(castService.updateCast(request, username), HttpStatus.OK);
    }

    @GetMapping("/get-cast/{id}")
    public ResponseEntity getCast(@RequestParam("id") Long castId) {
        return new ResponseEntity(castService.getCast(castId), HttpStatus.OK);
    }

    @GetMapping("/get-casts")
    public ResponseEntity getCasts(@RequestParam CastRequest castRequest) {
        return new ResponseEntity(castService.getCasts(castRequest), HttpStatus.OK);
    }

    @DeleteMapping("/delete-cast")
    public ResponseEntity deleteCast(@RequestParam("id") Long castId, @RequestAttribute("username") String username) {
        return new ResponseEntity(castService.deleteCast(castId, username), HttpStatus.OK);
    }

}
