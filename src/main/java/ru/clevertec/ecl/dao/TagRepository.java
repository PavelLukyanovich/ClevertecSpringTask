package ru.clevertec.ecl.dao;

import ru.clevertec.ecl.model.Tag;
import ru.clevertec.ecl.model.requests.TagRequest;

import java.util.List;

public interface TagRepository {

    List<Tag> getTags();

    Tag getTagById(int id);

    int update(int id, TagRequest request);
    void delete(int id);

    int create(TagRequest request);
}
