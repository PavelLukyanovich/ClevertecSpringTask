package ru.clevertec.ecl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.clevertec.ecl.exception.NoSuchElementsException;
import ru.clevertec.ecl.model.GiftCertificate;

import java.util.List;

@Component
public class CertificateDaoImpl implements CertificateDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CertificateDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<GiftCertificate> getCertificates() {

        List<GiftCertificate> listCertificates = jdbcTemplate.query("SELECT * FROM ", new BeanPropertyRowMapper<>(GiftCertificate.class));
        return listCertificates;
    }

    @Override
    public GiftCertificate getCertificateById(int id) {
        GiftCertificate certificate = jdbcTemplate.query("SELECT * FROM gift_certificate WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(GiftCertificate.class))
                .stream()
                .findAny()
                .orElse(null);
        if (certificate == null) {
            throw new NoSuchElementsException(certificate);
        }
        return certificate;
    }

    @Override
    public boolean save(GiftCertificate giftCertificate) {
        jdbcTemplate.update("INSERT INTO gift_certificate VALUES(1, ?, ?, ?, ?, ?, ?,?)",
                giftCertificate.getName(), giftCertificate.getDescription(), giftCertificate.getPrice(), giftCertificate.getDuration(),
                giftCertificate.getCreateDate(), giftCertificate.getLastUpdateDate());
        return true;
    }

    @Override
    public boolean update(int id, GiftCertificate updatedGiftCertificate) {
        jdbcTemplate.update("UPDATE gift_certificate SET name=?, description=?, price=?, duration=?, createdate=?, lastupdatedate=?, tag=? WHERE id=?", updatedGiftCertificate.getName(),
                updatedGiftCertificate.getDescription(), updatedGiftCertificate.getPrice(), updatedGiftCertificate.getDuration(),
                updatedGiftCertificate.getCreateDate(), updatedGiftCertificate.getLastUpdateDate(), id);
        return true;
    }

    @Override
    public boolean delete(int id) {
        jdbcTemplate.update("DELETE FROM gift_certificate WHERE id=?", id);
        return true;
    }
}
