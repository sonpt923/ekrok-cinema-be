package com.example.movieservice.controller;

import com.example.movieservice.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seasion")
public class SeasonController {

    @Autowired
    private SeasonService seasonService;

}
