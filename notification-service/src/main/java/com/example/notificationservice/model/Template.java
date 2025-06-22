package com.example.notificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Timestamp;
import java.util.Map;

@Data
@AllArgsConstructor
@Document(collection = "template")
public class Template {


    @Id
    @Field("id")
    private String id;

    // MAIL, SMS
    @Field("code")
    private String code;

    @Field("name")
    private String name;

    @Field("channel")
    private String channel;

    @Field("subject")
    private String subject;

    @Field("content")
    private String content;

    @Field("placeholders")
    private Map<String, String> placeholders;

    @Field("createdAt")
    private Timestamp createdAt;

    @Field("updatedAt")
    private Timestamp updatedAt;

    @Field("createdBy")
    private String createdBy;

    @Field("updatedBy")
    private String updatedBy;


    @Field("isDeleted")
    private Boolean isDeleted;

}
