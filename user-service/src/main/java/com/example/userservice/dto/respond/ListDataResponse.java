package com.example.userservice.dto.respond;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListDataResponse <T> {

    List<T> data;

    Long totalRecord;

}
