package ru.clevertec.ecl.repository;

import ru.clevertec.ecl.model.entities.CertificateTag;
import ru.clevertec.ecl.model.entities.GiftCertificate;

import java.util.List;

public interface CertificateTagRepository {

    List<CertificateTag> findByCertificateId(Integer certificateId);
    List<CertificateTag> findByTagId(Integer tagId);
    List<CertificateTag> getCertificateTags();
}
