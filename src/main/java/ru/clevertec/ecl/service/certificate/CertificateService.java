package ru.clevertec.ecl.service.certificate;

import ru.clevertec.ecl.model.dtos.CertificateDto;
import ru.clevertec.ecl.model.dtos.CertificateParamDto;
import ru.clevertec.ecl.model.requests.certificate.CreateCertificateRequest;
import ru.clevertec.ecl.model.requests.certificate.UpdateCertificateRequest;

import java.util.List;

public interface CertificateService {

    CertificateDto createCertificate(CreateCertificateRequest request);

    Long deleteCertificate(Long id);

    CertificateDto getCertificateById(Long id);

    boolean updateCertificate(Long id, UpdateCertificateRequest request);

    List<CertificateDto> getCertificates(CertificateParamDto certificateParamDto);
}
