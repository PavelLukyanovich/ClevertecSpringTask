package ru.clevertec.ecl.service;

import ru.clevertec.ecl.model.Tag;
import ru.clevertec.ecl.model.dtos.TagDto;
import ru.clevertec.ecl.model.requests.TagRequest;

import java.util.List;

public interface TagService {

    int createTag(TagRequest request);

    TagDto deleteTag(Integer id);

    Tag getTagById(Integer id);

    int updateTag(Integer id, TagRequest request);

    List<Tag> getTags();
}
