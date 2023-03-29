package ru.clevertec.ecl.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.clevertec.ecl.model.dtos.TagDto;
import ru.clevertec.ecl.model.entities.Tag;
import ru.clevertec.ecl.model.requests.CreateTagRequest;
import ru.clevertec.ecl.model.requests.UpdateTagRequest;
import ru.clevertec.ecl.repository.TagRepository;

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
        when(tagRepository.getTags()).thenReturn(tags);
        List<TagDto> tagDtos = tagService.getTags();
        assertNotNull(tagDtos);
    }

    @Test
    public void whenGetTagById_thanReturnCorrectTagDto() {
        Integer id = 1;
        Tag tag = new Tag();
        when(tagRepository.getTagById(id)).thenReturn(tag);
        TagDto tagDto = tagService.getTagById(id);
        assertNotNull(tagDto);
    }

    @Test
    public void whenCreateTag_thenReturn1() {
        CreateTagRequest request = new CreateTagRequest();
        when(tagRepository.create(request)).thenReturn(1);
        int result = tagService.createTag(request);
        assertEquals(1, result);
    }

    @Test
    public void whenUpdateTag_thanReturn1() {
        Integer id = 1;
        UpdateTagRequest request = new UpdateTagRequest();
        when(tagRepository.update(id, request)).thenReturn(1);
        int result = tagService.updateTag(id, request);
        assertEquals(1, result);
    }

    @Test
    public void whenDeleteTag_thanReturnCorrectTagDto() {
        Integer id = 1;
        TagDto tag = new TagDto();
        when(tagRepository.delete(id)).thenReturn(tag);
        TagDto resultTagDto = tagService.deleteTag(id);
        assertEquals(tag, resultTagDto);
    }
}
