package com.example.notificationservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@Builder
@Document(collection = "notifications")
public class Notification {

    @Id
    private ObjectId id;

    // USER, ALL
    private String type;

    @Field("title")
    private String title;

    @Field("message")
    private String message;

    @Field("status")
    private String status;

    @Field("createdAt")
    private Timestamp createdAt;

    @Field("createdBy")
    private String createdBy;

    @Field("updatedBy")
    private String updatedBy;

    @Field("isRead")
    private Boolean isRead;


}
