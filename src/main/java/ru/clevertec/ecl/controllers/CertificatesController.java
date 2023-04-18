package ru.clevertec.ecl.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.ecl.model.dtos.CertificateDto;
import ru.clevertec.ecl.model.dtos.CertificateParamDto;
import ru.clevertec.ecl.model.requests.certificate.CreateCertificateRequest;
import ru.clevertec.ecl.service.certificate.CertificateService;
import ru.clevertec.ecl.utils.SortType;

import java.util.List;

@RestController
@RequestMapping("/certificates")
@RequiredArgsConstructor

public class CertificatesController {

    private final CertificateService certificateService;


    @GetMapping()
    public List<CertificateDto> getCertificatesBy(@RequestParam(required = false) String tagName,
                                                  @RequestParam(required = false) String certName,
                                                  @RequestParam(required = false) String certDescription,
                                                  @RequestParam(required = false) SortType sortDate,
                                                  @RequestParam(required = false) SortType sortName,
                                                  @RequestParam(required = false, defaultValue = "0") int page,
                                                  @RequestParam(required = false, defaultValue = "2") int size) {

        CertificateParamDto certificateParam = new CertificateParamDto();
        certificateParam.setTagName(tagName);
        certificateParam.setCertName(certName);
        certificateParam.setCertDescription(certDescription);
        certificateParam.setSortDate(sortDate);
        certificateParam.setSortName(sortName);

        return certificateService.getCertificates(certificateParam, PageRequest.of(page, size));
    }

    @GetMapping("/{id}")

    public CertificateDto getCertificateById(@PathVariable("id") Long id) {
        return certificateService.getCertificateById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)

    public CertificateDto createCertificate(@RequestBody CreateCertificateRequest request) {
        return certificateService.createCertificate(request);
    }

    @PutMapping("/duration/{id}")

    public boolean updateDurationCertificate(@RequestParam Integer duration, @PathVariable Long id) {

        CertificateParamDto certificateParamDto = new CertificateParamDto();
        certificateParamDto.setDuration(duration);

        return certificateService.updateDurationCertificate(id, certificateParamDto);
    }

    @PutMapping("/price/{id}")

    public boolean updatePriceCertificate(@RequestParam Integer price, @PathVariable Long id) {

        CertificateParamDto certificateParamDto = new CertificateParamDto();
        certificateParamDto.setPrice(price);

        return certificateService.updatePriceCertificate(id, certificateParamDto);
    }

    @DeleteMapping("/{id}")

    public void deleteCertificate(@PathVariable Long id) {
        certificateService.deleteCertificate(id);
    }

}
