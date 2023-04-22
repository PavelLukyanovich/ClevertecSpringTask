package ru.clevertec.ecl.integration.service.certificate;

import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import ru.clevertec.ecl.integration.BaseTest;
import ru.clevertec.ecl.model.dtos.CertificateDto;
import ru.clevertec.ecl.model.dtos.CertificateParamDto;
import ru.clevertec.ecl.model.requests.certificate.CreateCertificateRequest;
import ru.clevertec.ecl.service.certificate.CertificateService;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CertificateServiceTest extends BaseTest {

    @Autowired
    private CertificateService certificateService;
    @Autowired
    private EntityManager entityManager;

    @Test
    void whenCreateCertificate_ShouldReturnCertificateWithNonNullId() {

        CreateCertificateRequest certificateRequest = new CreateCertificateRequest();
        CertificateDto actualGiftCertificate = certificateService.createCertificate(certificateRequest);

        assertThat(actualGiftCertificate.getId()).isNotNull();
    }

    @Test
    void whenDeleteCertificate_GetCertificateByIdShouldThrowException() {
        Long id = 1L;
        certificateService.deleteCertificate(id);
        entityManager.flush();

        assertThatThrownBy(() -> certificateService.getCertificateById(id));

    }

    @Test
    void whenGetCertificateById_ShouldReturnCertificateWithExpectedId() {

        Long expectedId = 2L;
        CertificateDto actualCertificate = certificateService.getCertificateById(2L);

        assertThat(actualCertificate.getId()).isEqualTo(expectedId);

    }

    @Test
    void whenUpdatePriceCertificate_ShouldReturnTrue() {

        CertificateDto oldCertificate = certificateService.getCertificateById(1L);
        oldCertificate.setPrice(100);
        CertificateParamDto param = new CertificateParamDto();
        param.setPrice(120);

        boolean haveBeenUpdated = certificateService.updatePriceCertificate(1L, param);

        assertThat(certificateService.getCertificateById(1L).getPrice()).isEqualTo(120);
        assertThat(haveBeenUpdated).isTrue();

    }

    @Test
    void whenUpdateDurationCertificate_ShouldReturnTrue() {

        CertificateDto oldCertificate = certificateService.getCertificateById(1L);
        oldCertificate.setDuration(365);
        CertificateParamDto param = new CertificateParamDto();
        param.setDuration(200);

        boolean haveBeenUpdated = certificateService.updateDurationCertificate(1L, param);

        assertThat(certificateService.getCertificateById(1L).getDuration()).isEqualTo(200);
        assertThat(haveBeenUpdated).isTrue();
    }

/*    @Test
    void whenGetCertificates_ShouldReturnAllCertificates() {
        int expectedAmount = 3;
        CertificateParamDto param = new CertificateParamDto();

        List<CertificateDto> allCertificates = certificateService.getCertificates(param, PageRequest.of(1,5));

        Assertions.assertThat(allCertificates).hasSize(expectedAmount);
    }*/

}
