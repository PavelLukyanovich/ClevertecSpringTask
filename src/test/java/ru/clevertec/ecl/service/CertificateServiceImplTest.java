package ru.clevertec.ecl.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.clevertec.ecl.model.dtos.CertificateDto;
import ru.clevertec.ecl.model.dtos.CertificateParamDto;
import ru.clevertec.ecl.model.entities.GiftCertificate;
import ru.clevertec.ecl.model.requests.certificate.CreateCertificateRequest;
import ru.clevertec.ecl.model.requests.certificate.UpdateCertificateRequest;
import ru.clevertec.ecl.repository.certificate.CertificateRepository;
import ru.clevertec.ecl.service.certificate.CertificateServiceImpl;
import ru.clevertec.ecl.utils.mapper.CertificateMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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
        when(certificateRepository.create(certificate)).thenReturn(certificate);
        CertificateDto result = certificateService.createCertificate(request);
        assertEquals(CertificateMapper.INSTANCE.certificateToCertificateDto(certificate), result);
    }

    @Test
    public void whenDeleteCertificate_thanReturnTrue() {
        Long id = 1L;
        when(certificateRepository.delete(id)).thenReturn(1L);
        Long result = certificateService.deleteCertificate(id);
        assertEquals(1, result);
    }

    @Test
    public void whenGetCertificateById_thanReturnCorrectCertificateDto() {
        Long id = 1L;
        GiftCertificate certificate = new GiftCertificate();
        when(certificateRepository.getCertificateById(id)).thenReturn(certificate);
        CertificateDto certificateDto = certificateService.getCertificateById(id);
        assertNotNull(certificateDto);
    }

    @Test
    public void whenUpdateCertificate_thanReturnTrue() {
        Long id = 1L;
        UpdateCertificateRequest request = new UpdateCertificateRequest();
        when(certificateRepository.update(id, request)).thenReturn(true);
        boolean result = certificateService.updateCertificate(id, request);
        assertTrue(result);
    }

    @Test
    public void whenGetCertificates_thanReturnCorrectCertificateDtos() {
        CertificateParamDto certificateParamDto = new CertificateParamDto();
        List<GiftCertificate> certificates = new ArrayList<>();
        when(certificateRepository.getCertificates(certificateParamDto)).thenReturn(certificates);
        List<CertificateDto> certificateDtos = certificateService.getCertificates(certificateParamDto);
        assertNotNull(certificateDtos);

    }
}