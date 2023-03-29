package ru.clevertec.ecl.repository;

import ru.clevertec.ecl.model.dtos.TagDto;
import ru.clevertec.ecl.model.entities.Tag;
import ru.clevertec.ecl.model.requests.CreateTagRequest;
import ru.clevertec.ecl.model.requests.UpdateTagRequest;

import java.util.List;

public interface TagRepository {

    List<Tag> getTags();
    Tag getTagById(int id);
    int update(int id, UpdateTagRequest request);
    TagDto delete(int id);
    int create(CreateTagRequest request);
}
