package com.example.notificationservice.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

// lưu lịch sử thông báo
@Document(collection = "notifications")
public class Notification {

    @Id
    private ObjectId id;

    // USER, ALL
    private String type;

    private String title;

    private String message;

    private String status;

    private Timestamp createdAt;

    private String createdBy;


}
