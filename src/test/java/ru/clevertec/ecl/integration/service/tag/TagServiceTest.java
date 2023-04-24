package ru.clevertec.ecl.integration.service.tag;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import ru.clevertec.ecl.integration.BaseTest;
import ru.clevertec.ecl.model.dtos.TagDto;
import ru.clevertec.ecl.model.entities.Tag;
import ru.clevertec.ecl.model.requests.tag.CreateTagRequest;
import ru.clevertec.ecl.model.requests.tag.UpdateTagRequest;
import ru.clevertec.ecl.service.tag.TagService;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TagServiceTest extends BaseTest {

    @Autowired
    private TagService tagService;

    @Test
    void whenGetTags_shouldReturnListSize3() {

        int expectedTagCount = 3;
        List<TagDto> tagList = tagService.getTags(PageRequest.of(1, 5));

        Assertions.assertThat(tagList).hasSize(expectedTagCount);
    }

    @Test
    void whenGetTagById_shouldReturnTagWithCurrentId() {

        Long expectedId = 3L;
        TagDto actualTag = tagService.getTagById(expectedId);

        Assertions.assertThat(actualTag.getId()).isEqualTo(expectedId);
    }

    @Test
    void whenCreateTag_shouldReturnTagWithNonNullId() {

        CreateTagRequest request = new CreateTagRequest();
        TagDto expectedTag = tagService.createTag(request);

        Assertions.assertThat(expectedTag.getId()).isNotNull();
    }

    @Test
    void whenUpdateTag_shouldReturnUpdatedTag() {

        UpdateTagRequest request = new UpdateTagRequest();
        Tag expectTag = tagService.updateTag(1L, request);

        Assertions.assertThat(expectTag.getName()).isEqualTo(request.getName());
    }

    @Test
    void whenDeleteTag_thanGetTagById_shouldThrowException() {

        Long id = 1L;
        tagService.deleteTag(id);

        assertThatThrownBy(() -> tagService.getTagById(id));
    }

}
