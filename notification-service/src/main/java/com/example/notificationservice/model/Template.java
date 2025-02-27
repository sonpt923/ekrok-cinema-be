package com.example.notificationservice.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Document(collection = "template")
public class Template {

    @Id
    private ObjectId id;

    private String name;

    private String channel;

    private String subject;

    private String content;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private String craetedBy;

    private String updatedBy;

}
