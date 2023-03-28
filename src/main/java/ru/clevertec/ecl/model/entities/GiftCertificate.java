package ru.clevertec.ecl.model.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
public class GiftCertificate {

    private int id;
    private String name;
    private String description;
    private Integer price;
    private String duration;
    private LocalDate createDate;
    private LocalDate lastUpdateDate;

}
