package com.example.movieservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CastRequest {

    private String code;

    private Integer role;

    private String image;

    private String name;

    private Integer gender;

    private String biography;

    private Date birthDate;

    private Integer status;

    private Integer page;

    private Integer pageSize;

}
