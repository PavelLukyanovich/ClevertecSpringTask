package ru.clevertec.ecl.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.clevertec.ecl.model.entities.CertificateTag;

import java.util.List;
@Component
@RequiredArgsConstructor
public class CertificateTagRepositoryImpl implements CertificateTagRepository{

    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<CertificateTag> findByCertificateId(Integer certificateId) {
        return jdbcTemplate.query("SELECT * FROM certificate_tag WHERE certificate_id=?", new Object[]{certificateId},
                new BeanPropertyRowMapper<>(CertificateTag.class));
    }

    @Override
    public List<CertificateTag> findByTagId(Integer tagId) {
        return jdbcTemplate.query("SELECT * FROM certificate_tag WHERE tag_id=?", new Object[]{tagId},
                new BeanPropertyRowMapper<>(CertificateTag.class));
    }
}
