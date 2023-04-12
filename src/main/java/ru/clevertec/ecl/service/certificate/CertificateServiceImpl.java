package ru.clevertec.ecl.service.certificate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clevertec.ecl.model.dtos.CertificateParamDto;
import ru.clevertec.ecl.model.entities.GiftCertificate;
import ru.clevertec.ecl.model.requests.certificate.CreateCertificateRequest;
import ru.clevertec.ecl.model.requests.certificate.UpdateCertificateRequest;
import ru.clevertec.ecl.repository.certificate.CertificateRepository;
import ru.clevertec.ecl.utils.mapper.CertificateMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService {


    private final CertificateRepository certificateRepository;

    @Override
    public GiftCertificate createCertificate(CreateCertificateRequest request) {
        GiftCertificate certificateFromRequest = CertificateMapper.INSTANCE.requestToCertificate(request);

        return certificateRepository.save(certificateFromRequest);

    }

    @Override
    public void deleteCertificate(Long id) {

        certificateRepository.deleteById(id);
    }

    @Override
    public GiftCertificate getCertificateById(Long id) {

        return certificateRepository.getById(id);

    }

    @Override
    public boolean updateCertificate(Long id, UpdateCertificateRequest request) {

        GiftCertificate certificateById = certificateRepository.getById(id);
        certificateById.setName(request.getName());
        certificateById.setDescription(request.getDescription());
        certificateById.setPrice(request.getPrice());
        certificateById.setDuration(request.getDuration());
        certificateById.setCreateDate(request.getCreateDate());
        certificateById.setLastUpdateDate(request.getLastUpdateDate());
        certificateById.setTagList(request.getTagList());

        certificateRepository.save(certificateById);

        return true;
    }

    @Override
    public List<GiftCertificate> getCertificates(CertificateParamDto certificateParamDto) {

        return certificateRepository.findAllByNameOrDescription(
                certificateParamDto.getCertName(),
                certificateParamDto.getCertDescription()
        );
    }
}
