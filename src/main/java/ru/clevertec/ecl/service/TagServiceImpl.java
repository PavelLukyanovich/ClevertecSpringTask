package ru.clevertec.ecl.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clevertec.ecl.model.entities.Tag;
import ru.clevertec.ecl.model.requests.CreateTagRequest;
import ru.clevertec.ecl.model.requests.UpdateTagRequest;
import ru.clevertec.ecl.repository.TagRepository;
import ru.clevertec.ecl.model.dtos.TagDto;
import ru.clevertec.ecl.model.requests.TagRequest;
import ru.clevertec.ecl.utils.mupper.TagMapper;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {


    private static final Logger LOGGER = Logger.getLogger(TagServiceImpl.class.getName());
    private final TagRepository tagRepository;

    @Override
    public List<TagDto> getTags() {
        List<Tag> tags = tagRepository.getTags();
        LOGGER.log(Level.INFO, "!!!" + tags);
        List<TagDto> tagDtos = tags.stream()
                .map(TagMapper.INSTANCE::tagToTagDto)
                .toList();
        LOGGER.log(Level.INFO, "!!!" + tagDtos);
        return tagDtos;
    }

    @Override
    public TagDto getTagById(Integer id) {
        return TagMapper.INSTANCE.tagToTagDto(tagRepository.getTagById(id));
    }

    @Override
    public int createTag(CreateTagRequest request) {
        return tagRepository.create(request);
    }

    public int updateTag(Integer id, UpdateTagRequest request) {
        return tagRepository.update(id, request);
    }

    @Override
    public TagDto deleteTag(Integer id) {
        return null;
    }
}
