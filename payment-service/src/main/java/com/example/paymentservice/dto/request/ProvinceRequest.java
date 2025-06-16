package com.example.paymentservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceRequest {

    private String search;

    private Integer page;

    private Integer pageSize;

}
