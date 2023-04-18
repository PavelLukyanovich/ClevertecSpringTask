package ru.clevertec.ecl.model.dtos;

import lombok.Data;
import ru.clevertec.ecl.model.entities.User;

@Data
public class OrderDto {

    private Long id;
    private String orderDate;
    private Integer price;
    private Long certificateId;
    private Long userId;
}
