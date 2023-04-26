package ru.clevertec.ecl.integration.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import ru.clevertec.ecl.integration.BaseTest;
import ru.clevertec.ecl.model.requests.tag.TagRequest;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
public class TagControllerTest extends BaseTest {

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    MockMvc mockMvc;

    @Test
    public void getTags_success() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/tags"))
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertThat(mvcResult.getResponse().getContentAsString().contains("ZARA01")).isTrue();
        Assertions.assertThat(mvcResult.getResponse().getContentAsString().contains("PUMA01")).isTrue();
        Assertions.assertThat(mvcResult.getResponse().getContentAsString().contains("DC01")).isTrue();
    }

    @Test
    public void getTagById_success() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/tags/2"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value("2"))
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertThat(mvcResult.getResponse().getContentAsString().contains("PUMA01")).isTrue();
        Assertions.assertThat(mvcResult.getResponse().getContentAsString().contains("DC01")).isFalse();

    }

    @Test
    public void createTag_success() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/tags")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(createRequest())))
                .andExpect(status().isOk());
    }

    @Test
    public void updateTag_success() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(put("/tags/2")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(createRequest())))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteTag_success() throws Exception {

        mockMvc.perform(delete("/tags/1"))
                .andExpect(status().isOk());

    }

    private static TagRequest createRequest() {
        TagRequest request = new TagRequest();
        request.setName("CIRCA");
        request.setCertificateList(new ArrayList<>());
        return request;
    }
}
