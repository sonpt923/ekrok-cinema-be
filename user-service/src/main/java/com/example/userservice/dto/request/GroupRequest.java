package com.example.userservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupRequest {

    private String code;

    private String name;

    private String parentCode;

    private String description;

    private Integer page;

    private Integer pageSize;

}
