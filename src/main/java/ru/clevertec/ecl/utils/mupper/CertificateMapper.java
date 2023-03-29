package ru.clevertec.ecl.utils.mupper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.clevertec.ecl.model.dtos.CertificateDto;
import ru.clevertec.ecl.model.entities.GiftCertificate;

@Mapper
public interface CertificateMapper {

    CertificateMapper INSTANCE = Mappers.getMapper(CertificateMapper.class);

    CertificateDto certificateToCertificateDto(GiftCertificate giftCertificate);
    GiftCertificate certificateDtoToCertificate(CertificateDto certificateDto);
}
