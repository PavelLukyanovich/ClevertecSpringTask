package ru.clevertec.ecl.integration.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import ru.clevertec.ecl.integration.BaseTest;
import ru.clevertec.ecl.model.entities.GiftCertificate;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
public class CertificateControllerTest extends BaseTest {

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private MockMvc mockMvc;

    @Test
    public void getCertificateBy_success() throws Exception {

        mockMvc.perform(get("/certificates"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getCertificateById_success() throws Exception {

        mockMvc.perform(get("/certificates/2"))
                .andExpectAll(
                        jsonPath("$.name").value("PUMA"),
                        status().isOk());
    }

    @Test
    public void createCertificate_success() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/certificates")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(createCertificate())))
                .andExpect(status().isOk());

    }

    @Test
    public void whenCreateCertificateWithBadRequestData_shouldReturn400() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        GiftCertificate badReqCertificate = createCertificate();
        badReqCertificate.setCreateDate("123");
        mockMvc.perform(post("/certificates")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(badReqCertificate)))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void updateDurationCertificate_success() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        GiftCertificate certificate = createCertificate();

        mockMvc.perform(put("/certificates/duration/1")
                        .contentType("application/json")
                        .param("duration", "10")
                        .content(objectMapper.writeValueAsString(certificate)))
                .andExpect(status().isOk());
    }

    @Test
    public void updatePriceCertificate_success() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        GiftCertificate certificate = createCertificate();

        mockMvc.perform(put("/certificates/price/1")
                        .contentType("application/json")
                        .param("price", "12")
                        .content(objectMapper.writeValueAsString(certificate)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteCertificate_success() throws Exception {

        mockMvc.perform(delete("/certificates/1"))
                .andExpect(status().isOk());

    }

    private static GiftCertificate createCertificate() {

        return new GiftCertificate(
                4L,
                "VANS",
                "all vans",
                100,
                360,
                "2023-04-01",
                "2023-04-01",
                new ArrayList<>()
        );
    }

}
