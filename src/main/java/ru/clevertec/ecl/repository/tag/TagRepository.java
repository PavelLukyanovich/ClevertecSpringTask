package ru.clevertec.ecl.repository.tag;

import org.springframework.stereotype.Repository;
import ru.clevertec.ecl.model.entities.Tag;
import ru.clevertec.ecl.model.requests.tag.UpdateTagRequest;

import java.util.List;

@Repository
public interface TagRepository {

    List<Tag> getTags();

    Tag getTagById(Long id);

    Long update(Long id, UpdateTagRequest request);

    Long delete(Long id);

    Tag create(Tag tag);
}
