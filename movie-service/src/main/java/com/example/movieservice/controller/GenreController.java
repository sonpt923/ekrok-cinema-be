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
@RequestMapping("/movie")
@RequireAuthor
public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping("/create-cast")
    public ResponseEntity createGenre(@RequestBody GenreRequest request, @RequestHeader("Authorization") String token) {
        return new ResponseEntity(genreService.createCast(request), HttpStatus.CREATED);
    }

    @PostMapping("/update-cast")
    public ResponseEntity updateGenre(@RequestBody GenreRequest request, @RequestHeader("Authorization") String token) {
        return new ResponseEntity(genreService.updateCast(request), HttpStatus.OK);
    }

    @GetMapping("/get-cast/{id}")
    public ResponseEntity getGenre(@PathVariable("id") Long id) {
        return new ResponseEntity(genreService.getCast(id), HttpStatus.OK);
    }

    @GetMapping("/get-casts")
    public ResponseEntity getGenres(@RequestAttribute GenreRequest request){
        return new ResponseEntity(genreService.getCasts(request), HttpStatus.OK);
    }

    @DeleteMapping("/delete-cast")
    public ResponseEntity deleteGenre(@RequestAttribute("id") Long id){
        return new ResponseEntity(genreService.deleteCast(id), HttpStatus.OK);
    }

}
