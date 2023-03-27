package ru.clevertec.ecl.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Tag {

    private long id;
    private String name;

}
