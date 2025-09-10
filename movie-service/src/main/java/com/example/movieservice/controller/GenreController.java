package com.example.movieservice.controller;

import com.example.core.annotation.RequireAuthor;
import com.example.movieservice.dto.request.CastRequest;
import com.example.movieservice.dto.request.GenreRequest;
import com.example.movieservice.entity.Genre;
import com.example.movieservice.service.CastService;
import com.example.movieservice.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genre")
@RequireAuthor
public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping("/create-genre")
    public ResponseEntity createGenre(@RequestBody GenreRequest request, @RequestHeader("Authorization") String token) {
        return new ResponseEntity(genreService.createGenre(request), HttpStatus.CREATED);
    }

    @PostMapping("/update-genre")
    public ResponseEntity updateGenre(@RequestBody GenreRequest request, @RequestHeader("Authorization") String token) {
        return new ResponseEntity(genreService.updateGenre(request), HttpStatus.OK);
    }

    @GetMapping("/get-genre}")
    public ResponseEntity getGenre(@RequestParam("id") Long id) {
        return new ResponseEntity(genreService.getGenre(id), HttpStatus.OK);
    }

    @GetMapping("/get-genres")
    public ResponseEntity getGenres(@RequestAttribute GenreRequest request){
        return new ResponseEntity(genreService.getGenres(request), HttpStatus.OK);
    }

    @DeleteMapping("/delete-genre")
    public ResponseEntity deleteGenre(@RequestParam("id") Long id){
        return new ResponseEntity(genreService.deleteGenre(id), HttpStatus.OK);
    }

}
