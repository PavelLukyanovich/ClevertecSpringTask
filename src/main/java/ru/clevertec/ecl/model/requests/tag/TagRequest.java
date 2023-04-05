package ru.clevertec.ecl.model.requests.tag;

import lombok.Data;
import ru.clevertec.ecl.model.entities.GiftCertificate;

import java.util.List;

@Data
public class TagRequest {

    private String name;
    private List<GiftCertificate> certificateList;
}
