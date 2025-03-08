package com.example.notificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@Document(collection = "template")
public class Template {

    @Id
    private ObjectId id;

    private String code;

    private String name;

    private String channel;

    private String subject;

    private String content;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private String craetedBy;

    private String updatedBy;

}
