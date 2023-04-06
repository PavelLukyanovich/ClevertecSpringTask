package ru.clevertec.ecl.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.ecl.model.dtos.TagDto;
import ru.clevertec.ecl.model.requests.tag.CreateTagRequest;
import ru.clevertec.ecl.model.requests.tag.UpdateTagRequest;
import ru.clevertec.ecl.service.tag.TagService;

import java.util.List;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;


    @GetMapping()
    public List<TagDto> getTags() {
        return tagService.getTags();
    }

    @GetMapping("/{id}")
    public TagDto getTagById(@PathVariable("id") Long id) {
        return tagService.getTagById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public TagDto createTag(@RequestBody CreateTagRequest request) {
        return tagService.createTag(request);
    }

    @PutMapping("/{id}")
    public Long updateTag(@RequestBody UpdateTagRequest request, @PathVariable Long id) {
        return tagService.updateTag(id, request);
    }

    @DeleteMapping("/{id}")
    public Long deleteTag(@PathVariable Long id) {
        return tagService.deleteTag(id);
    }
}

