package ru.clevertec.ecl.service.certificate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clevertec.ecl.exception.JsonParseException;
import ru.clevertec.ecl.exception.NoSuchElementsException;
import ru.clevertec.ecl.model.dtos.CertificateDto;
import ru.clevertec.ecl.model.entities.GiftCertificate;
import ru.clevertec.ecl.model.requests.certificate.CreateCertificateRequest;
import ru.clevertec.ecl.model.requests.certificate.UpdateCertificateRequest;
import ru.clevertec.ecl.repository.certificate.CertificateRepository;
import ru.clevertec.ecl.utils.mapper.CertificateMapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService {

    private static final Logger LOGGER = Logger.getLogger(CertificateServiceImpl.class.getName());
    private final CertificateRepository certificateRepository;

    @Override
    public CertificateDto createCertificate(CreateCertificateRequest request) {
        GiftCertificate certificateFromRequest = CertificateMapper.INSTANCE.requestToCertificate(request);
        LOGGER.log(Level.INFO, "mapped certificate name " + certificateFromRequest.getName());
        CertificateDto createdCertificateDto = CertificateMapper.INSTANCE.certificateToCertificateDto(certificateFromRequest);
        if (certificateFromRequest.equals(CertificateMapper.INSTANCE.certificateDtoToCertificate(createdCertificateDto))) {
            certificateRepository.create(certificateFromRequest);
            return createdCertificateDto;
        } else throw new JsonParseException();
    }

    @Override
    public boolean deleteCertificate(Long id) {

        if (!Objects.isNull(certificateRepository.getCertificateById(id))) {
            return certificateRepository.delete(id);
        } else throw new NoSuchElementsException(certificateRepository.getCertificateById(id));
    }

    @Override
    public CertificateDto getCertificateById(Long id) {

        if (!Objects.nonNull(certificateRepository.getCertificateById(id))) {
            return CertificateMapper.INSTANCE.certificateToCertificateDto(certificateRepository.getCertificateById(id));
        } else throw new NoSuchElementsException(new GiftCertificate(id, null, null, null, null, null, null, null));
    }

    @Override
    @Transactional
    public boolean updateCertificate(Long id, UpdateCertificateRequest request) {

        GiftCertificate certificateById = certificateRepository.getCertificateById(id);
        if (Objects.nonNull(certificateById)) {
            certificateById.setName(request.getName());
            certificateById.setDescription(request.getDescription());
            certificateById.setPrice(request.getPrice());
            certificateById.setDuration(request.getDuration());
            certificateById.setCreateDate(request.getCreateDate());
            certificateById.setLastUpdateDate(request.getLastUpdateDate());
            certificateRepository.update(id, request);
            return true;
        } else throw new NoSuchElementsException(CertificateMapper.INSTANCE.requestToCertificate(request));
    }

    @Override
    public List<CertificateDto> getCertificates(CertificateDto certificateDto) {

        List<GiftCertificate> certificates = certificateRepository.getCertificates();
        return certificates.stream().map(CertificateMapper.INSTANCE::certificateToCertificateDto).toList();
    }
}
