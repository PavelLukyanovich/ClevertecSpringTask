package ru.clevertec.ecl.model.dtos;

import lombok.Data;

@Data
public class OrderDto {

    private Long id;
    private Long userId;
    private Long certificateId;
}
