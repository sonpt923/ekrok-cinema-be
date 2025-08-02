package com.example.userservice.repository.customize.impl;

import com.example.userservice.repository.customize.GroupRepoCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class GroupRepoCustomImpl implements GroupRepoCustom {

    @PersistenceContext
    private EntityManager entityManager;

}
