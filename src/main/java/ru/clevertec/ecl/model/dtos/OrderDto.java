package ru.clevertec.ecl.model.dtos;

import lombok.Data;
import ru.clevertec.ecl.model.entities.User;

@Data
public class OrderDto {

    private Long id;
    private Long userId;
    private Long certificateId;
    private User user;
}
