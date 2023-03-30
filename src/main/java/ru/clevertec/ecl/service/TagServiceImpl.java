package ru.clevertec.ecl.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clevertec.ecl.dao.TagRepository;
import ru.clevertec.ecl.model.Tag;
import ru.clevertec.ecl.model.dtos.TagDto;
import ru.clevertec.ecl.model.requests.TagRequest;

import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private static final Logger LOGGER = Logger.getLogger(TagServiceImpl.class.getName());
    private final TagRepository tagRepository;

    @Override
    public List<Tag> getTags() {
        return tagRepository.getTags();
    }

    @Override
    public Tag getTagById(Integer id) {
        return tagRepository.getTagById(id);
    }

    @Override
    public int createTag(TagRequest request) {
        return tagRepository.create(request);
    }

    public int updateTag(Integer id, TagRequest request) {
        return tagRepository.update(id, request);
    }

    @Override
    public TagDto deleteTag(Integer id) {
        return null;
    }
}
