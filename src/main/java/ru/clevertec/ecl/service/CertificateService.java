package ru.clevertec.ecl.service;

import ru.clevertec.ecl.model.dtos.CertificateDto;
import ru.clevertec.ecl.model.dtos.CertificateParamDto;
import ru.clevertec.ecl.model.dtos.TagDto;
import ru.clevertec.ecl.model.entities.GiftCertificate;
import ru.clevertec.ecl.model.requests.CreateCertificateRequest;
import ru.clevertec.ecl.model.requests.UpdateCertificateRequest;

import java.util.List;

public interface CertificateService {

    boolean createCertificate(CreateCertificateRequest request);
    boolean deleteCertificate(Integer id);
    CertificateDto getCertificateById(Integer id);
    boolean updateCertificate(Integer id, UpdateCertificateRequest request);
    List<CertificateDto> getCertificates(CertificateParamDto sertificateParam);
}
