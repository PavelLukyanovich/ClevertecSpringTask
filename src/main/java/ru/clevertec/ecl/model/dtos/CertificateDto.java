package ru.clevertec.ecl.model.dtos;

import lombok.Data;
import ru.clevertec.ecl.model.entities.Tag;

import java.util.List;

@Data
public class CertificateDto {

    private Long id;
    private String name;
    private String description;
    private Integer price;
    private Integer duration;
    private String createDate;
    private String lastUpdateDate;
    private List<Tag> tagList;
}
