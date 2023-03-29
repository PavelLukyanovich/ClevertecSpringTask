package ru.clevertec.ecl.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clevertec.ecl.model.dtos.CertificateDto;
import ru.clevertec.ecl.model.dtos.CertificateParamDto;
import ru.clevertec.ecl.model.dtos.TagDto;
import ru.clevertec.ecl.model.entities.GiftCertificate;
import ru.clevertec.ecl.model.requests.CreateCertificateRequest;
import ru.clevertec.ecl.model.requests.UpdateCertificateRequest;
import ru.clevertec.ecl.repository.CertificateRepository;
import ru.clevertec.ecl.utils.mupper.CertificateMapper;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService{

    private static final Logger LOGGER = Logger.getLogger(CertificateServiceImpl.class.getName());
    private final CertificateRepository certificateRepository;

    @Override
    public boolean createCertificate(CreateCertificateRequest request) {
        return certificateRepository.create(request);
    }

    @Override
    public boolean deleteCertificate(Integer id) {
        return certificateRepository.delete(id);
    }

    @Override
    public CertificateDto getCertificateById(Integer id) {
        return CertificateMapper.INSTANCE.certificateToCertificateDto(certificateRepository.getCertificateById(id));
    }

    @Override
    public boolean updateCertificate(Integer id, UpdateCertificateRequest request) {
        return certificateRepository.update(id, request);
    }

    @Override
    public List<CertificateDto> getCertificates(CertificateParamDto certificateParam) {
        List<GiftCertificate> certificates = certificateRepository.getCertificates();
        return certificates.stream().map(CertificateMapper.INSTANCE::certificateToCertificateDto).toList();
    }
}
