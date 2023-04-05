package ru.clevertec.ecl.utils.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.clevertec.ecl.model.dtos.CertificateDto;
import ru.clevertec.ecl.model.entities.GiftCertificate;
import ru.clevertec.ecl.model.requests.certificate.CertificateRequest;

@Mapper
public interface CertificateMapper {

    CertificateMapper INSTANCE = Mappers.getMapper(CertificateMapper.class);

    CertificateDto certificateToCertificateDto(GiftCertificate giftCertificate);

    GiftCertificate certificateDtoToCertificate(CertificateDto certificateDto);

    GiftCertificate requestToCertificate(CertificateRequest request);

}
