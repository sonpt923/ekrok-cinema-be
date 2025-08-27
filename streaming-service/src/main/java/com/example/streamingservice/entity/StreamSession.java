package com.example.streamingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "stream-session")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StreamSession {



}
