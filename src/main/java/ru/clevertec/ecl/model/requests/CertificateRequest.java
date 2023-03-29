package ru.clevertec.ecl.model.requests;

import lombok.Data;
import ru.clevertec.ecl.model.entities.Tag;

import java.time.LocalDate;
import java.util.Set;

@Data
public class CertificateRequest {

    private String name;
    private String description;
    private Integer price;
    private String duration;
    private LocalDate createDate;
    private LocalDate lastUpdateDate;
    private Set<Tag> tagSet;
}
