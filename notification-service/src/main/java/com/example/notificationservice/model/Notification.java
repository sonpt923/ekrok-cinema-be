package com.example.notificationservice.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@Document(collection = "notifications")
public class Notification {

    @Id
    private ObjectId id;

    private String type;

    private String title;

    private String message;

    private String status;

    private Date createdAt;

    private Date createdBy;


}
