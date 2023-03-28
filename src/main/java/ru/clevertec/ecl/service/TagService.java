package ru.clevertec.ecl.service;

import ru.clevertec.ecl.model.dtos.TagDto;
import ru.clevertec.ecl.model.requests.CreateTagRequest;
import ru.clevertec.ecl.model.requests.TagRequest;
import ru.clevertec.ecl.model.requests.UpdateTagRequest;

import java.util.List;

public interface TagService {

    int createTag(CreateTagRequest request);

    TagDto deleteTag(Integer id);

    TagDto getTagById(Integer id);

    int updateTag(Integer id, UpdateTagRequest request);

    List<TagDto> getTags();
}
