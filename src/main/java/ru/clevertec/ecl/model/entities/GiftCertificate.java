package ru.clevertec.ecl.model.entities;

import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class GiftCertificate {

    private int id;
    private String name;
    private String description;
    private Integer price;
    private String duration;
    private LocalDate createDate;
    private LocalDate lastUpdateDate;
    private Set<Tag> tagList = new HashSet<>();

}
