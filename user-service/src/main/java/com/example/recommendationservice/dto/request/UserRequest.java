package com.example.recommendationservice.dto.request;

import com.example.recommendationservice.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private Long id;

    private String email;

    private String username;

    private String lastName;

    private String firstName;

    private String phone;

    private Date birthDay;

    private String password;

    private String image;

    private Integer status;

    private Integer page;

    private Integer pageSize;

    private String otp;

    private String confirmPassword;

    private Group group;

    private Integer flag;

}
