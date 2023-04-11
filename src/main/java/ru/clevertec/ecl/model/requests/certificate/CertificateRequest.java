package ru.clevertec.ecl.model.requests.certificate;

import lombok.Data;
import ru.clevertec.ecl.model.entities.Tag;

import java.time.LocalDate;
import java.util.List;

@Data
public class CertificateRequest {

    private String name;
    private String description;
    private Integer price;
    private Integer duration;
    private LocalDate createDate;
    private LocalDate lastUpdateDate;
    private List<Tag> tagList;
}
