package com.example.notificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@Document(collection = "notification")
public class Notification {

    @Id
    @Field("id")
    private String id;

    @Field("user_id")
    private String userId;

    @Field("title")
    private String title;

    @Field("content")
    private String content;

    @Field("url")
    private String url;

    @Field("type")
    private String type; // PROMO, SYSTEM, UPDATE...

    @Field("is_read")
    private boolean isRead;

    @Field("created_at")
    private Timestamp createdAt;

    @Field("created_time")
    private Timestamp expiredAt;

}
