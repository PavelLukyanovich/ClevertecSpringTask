package ru.clevertec.ecl.repository.certificate;

import org.springframework.stereotype.Repository;
import ru.clevertec.ecl.model.dtos.CertificateParamDto;
import ru.clevertec.ecl.model.entities.GiftCertificate;
import ru.clevertec.ecl.model.requests.certificate.UpdateCertificateRequest;

import java.util.List;

@Repository
public interface CertificateRepository {

    List<GiftCertificate> getCertificates(CertificateParamDto certificateParamDto);

    GiftCertificate getCertificateById(Long id);

    GiftCertificate create(GiftCertificate giftCertificate);

    boolean update(Long id, UpdateCertificateRequest certificateRequest);

    boolean delete(Long id);
}
