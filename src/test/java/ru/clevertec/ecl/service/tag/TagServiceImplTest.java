package ru.clevertec.ecl.service.tag;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import ru.clevertec.ecl.model.dtos.TagDto;
import ru.clevertec.ecl.model.entities.Tag;
import ru.clevertec.ecl.model.requests.tag.CreateTagRequest;
import ru.clevertec.ecl.model.requests.tag.UpdateTagRequest;
import ru.clevertec.ecl.repository.tag.TagRepository;
import ru.clevertec.ecl.utils.mapper.TagMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TagServiceImplTest {

    @InjectMocks
    private TagServiceImpl tagService;

    @Mock
    private TagRepository tagRepository;

    @Test
    public void whenGetTags_thanReturnCorrectTagDtos() {

        List<Tag> tags = new ArrayList<>();
        when(tagRepository.findAll()).thenReturn(tags);
        int page = 2;
        int size = 2;
        List<TagDto> tagDtos = tagService.getTags(PageRequest.of(page, size));
        assertNotNull(tagDtos);
    }

    @Test
    public void whenGetTagById_thanReturnCorrectTagDto() {

        Long id = 1L;
        Tag tag = new Tag();
        when(tagRepository.getReferenceById(id)).thenReturn(tag);
        TagDto tagDto = tagService.getTagById(id);
        assertNotNull(tagDto);
    }

    @Test
    public void whenCreateTag_thenReturnSavedTag() {

        Tag tag = new Tag();
        CreateTagRequest request = new CreateTagRequest();
        when(tagRepository.save(tag)).thenReturn(tag);
        Tag result = TagMapper.INSTANCE.tagDtoToTag(tagService.createTag(request));
        assertEquals(tag, result);
    }

    @Test
    public void whenUpdateTag_thanReturnCurrentTag() {

        Long id = 1L;
        Tag tag = new Tag();
        UpdateTagRequest request = new UpdateTagRequest();
        when(tagRepository.save(tag)).thenReturn(tag);
        Tag result = tagService.updateTag(id, request);
        assertEquals(tag, result);
    }

    @Test
    public void whenDeleteTag_thanGetShouldReturnNull() {

        Long id = 1L;
        Tag tag = new Tag();
        tag.setId(id);
        tagRepository.save(tag);
        assertEquals(TagMapper.INSTANCE.tagDtoToTag(tagService.getTagById(id)), tag);
        tagRepository.delete(tag);
        assertNull(tagService.getTagById(id));
    }
}
