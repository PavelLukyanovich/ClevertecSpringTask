package ru.clevertec.ecl.service.tag;

import ru.clevertec.ecl.model.dtos.TagDto;
import ru.clevertec.ecl.model.entities.Tag;
import ru.clevertec.ecl.model.requests.tag.CreateTagRequest;
import ru.clevertec.ecl.model.requests.tag.UpdateTagRequest;

import java.util.List;

public interface TagService {

    TagDto createTag(CreateTagRequest createTagRequest);

    void deleteTag(Long id);

    TagDto getTagById(Long id);

    Tag updateTag(Long id, UpdateTagRequest request);

    List<TagDto> getTags();
}
