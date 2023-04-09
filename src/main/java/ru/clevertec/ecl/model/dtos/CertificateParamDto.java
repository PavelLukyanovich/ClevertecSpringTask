package ru.clevertec.ecl.model.dtos;

import lombok.Data;


@Data
public class CertificateParamDto {

    private String tagName;
    private String certName;
    private String certDescription;
    private String sortDate;
    private String sortName;

}
