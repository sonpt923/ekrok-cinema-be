package com.example.subcriptionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example"})
public class SubcriptionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubcriptionServiceApplication.class, args);
    }

}
