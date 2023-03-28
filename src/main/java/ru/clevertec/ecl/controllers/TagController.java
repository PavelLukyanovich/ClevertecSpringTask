package ru.clevertec.ecl.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.ecl.model.dtos.TagDto;
import ru.clevertec.ecl.model.requests.CreateTagRequest;
import ru.clevertec.ecl.model.requests.UpdateTagRequest;
import ru.clevertec.ecl.service.TagService;

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
    public TagDto getTagById(@PathVariable("id") Integer id) {
        return tagService.getTagById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public int createTag(@RequestBody CreateTagRequest request) {
        return tagService.createTag(request);
    }

    @PutMapping("/{id}")
    public int updateTag(@RequestBody UpdateTagRequest request, @PathVariable String id) {
        return tagService.updateTag(Integer.valueOf(id), request);
    }

    @DeleteMapping("/{id}")
    public TagDto deleteTag(@PathVariable Integer id) {
        return tagService.deleteTag(id);
    }
}

