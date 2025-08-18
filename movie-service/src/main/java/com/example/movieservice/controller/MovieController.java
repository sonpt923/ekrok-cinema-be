package com.example.movieservice.controller;

import com.example.movieservice.dto.request.MovieRequest;
import com.example.movieservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/create-movie")
    public ResponseEntity createMovie(@RequestBody MovieRequest request, @RequestHeader String username) {
        return new ResponseEntity(movieService.createMovie(request, username), HttpStatus.OK);
    }

    @PostMapping("/update-movie")
    public ResponseEntity updateMovie(@RequestBody MovieRequest request, @RequestHeader String username) {
        return new ResponseEntity(movieService.updateMovie(request, username), HttpStatus.OK);
    }

    @GetMapping("/get-movies")
    public ResponseEntity getMovies(@RequestBody MovieRequest request) {
        return new ResponseEntity(movieService.getMovieBycondition(request), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deletedMovie(@RequestBody MovieRequest request) {
        return new ResponseEntity(null, HttpStatus.OK);
    }


}
