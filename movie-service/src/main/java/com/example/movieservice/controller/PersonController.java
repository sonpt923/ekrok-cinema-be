package com.example.movieservice.controller;

import com.example.movieservice.dto.request.PersonRequest;
import com.example.movieservice.entity.Person;
import com.example.movieservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/create-person")
    public ResponseEntity createPeople(@RequestBody Person people, @RequestHeader("Authorization") String token) {
        return new ResponseEntity(personService.createPeople(people), HttpStatus.OK);
    }

    @PostMapping("/update-person")
    public ResponseEntity updatePeople(@RequestBody Person people, @RequestHeader("Authorization") String token) {
        return new ResponseEntity(personService.updatePeople(people), HttpStatus.OK);
    }

    @PostMapping("/get-persons")
    public ResponseEntity getPersons(@RequestBody PersonRequest request) {
        return new ResponseEntity(personService.getPersons(request), HttpStatus.OK);
    }

}
