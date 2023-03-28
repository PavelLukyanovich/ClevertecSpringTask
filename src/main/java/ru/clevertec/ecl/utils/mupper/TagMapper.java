package ru.clevertec.ecl.utils.mupper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.clevertec.ecl.model.dtos.TagDto;
import ru.clevertec.ecl.model.entities.Tag;

@Mapper
public interface TagMapper {

    TagMapper INSTANCE = Mappers.getMapper(TagMapper.class);

    TagDto tagToTagDto(Tag tag);

    Tag tagDtoToTag(TagDto tagDto);
}
