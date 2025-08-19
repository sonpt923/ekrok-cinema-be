package com.example.movieservice.controller;

import com.example.movieservice.dto.request.GenreRequest;
import com.example.movieservice.entity.Genre;
import com.example.movieservice.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @PostMapping("/create-language")
    public ResponseEntity createGenre(@RequestBody Genre genre) {
        return new ResponseEntity(languageService.createGenre(genre), HttpStatus.OK);
    }

    @PostMapping("/update-language")
    public ResponseEntity udpateGenre(@RequestBody Genre genre) {
        return new ResponseEntity(languageService.updateGenre(genre), HttpStatus.OK);
    }

    @PostMapping("/get-language")
    public ResponseEntity getGenres(@RequestBody GenreRequest request) {
        return new ResponseEntity(languageService.getGenres(request), HttpStatus.OK);
    }

    @GetMapping("/get-language")
    public ResponseEntity getGenre(@RequestAttribute GenreRequest request){
        return new ResponseEntity(languageService, HttpStatus.OK);
    }


}
