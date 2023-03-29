package ru.clevertec.ecl.model.entities;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Tag {

    private int id;
    private String name;
    private Set<GiftCertificate> certificateList = new HashSet<>();

}
