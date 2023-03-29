package ru.clevertec.ecl.model.requests;

import lombok.Data;
import ru.clevertec.ecl.model.entities.GiftCertificate;

import java.util.Set;

@Data
public class TagRequest {

    private String name;
    private Set<GiftCertificate> certificateSet;
}
