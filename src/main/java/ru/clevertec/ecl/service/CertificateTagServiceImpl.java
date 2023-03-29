package ru.clevertec.ecl.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clevertec.ecl.model.dtos.CertificateTagDto;
import ru.clevertec.ecl.model.entities.CertificateTag;
import ru.clevertec.ecl.repository.CertificateTagRepository;
import ru.clevertec.ecl.utils.mupper.CertificateTagMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CertificateTagServiceImpl implements CertificateTagService {

    private final CertificateTagRepository certificateTagRepository;

    @Override
    public CertificateTagDto getCertificateTagById(Integer id) {
        return CertificateTagMapper.INSTANCE.certificateTagToCertificateTagDto((CertificateTag) certificateTagRepository.findByTagId(id));

    }

    @Override
    public List<CertificateTagDto> getCertificateTags() {
        List<CertificateTag> certificateTags = certificateTagRepository.getCertificateTags();
        return certificateTags.stream().map(CertificateTagMapper.INSTANCE::certificateTagToCertificateTagDto).toList();
    }

}
