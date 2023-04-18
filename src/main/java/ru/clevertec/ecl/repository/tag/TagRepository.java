package ru.clevertec.ecl.repository.tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.clevertec.ecl.model.entities.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

}
