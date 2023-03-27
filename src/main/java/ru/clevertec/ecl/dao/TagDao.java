package ru.clevertec.ecl.dao;

import ru.clevertec.ecl.model.Tag;

import java.util.List;

public interface TagDao {

    List<Tag> getTags();

    Tag getTagById(int id);

    void save(Tag tag);
    void update(int id, Tag updatedTag);
    void delete(int id);
}
