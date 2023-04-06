package ru.clevertec.ecl.utils.mapper;

import ru.clevertec.ecl.model.dtos.CertificateDto;
import ru.clevertec.ecl.model.dtos.CertificateParamDto;
import ru.clevertec.ecl.model.entities.GiftCertificate;

public class CertificateParamMapper {

    public static CertificateDto mapper(CertificateParamDto certificateParamDto, GiftCertificate certificate) {
        CertificateDto certificateDto = new CertificateDto();

        certificateDto.setName(certificateParamDto.getCertName());
        certificateDto.setDescription(certificateParamDto.getCertDescription());
        certificateDto.setPrice(certificate.getPrice());
        certificateDto.setTagName(certificateParamDto.getTagName());
        certificateDto.setDuration(certificate.getDuration());
        certificateDto.setCreateDate(certificate.getCreateDate());
        certificateDto.setLastUpdateDate(certificate.getLastUpdateDate());
        certificateDto.setTagList(certificate.getTagList());

        return certificateDto;
    }
}
