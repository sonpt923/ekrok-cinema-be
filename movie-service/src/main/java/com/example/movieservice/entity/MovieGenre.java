package com.example.movieservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie_genre")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieGenre {

    @Id
    @Column(name = "genre_id")
    private Long genre;

    @Id
    @Column(name = "movie_id")
    private Long movie;

}
