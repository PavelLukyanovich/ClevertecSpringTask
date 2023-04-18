package ru.clevertec.ecl.model.dtos;

import lombok.Data;
import ru.clevertec.ecl.model.entities.Order;

import java.util.List;

@Data
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private List<Order> orderList;


}
