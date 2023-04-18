package ru.clevertec.ecl.service.certificate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ru.clevertec.ecl.model.dtos.CertificateDto;
import ru.clevertec.ecl.model.dtos.CertificateParamDto;
import ru.clevertec.ecl.model.entities.GiftCertificate;
import ru.clevertec.ecl.model.requests.certificate.CreateCertificateRequest;
import ru.clevertec.ecl.repository.certificate.CertificateRepository;
import ru.clevertec.ecl.utils.mapper.CertificateMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CertificateServiceImplTest {
    @InjectMocks
    private CertificateServiceImpl certificateService;

    @Mock
    private CertificateRepository certificateRepository;

    @Test
    public void whenCreateCertificate_thanReturnCreatedCertificate() {
        CreateCertificateRequest request = new CreateCertificateRequest();
        GiftCertificate certificate = new GiftCertificate();
        when(certificateRepository.save(certificate)).thenReturn(certificate);
        CertificateDto result = certificateService.createCertificate(request);
        assertEquals(CertificateMapper.INSTANCE.certificateToCertificateDto(certificate), result);
    }

    @Test
    public void whenGetCertificateById_thanReturnCorrectCertificateDto() {
        Long id = 1L;
        GiftCertificate certificate = new GiftCertificate();
        when(certificateRepository.getById(id)).thenReturn(certificate);
        CertificateDto certificateDto = certificateService.getCertificateById(id);
        assertNotNull(certificateDto);
    }

    @Test
    public void whenGetCertificates_thanReturnCorrectCertificateDtos() {
        CertificateParamDto certificateParamDto = new CertificateParamDto();
        List<GiftCertificate> certificates = new ArrayList<>();
        int page = 2;
        int size = 2;
        when(certificateRepository.findAll((Pageable) certificateParamDto)).thenReturn((Page<GiftCertificate>) certificates);
        List<CertificateDto> certificateDtos = certificateService.getCertificates(certificateParamDto, PageRequest.of(page, size));
        assertNotNull(certificateDtos);

    }
}