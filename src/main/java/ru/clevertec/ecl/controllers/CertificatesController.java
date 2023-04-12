package ru.clevertec.ecl.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.ecl.model.dtos.CertificateParamDto;
import ru.clevertec.ecl.model.entities.GiftCertificate;
import ru.clevertec.ecl.model.requests.certificate.CreateCertificateRequest;
import ru.clevertec.ecl.model.requests.certificate.UpdateCertificateRequest;
import ru.clevertec.ecl.service.certificate.CertificateService;
import ru.clevertec.ecl.utils.SortType;

import java.util.List;

@RestController
@RequestMapping("/certificates")
@RequiredArgsConstructor

public class CertificatesController {

    private final CertificateService certificateService;


    @GetMapping()
    public List<GiftCertificate> getCertificatesBy(@RequestParam(required = false) String tagName,
                                                   @RequestParam(required = false) String certName,
                                                   @RequestParam(required = false) String certDescription,
                                                   @RequestParam(required = false) SortType sortDate,
                                                   @RequestParam(required = false) SortType sortName) {

        CertificateParamDto certificateParam = new CertificateParamDto();
        certificateParam.setTagName(tagName);
        certificateParam.setCertName(certName);
        certificateParam.setCertDescription(certDescription);
        certificateParam.setSortDate(sortDate);
        certificateParam.setSortName(sortName);
        System.out.println(certificateParam);
        return certificateService.getCertificates(certificateParam);
    }

    @GetMapping("/{id}")

    public GiftCertificate getCertificateById(@PathVariable("id") Long id) {
        return certificateService.getCertificateById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)

    public GiftCertificate createCertificate(@RequestBody CreateCertificateRequest request) {
        return certificateService.createCertificate(request);
    }

    @PutMapping("/{id}")

    public boolean updateCertificate(@RequestBody UpdateCertificateRequest request, @PathVariable Long id) {
        return certificateService.updateCertificate(id, request);
    }

    @DeleteMapping("/{id}")

    public void deleteCertificate(@PathVariable Long id) {
        certificateService.deleteCertificate(id);
    }

}
