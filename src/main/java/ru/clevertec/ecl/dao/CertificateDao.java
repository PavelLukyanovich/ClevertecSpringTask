package ru.clevertec.ecl.dao;

import ru.clevertec.ecl.model.GiftCertificate;

import java.util.List;

public interface CertificateDao {
    List<GiftCertificate> getCertificates();

    GiftCertificate getCertificateById(int id);

    boolean save(GiftCertificate giftCertificate);
    boolean update(int id, GiftCertificate updatedGiftCertificate);
    boolean delete(int id);
}
