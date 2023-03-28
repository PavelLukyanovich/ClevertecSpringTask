package ru.clevertec.ecl.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.ecl.model.dtos.CertificateDto;
import ru.clevertec.ecl.model.dtos.CertificateParamDto;
import ru.clevertec.ecl.model.requests.CreateCertificateRequest;
import ru.clevertec.ecl.model.requests.UpdateCertificateRequest;
import ru.clevertec.ecl.service.CertificateService;
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
                                          @RequestParam(required = false) SortType sortName) {

        CertificateParamDto certificateParam = new CertificateParamDto();
        certificateParam.setTagName(tagName);
        certificateParam.setCertName(certName);
        certificateParam.setCertDescription(certDescription);
        certificateParam.setSortDate(sortDate);
        certificateParam.setSortName(sortName);
        return certificateService.getCertificates(certificateParam);
    }

    @GetMapping("/{id}")
    public CertificateDto getCertificateById(@PathVariable("id") Integer id) {

        return certificateService.getCertificateById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean createCertificate(@RequestBody CreateCertificateRequest request) {
        return certificateService.createCertificate(request);
    }

    @PutMapping("/{id}")
    public boolean updateCertificate(@RequestBody UpdateCertificateRequest request, @PathVariable String id) {
        return certificateService.updateCertificate(Integer.valueOf(id), request);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCertificate(@PathVariable Integer id) {
        return certificateService.deleteCertificate(id);
    }

}
