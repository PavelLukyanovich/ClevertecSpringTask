package ru.clevertec.ecl.model.entities;

import lombok.Data;

@Data
public class CertificateTag {

    private int id;
    private int certificateId;
    private int tagId;
}
