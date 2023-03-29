package ru.clevertec.ecl.model.dtos;

import lombok.Data;
import ru.clevertec.ecl.utils.SortType;


@Data
public class CertificateParamDto {

    private String tagName;
    private String certName;
    private String certDescription;
    private SortType sortDate;
    private SortType sortName;
}
