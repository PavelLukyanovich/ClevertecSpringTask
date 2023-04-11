package ru.clevertec.ecl.service.tag;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clevertec.ecl.exceptions.JsonParseException;
import ru.clevertec.ecl.exceptions.NoSuchElementsException;
import ru.clevertec.ecl.model.dtos.TagDto;
import ru.clevertec.ecl.model.entities.Tag;
import ru.clevertec.ecl.model.requests.tag.CreateTagRequest;
import ru.clevertec.ecl.model.requests.tag.UpdateTagRequest;
import ru.clevertec.ecl.repository.tag.TagRepository;
import ru.clevertec.ecl.utils.mapper.TagMapper;

import java.util.List;
import java.util.Objects;
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
        LOGGER.log(Level.INFO, "tagList from repo" + tags);
        List<TagDto> tagDtos = tags.stream()
                .map(TagMapper.INSTANCE::tagToTagDto)
                .toList();
        LOGGER.log(Level.INFO, "mappedTagList" + tagDtos);
        return tagDtos;
    }

    @Override
    public TagDto getTagById(Long id) {

        if (Objects.nonNull(tagRepository.getTagById(id))) {
            return TagMapper.INSTANCE.tagToTagDto(tagRepository.getTagById(id));
        } else throw new NoSuchElementsException(id);
    }

    @Override
    public TagDto createTag(CreateTagRequest request) {

        Tag tagFromRequest = TagMapper.INSTANCE.requestToTag(request);
        TagDto resultTagDto = TagMapper.INSTANCE.tagToTagDto(tagRepository.create(tagFromRequest));

        if (Objects.equals(resultTagDto.getName(), tagFromRequest.getName())) {
            return resultTagDto;
        } else throw new JsonParseException();
    }

    public Long updateTag(Long id, UpdateTagRequest request) {

        if (Objects.nonNull(tagRepository.getTagById(id))) {
            return tagRepository.update(id, request);
        } else throw new NoSuchElementsException(id);
    }

    @Override
    public Long deleteTag(Long id) {

        if (Objects.nonNull(tagRepository.getTagById(id))) {
            return tagRepository.delete(id);
        } else throw new NoSuchElementsException(id);
    }
}
