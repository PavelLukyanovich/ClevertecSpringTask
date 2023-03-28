package ru.clevertec.ecl.model.dtos;

import lombok.Data;

import java.time.LocalDate;
@Data
public class CertificateDto {

    private int id;
    private String name;
    private String description;
    private Integer price;
    private String duration;
    private LocalDate createDate;
    private LocalDate lastUpdateDate;
}
