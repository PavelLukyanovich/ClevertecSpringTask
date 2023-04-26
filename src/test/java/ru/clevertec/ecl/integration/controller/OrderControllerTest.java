package ru.clevertec.ecl.integration.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import ru.clevertec.ecl.integration.BaseTest;
import ru.clevertec.ecl.model.requests.order.OrderRequest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
                        .content(objectMapper.writeValueAsString(createOrderRequest())))
                .andExpect(status().isOk());
    }

    @Test
    public void mostWidelyUsedTag_success() throws Exception {

        mockMvc.perform(get("/orders/widely/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void getUsersOrderInformation_success() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/orders/info/1"))
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertThat(mvcResult.getResponse().getContentAsString().contains("100")).isTrue();
        Assertions.assertThat(mvcResult.getResponse().getContentAsString().contains("2000-01-01")).isTrue();

    }

    @Test
    public void getOrdersByUserId_success() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/users/2"))
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertThat(mvcResult.getResponse().getContentAsString().contains("200")).isTrue();
        Assertions.assertThat(mvcResult.getResponse().getContentAsString().contains("2000-02-01")).isTrue();
    }

    private static OrderRequest createOrderRequest() {
        return new OrderRequest(3L, 2L);
    }

}
