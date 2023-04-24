package ru.clevertec.ecl.integration.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import ru.clevertec.ecl.integration.BaseTest;
import ru.clevertec.ecl.model.entities.GiftCertificate;
import ru.clevertec.ecl.model.entities.Order;
import ru.clevertec.ecl.model.entities.User;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@AutoConfigureMockMvc
public class OrderControllerTest extends BaseTest {

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private MockMvc mockMvc;

    @Test
    public void createOrder_success() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/orders")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(createOrder())))
                .andExpect(status().isOk());
    }

    @Test
    public void mostWidelyUsedTag_success() throws Exception {

        mockMvc.perform(get("/orders/widely/1"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    private static Order createOrder() {
        return new Order(
                4L,
                125,
                "2023-01-01",
                CertificateControllerTest.createCertificate(),
                new User(2L, "Pav", "Luk", new ArrayList<>())
        );
    }

}
