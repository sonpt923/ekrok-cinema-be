package com.example.notificationservice.repository.customize.impl;

import com.example.notificationservice.repository.customize.TemplateRepoCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MailTemplateCustomImpl implements TemplateRepoCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

}
