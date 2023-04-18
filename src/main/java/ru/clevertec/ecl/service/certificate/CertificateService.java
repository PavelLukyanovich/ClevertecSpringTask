package ru.clevertec.ecl.service.certificate;

import org.springframework.data.domain.PageRequest;
import ru.clevertec.ecl.model.dtos.CertificateDto;
import ru.clevertec.ecl.model.dtos.CertificateParamDto;
import ru.clevertec.ecl.model.requests.certificate.CreateCertificateRequest;

import java.util.List;

public interface CertificateService {

    CertificateDto createCertificate(CreateCertificateRequest request);

    void deleteCertificate(Long id);

    CertificateDto getCertificateById(Long id);

    boolean updatePriceCertificate(Long id, CertificateParamDto certificateParamDto);

    boolean updateDurationCertificate(Long id, CertificateParamDto certificateParamDto);

    List<CertificateDto> getCertificates(CertificateParamDto certificateParamDto, PageRequest of);
}
