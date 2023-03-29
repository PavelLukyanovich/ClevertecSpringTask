package ru.clevertec.ecl.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.clevertec.ecl.model.dtos.CertificateDto;
import ru.clevertec.ecl.model.dtos.CertificateParamDto;
import ru.clevertec.ecl.model.entities.GiftCertificate;
import ru.clevertec.ecl.model.requests.CreateCertificateRequest;
import ru.clevertec.ecl.model.requests.UpdateCertificateRequest;
import ru.clevertec.ecl.repository.CertificateRepository;

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
    public void whenCreateCertificate_thanReturnTrue() {
        CreateCertificateRequest request = new CreateCertificateRequest();
        when(certificateRepository.create(request)).thenReturn(true);
        boolean result = certificateService.createCertificate(request);
        assertTrue(result);
    }

    @Test
    public void whenDeleteCertificate_thanReturnTrue() {
        Integer id = 1;
        when(certificateRepository.delete(id)).thenReturn(true);
        boolean result = certificateService.deleteCertificate(id);
        assertTrue(result);
    }

    @Test
    public void whenGetCertificateById_thanReturnCorrectCertificateDto() {
        Integer id = 1;
        GiftCertificate certificate = new GiftCertificate();
        when(certificateRepository.getCertificateById(id)).thenReturn(certificate);
        CertificateDto certificateDto = certificateService.getCertificateById(id);
        assertNotNull(certificateDto);
    }

    @Test
    public void whenUpdateCertificate_thanReturnTrue() {
        Integer id = 1;
        UpdateCertificateRequest request = new UpdateCertificateRequest();
        when(certificateRepository.update(id, request)).thenReturn(true);
        boolean result = certificateService.updateCertificate(id, request);
        assertTrue(result);
    }

    @Test
    public void whenGetCertificates_thanReturnCorrectCertificateDtos() {
        CertificateParamDto certificateParam = new CertificateParamDto();
        List<GiftCertificate> certificates = new ArrayList<>();
        when(certificateRepository.getCertificates()).thenReturn(certificates);
        List<CertificateDto> certificateDtos = certificateService.getCertificates(certificateParam);
        assertNotNull(certificateDtos);

    }
}