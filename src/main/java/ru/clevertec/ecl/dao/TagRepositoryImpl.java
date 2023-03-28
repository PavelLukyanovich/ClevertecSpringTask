package ru.clevertec.ecl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.clevertec.ecl.model.Tag;
import ru.clevertec.ecl.model.requests.TagRequest;

import java.util.List;

@Component
public class TagRepositoryImpl implements TagRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TagRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
    public int update(int id, TagRequest request) {

        return jdbcTemplate.update("INSERT INTO tag WHERE  VALUES (?)");
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM tag WHERE id=?", id);

    }

    @Override
    public int create(TagRequest request) {
        return jdbcTemplate.update("INSERT INTO tag VALUES (?)", request.getName());
    }
}
