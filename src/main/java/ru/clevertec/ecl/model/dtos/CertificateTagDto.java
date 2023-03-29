package ru.clevertec.ecl.model.dtos;

import lombok.Data;

@Data
public class CertificateTagDto {

    private int id;
    private int certificateId;
    private int tagId;
}
