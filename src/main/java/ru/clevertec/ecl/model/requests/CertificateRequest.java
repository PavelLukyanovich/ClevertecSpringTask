package ru.clevertec.ecl.model.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CertificateRequest {
    private String name;
    private String description;
    private Integer price;
    private String duration;
    private LocalDate createDate;
    private LocalDate lastUpdateDate;
}
