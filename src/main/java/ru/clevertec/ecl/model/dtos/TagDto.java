package ru.clevertec.ecl.model.dtos;

import lombok.Data;
import ru.clevertec.ecl.model.entities.GiftCertificate;

import java.util.List;

@Data
public class TagDto {

    private Long id;
    private String name;
    private List<GiftCertificate> certificateList;
}
