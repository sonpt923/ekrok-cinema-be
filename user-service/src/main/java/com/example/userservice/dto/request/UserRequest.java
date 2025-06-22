package com.example.userservice.dto.request;

import com.example.userservice.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private Long id;

    private String provider;

    private String providerId;

    private String email;

    private String username;

    private String lastName;

    private String firstName;

    private String phone;

    private String image;

    private String birthDay;

    private String password;

    private Integer status;

    private Integer page;

    private Integer pageSize;

    private String otp;

    private String confirmPassword;

    private Group group;

    private Integer flag;

    private Boolean isAdmin;


}
