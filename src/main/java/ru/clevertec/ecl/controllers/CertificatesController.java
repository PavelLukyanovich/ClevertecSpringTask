package ru.clevertec.ecl.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.ecl.dao.CertificateDao;
import ru.clevertec.ecl.model.GiftCertificate;

import java.util.List;

@RestController
@RequestMapping("/certificates")
@RequiredArgsConstructor
public class CertificatesController {

    private final CertificateDao certificateDao;


    @GetMapping()
    @ResponseBody
    public List<GiftCertificate> getCertificates() {

        return certificateDao.getCertificates();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public GiftCertificate getCertificateById(@PathVariable("id") Integer id) {

        return certificateDao.getCertificateById(id);
    }
}
