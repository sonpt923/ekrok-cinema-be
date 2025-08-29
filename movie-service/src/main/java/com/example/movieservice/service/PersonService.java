package com.example.movieservice.service;

import com.example.core.dto.response.ListDataResponse;
import com.example.movieservice.dto.request.PersonRequest;
import com.example.movieservice.entity.Person;

public interface PersonService {

    Person createPeople(Person request);

    Person updatePeople(Person request);

    ListDataResponse<Person> getPersons(PersonRequest request);

    Person getPerson(Long id);

}
