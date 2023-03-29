package ru.clevertec.ecl.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.clevertec.ecl.model.dtos.TagDto;
import ru.clevertec.ecl.model.entities.Tag;
import ru.clevertec.ecl.model.requests.CreateTagRequest;
import ru.clevertec.ecl.model.requests.UpdateTagRequest;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TagRepositoryImpl implements TagRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Tag> getTags() {

        return jdbcTemplate.query("SELECT * FROM tag", new BeanPropertyRowMapper<>(Tag.class));
    }

    @Override
    public Tag getTagById(int id) {

        return jdbcTemplate.query("SELECT * FROM tag WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Tag.class))
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public int update(int id, UpdateTagRequest request) {

        return jdbcTemplate.update("INSERT INTO tag WHERE  VALUES (?)");
    }

    @Override
    public TagDto delete(int id) {

        jdbcTemplate.update("DELETE FROM tag WHERE id=?", id);
        return null;
    }

    @Override
    public int create(CreateTagRequest request) {

        return jdbcTemplate.update(
                "INSERT INTO tag (name, certificateSet) VALUES (?, ?)", request.getName(),
                request.getCertificateSet());
    }
}
