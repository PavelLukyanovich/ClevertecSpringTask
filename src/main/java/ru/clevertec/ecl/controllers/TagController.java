package ru.clevertec.ecl.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.ecl.dao.TagDao;
import ru.clevertec.ecl.model.Tag;
import ru.clevertec.ecl.service.TagService;

import java.util.List;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;


    @GetMapping()
    public List<Tag> getTags() {

        return tagDao.getTags();
    }

    @GetMapping("/{id}")
    public Tag getTagById(@PathVariable("id") Integer id) {

        return tagDao.getTagById(id);
    }
    @PostMapping
    public TagDto createTag(@RequestBody CreateTagRequest request) {
        return tagService.createTag(request);
    }

    @PutMapping
    public TagDto updateTag(@RequestBody UpdateTagRequest request) {
        return tagService.createTag(request);
    }
    @DeleteMapping("/{id}")
    public TagDto deleteTag(@PathVariable Integer id) {
        return tagService.deleteTag(id);
    }


}

