package com.example.notificationservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailTemplateRepository extends MongoRepository<MailTemplate, Long> {

    MailTemplate findByCode(String code);

}
