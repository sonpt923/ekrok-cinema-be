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
@Table(name = "movie_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieRole {



    @Id
    @Column(name = "person_id")
    private Long personId;

    @Id
    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "role")
    private Integer role;

}
