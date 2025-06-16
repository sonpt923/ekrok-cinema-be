package com.example.paymentservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChairTypeRequest {

    private Long page;

    private Long pageSize;

}
