package ru.clevertec.ecl.service.certificate;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.clevertec.ecl.model.dtos.CertificateDto;
import ru.clevertec.ecl.model.dtos.CertificateParamDto;
import ru.clevertec.ecl.model.entities.GiftCertificate;
import ru.clevertec.ecl.model.requests.certificate.CreateCertificateRequest;
import ru.clevertec.ecl.repository.certificate.CertificateRepository;
import ru.clevertec.ecl.utils.SortType;
import ru.clevertec.ecl.utils.mapper.CertificateMapper;

import java.util.List;
import java.util.Objects;

import static ru.clevertec.ecl.service.certificate.CertificateSpecifications.*;
import static ru.clevertec.ecl.utils.DateTime.getDate;

@Service
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService {


    private final CertificateRepository certificateRepository;

    @Override
    public CertificateDto createCertificate(CreateCertificateRequest request) {

        GiftCertificate certificateFromRequest = CertificateMapper.INSTANCE.requestToCertificate(request);
        certificateFromRequest.setCreateDate(getDate());
        certificateFromRequest.setLastUpdateDate(getDate());
        certificateRepository.save(certificateFromRequest);
        return CertificateMapper.INSTANCE.certificateToCertificateDto(certificateFromRequest);

    }

    @Override
    public void deleteCertificate(Long id) {

        certificateRepository.deleteById(id);
    }

    @Override
    public CertificateDto getCertificateById(Long id) {

        GiftCertificate certificate = certificateRepository.getReferenceById(id);
        CertificateDto certificateDto = CertificateMapper.INSTANCE.certificateToCertificateDto(certificate);

        return certificateDto;

    }

    @Override
    public boolean updatePriceCertificate(Long id, CertificateParamDto certificateParamDto) {

        GiftCertificate certificate = certificateRepository.getReferenceById(id);
        certificate.setPrice(certificateParamDto.getPrice());
        certificate.setLastUpdateDate(getDate());

        certificateRepository.save(certificate);

        return true;
    }

    @Override
    public boolean updateDurationCertificate(Long id, CertificateParamDto certificateParamDto) {

        GiftCertificate certificate = certificateRepository.getReferenceById(id);
        certificate.setDuration(certificateParamDto.getDuration());
        certificate.setLastUpdateDate(getDate());

        certificateRepository.save(certificate);

        return true;
    }

    @Override
    public List<CertificateDto> getCertificates(CertificateParamDto certificateParamDto, PageRequest of) {

        Specification<GiftCertificate> specification = Specification
                .where(certificateParamDto.getCertName() == null ? null : certNameContains(certificateParamDto))
                .and(certificateParamDto.getTagName() == null ? null : tagNameContains(certificateParamDto))
                .and(certificateParamDto.getCertDescription() == null ? null : certDescriptionContains(certificateParamDto))
                .and(certificateParamDto.getSortDate() == null ? null : Objects.requireNonNull(checkDateSortType(certificateParamDto.getSortDate()))
                        .and(certificateParamDto.getSortName() == null ? null : checkNameSortType(certificateParamDto.getSortName())));

        Page<GiftCertificate> certificates = certificateRepository.findAll(specification, of);

        return certificates.getContent().stream().map(CertificateMapper.INSTANCE::certificateToCertificateDto).toList();
    }

    private static Specification<GiftCertificate> checkDateSortType(SortType sortType) {

        if (sortType.name().equals("ASC")) {
            return sortDateContainsASC();
        } else if (sortType.name().equals("DESC")) {
            return sortDateContainsDESC();
        }
        return null;
    }

    private static Specification<GiftCertificate> checkNameSortType(SortType sortType) {

        if (sortType.name().equals("ASC")) {
            return sortNameContainsASC();
        } else if (sortType.name().equals("DESC")) {
            return sortNameContainsDESC();
        }
        return null;
    }
}
