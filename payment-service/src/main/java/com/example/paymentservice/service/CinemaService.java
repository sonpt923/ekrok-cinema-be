package com.example.paymentservice.service;

import com.example.paymentservice.dto.request.CinemaRequest;

public interface CinemaService {

    Object createCinema(CinemaRequest request);

    Object updateCinema(CinemaRequest request);

}
