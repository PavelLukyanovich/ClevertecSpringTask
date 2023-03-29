package ru.clevertec.ecl.service;

import ru.clevertec.ecl.model.dtos.CertificateDto;
import ru.clevertec.ecl.model.dtos.CertificateParamDto;
import ru.clevertec.ecl.model.dtos.CertificateTagDto;
import ru.clevertec.ecl.model.entities.CertificateTag;

import java.util.List;

public interface CertificateTagService {

   CertificateTagDto getCertificateTagById(Integer id);
    List<CertificateTagDto> getCertificateTags();

}
