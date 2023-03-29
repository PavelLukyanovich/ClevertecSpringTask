package ru.clevertec.ecl.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.ecl.model.dtos.CertificateTagDto;
import ru.clevertec.ecl.service.CertificateTagService;

import java.util.List;

@RestController
@RequestMapping("certificate-tag")
@RequiredArgsConstructor
public class CertificateTagController {

    private final CertificateTagService certificateTagService;

    @GetMapping
    public List<CertificateTagDto> getCertificateTags() {
        return certificateTagService.getCertificateTags();
    }

    @GetMapping("/{id}")
    public CertificateTagDto getCertificateTagById(@PathVariable("id") Integer id) {
        return certificateTagService.getCertificateTagById(id);
    }
}
