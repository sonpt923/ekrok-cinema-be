package com.example.paymentservice.dto.request;

import com.example.paymentservice.entity.Chair;
import com.example.paymentservice.entity.RoomType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomRequest {

    private String code;

    private String name;

    private BigDecimal price;

    private RoomType roomType;

    private Integer status;

    private List<Chair> chairs;

    private Integer page;

    private Integer pageSize;

    private Long idCienma;

}
