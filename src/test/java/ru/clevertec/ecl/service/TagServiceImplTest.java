package ru.clevertec.ecl.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.clevertec.ecl.model.dtos.TagDto;
import ru.clevertec.ecl.model.entities.Tag;
import ru.clevertec.ecl.model.requests.tag.CreateTagRequest;
import ru.clevertec.ecl.model.requests.tag.UpdateTagRequest;
import ru.clevertec.ecl.repository.tag.TagRepository;
import ru.clevertec.ecl.service.tag.TagServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
        when(tagRepository.getTagById(Long.valueOf(id))).thenReturn(tag);
        TagDto tagDto = tagService.getTagById(Long.valueOf(id));
        assertNotNull(tagDto);
    }

    @Test
    public void whenCreateTag_thenReturnTrue() {
        Tag tag = new Tag();
        CreateTagRequest request = new CreateTagRequest();
        when(tagRepository.create(tag)).thenReturn(tag);
        TagDto result = tagService.createTag(request);
        assertEquals(true, result);
    }

    @Test
    public void whenUpdateTag_thanReturn1() {
        Integer id = 1;
        UpdateTagRequest request = new UpdateTagRequest();
        when(tagRepository.update(Long.valueOf(id), request)).thenReturn(1L);
        Long result = tagService.updateTag(Long.valueOf(id), request);
        assertEquals(1, result);
    }

    @Test
    public void whenDeleteTag_thanReturnCorrectTagDto() {
        Integer id = 1;
        Long tag = new TagDto();
        when(tagRepository.delete(Long.valueOf(id))).thenReturn(tag);
        Long resultTagDto = tagService.deleteTag(Long.valueOf(id));
        assertEquals(tag, resultTagDto);
    }
}
