package ru.clevertec.ecl.repository;

import ru.clevertec.ecl.model.dtos.CertificateDto;
import ru.clevertec.ecl.model.entities.GiftCertificate;
import ru.clevertec.ecl.model.requests.CreateCertificateRequest;
import ru.clevertec.ecl.model.requests.CreateTagRequest;
import ru.clevertec.ecl.model.requests.UpdateCertificateRequest;

import java.util.List;

public interface CertificateRepository {
    List<GiftCertificate> getCertificates();

    GiftCertificate getCertificateById(int id);

    boolean create(CreateCertificateRequest request);
    boolean update(int id, UpdateCertificateRequest request);
    boolean delete(int id);
}
