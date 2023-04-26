package ru.clevertec.ecl.integration.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import ru.clevertec.ecl.integration.BaseTest;
import ru.clevertec.ecl.model.ErrorResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class ApplicationExceptionHandlerTest extends BaseTest {

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    MockMvc mockMvc;

    @Test
    public void handlerJsonParseException_success() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        MvcResult result = mockMvc.perform(post("/tags")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString("dgsdgsd")))
                .andExpect(status().isBadRequest())
                .andReturn();

        ErrorResponse expectedErrorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, "JSON is not correct", HttpStatus.BAD_REQUEST.toString());
        String actualResponseBody =
                result.getResponse().getContentAsString();
        String expectedResponseBody =
                objectMapper.writeValueAsString(expectedErrorResponse);
        assertThat(actualResponseBody)
                .isEqualToIgnoringWhitespace(expectedResponseBody);
    }
}
