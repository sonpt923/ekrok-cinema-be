package com.example.notificationservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Document(collection = "channel")
public class Channel {

    @Id
    private String id;

    @Field("channelType")
    private String channelType;

    @Field("provider")
    private String provider;

    @Field("configs")
    private List<Config> configs;

    @Field("status")
    private String status;

    @Field("createdAt")
    private String createdAt;

    @Field("createdBy")
    private Timestamp createdBy;

    @Field("updatedBy")
    private String updatedBy;

    @Field("updatedAt")
    private Timestamp updatedAt;

    @Field("deleted")
    private Boolean deleted;



}
