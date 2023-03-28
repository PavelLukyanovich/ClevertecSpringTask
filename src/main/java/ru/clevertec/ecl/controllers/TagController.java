package ru.clevertec.ecl.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.ecl.model.Tag;
import ru.clevertec.ecl.model.dtos.TagDto;
import ru.clevertec.ecl.model.requests.TagRequest;
import ru.clevertec.ecl.service.TagService;

import java.util.List;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;


    @GetMapping()
    public List<Tag> getTags() {
        return tagService.getTags();
    }

    @GetMapping("/{id}")
    public Tag getTagById(@PathVariable("id") Integer id) {
        return tagService.getTagById(id);
    }

    @PostMapping
    public int createTag(@RequestBody TagRequest request) {
        return tagService.createTag(request);
    }

    @PutMapping
    public TagDto updateTag(@RequestBody TagRequest request, Integer id) {
        return tagService.updateTag(id, request);
    }

    @DeleteMapping("/{id}")
    public TagDto deleteTag(@PathVariable Integer id) {
        return tagService.deleteTag(id);
    }


}

