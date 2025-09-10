package com.example.movieservice.dto.request;

import com.example.movieservice.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {

    private String code;

    private String title;

    private String poster;

    private String trailer;

    private String country;

    private String language;

    private String type;

    private Integer ageRestriction;

    private Integer duration;

    private Integer status;

    private Date releaseDate;

    private String createdBy;

    private Timestamp createdAt;

    private String updatedBy;

    private Timestamp updatedAt;

    private int page;

    private int pageSize;

    private List<GenreRequest> genreRequests;

    private List<CastRequest> CastRequest;



}
