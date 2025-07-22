package com.example.notificationservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Timestamp;
import java.util.Map;

@Document(collection = "channel")
public class Channel {

    @Id
    private String id;

    @Field("code")
    private String code;

    @Field("type")
    private String type;

    @Field("priority")
    private Long priority;

    @Field("configs")
    private Map<String, Object> configs;

    @Field("isActive")
    private Boolean isActive;

    @Field("createdAt")
    private Timestamp createdAt;

    @Field("createdBy")
    private String createdBy;

    @Field("updatedBy")
    private String updatedBy;

    @Field("updatedAt")
    private Timestamp updatedAt;

    @Field("isDeleted")
    private Boolean isDeleted;
}
