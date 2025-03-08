package com.example.movieservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movie_language")
public class MovieLanguage {

    @Id
    @Column(name = "movie_id")
    private Long movieId;

    @Id
    @Column(name = "language_id")
    private Long languageId;

}
