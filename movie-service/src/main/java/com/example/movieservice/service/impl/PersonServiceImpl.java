package com.example.movieservice.service.impl;

import com.example.core.dto.response.ListDataResponse;
import com.example.movieservice.dto.request.PersonRequest;
import com.example.movieservice.entity.Person;
import com.example.movieservice.repository.PersonRepository;
import com.example.movieservice.service.CloudFlareService;
import com.example.movieservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private CloudFlareService cloudFlareService = new CloudFlareServiceImpl();

    @Autowired
    private PersonRepository peopleRepository;


    @Override
    public Person createPeople(Person request) {
        return null;
    }

    @Override
    public Person updatePeople(Person request) {
        return null;
    }

    @Override
    public ListDataResponse<Person> getPersons(PersonRequest request) {
        return null;
    }

    @Override
    public Person getPerson(Long id) {
        return null;
    }
}
