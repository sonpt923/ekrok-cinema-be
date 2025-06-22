package com.example.notificationservice.repository;

import com.example.notificationservice.model.Template;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailTemplateRepository extends MongoRepository<Template, Long> {

}
