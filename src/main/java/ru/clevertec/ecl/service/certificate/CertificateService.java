package ru.clevertec.ecl.service.certificate;

import ru.clevertec.ecl.model.dtos.CertificateParamDto;
import ru.clevertec.ecl.model.entities.GiftCertificate;
import ru.clevertec.ecl.model.requests.certificate.CreateCertificateRequest;
import ru.clevertec.ecl.model.requests.certificate.UpdateCertificateRequest;

import java.util.List;

public interface CertificateService {

    GiftCertificate createCertificate(CreateCertificateRequest request);

    void deleteCertificate(Long id);

    GiftCertificate getCertificateById(Long id);

    boolean updateCertificate(Long id, UpdateCertificateRequest request);

    List<GiftCertificate> getCertificates(CertificateParamDto certificateParamDto);
}
