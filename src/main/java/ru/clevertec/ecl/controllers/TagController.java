package ru.clevertec.ecl.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.ecl.dao.TagDao;
import ru.clevertec.ecl.model.Tag;

import java.util.List;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagDao tagDao;


    @GetMapping()
    @ResponseBody
    public List<Tag> getTags() {

        return tagDao.getTags();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Tag getTagById(@PathVariable("id") Integer id) {

        return tagDao.getTagById(id);
    }
}

