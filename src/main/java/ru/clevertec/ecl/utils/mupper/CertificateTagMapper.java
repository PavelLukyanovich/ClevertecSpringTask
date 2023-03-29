package ru.clevertec.ecl.utils.mupper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.clevertec.ecl.model.dtos.CertificateDto;
import ru.clevertec.ecl.model.dtos.CertificateTagDto;
import ru.clevertec.ecl.model.entities.CertificateTag;
import ru.clevertec.ecl.model.entities.GiftCertificate;

@Mapper
public interface CertificateTagMapper {

    CertificateTagMapper INSTANCE = Mappers.getMapper(CertificateTagMapper.class);

    CertificateTagDto certificateTagToCertificateTagDto(CertificateTag certificateTag);
    GiftCertificate certificateTagDtoToCertificateTag(CertificateDto certificateDto);
}
