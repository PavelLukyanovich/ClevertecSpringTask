package ru.clevertec.ecl.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.clevertec.ecl.exception.NoSuchElementsException;
import ru.clevertec.ecl.model.entities.GiftCertificate;
import ru.clevertec.ecl.model.requests.CreateCertificateRequest;
import ru.clevertec.ecl.model.requests.UpdateCertificateRequest;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CertificateRepositoryImpl implements CertificateRepository {
    private final JdbcTemplate jdbcTemplate;


    @Override
    public List<GiftCertificate> getCertificates() {

        return jdbcTemplate.query("SELECT * FROM gift_certificate", new BeanPropertyRowMapper<>(GiftCertificate.class));
    }

    @Override
    public GiftCertificate getCertificateById(int id) {

        GiftCertificate certificate = jdbcTemplate.query("SELECT * FROM gift_certificate WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(GiftCertificate.class))
                .stream()
                .findAny()
                .orElse(null);
        return certificate;
    }

    @Override
    public boolean create(CreateCertificateRequest request) {

        jdbcTemplate.update("INSERT INTO gift_certificate (id) VALUES(DEFAULT, ?, ?, ?, ?, ?, ?, ?)",
                request.getName(), request.getDescription(), request.getPrice(), request.getDuration(),
                request.getCreateDate(), request.getLastUpdateDate(), request.getTagSet());
        return true;
    }

    @Override
    public boolean update(int id, UpdateCertificateRequest updatedGiftCertificate) {

        jdbcTemplate.update("UPDATE gift_certificate SET name=?, description=?, price=?, duration=?, createdate=?, lastupdatedate=?, tags=? WHERE id=?", updatedGiftCertificate.getName(),
                updatedGiftCertificate.getDescription(), updatedGiftCertificate.getPrice(), updatedGiftCertificate.getDuration(),
                updatedGiftCertificate.getCreateDate(), updatedGiftCertificate.getLastUpdateDate(), updatedGiftCertificate.getTagSet(), id);
        return true;
    }

    @Override
    public boolean delete(int id) {

        jdbcTemplate.update("DELETE FROM gift_certificate WHERE id=?", id);
        return true;
    }
}
