package ru.clevertec.ecl.model.dtos;

import lombok.Data;
import ru.clevertec.ecl.model.entities.Tag;

import java.time.LocalDate;
import java.util.List;

@Data
public class CertificateDto {

    private Long id;
    private String name;
    private String tagName;
    private String description;
    private Integer price;
    private Integer duration;
    private LocalDate createDate;
    private LocalDate lastUpdateDate;
    private List<Tag> tagList;
}
