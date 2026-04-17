package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OumuamuaObservationControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createAndFetchObservations() throws Exception {
        String requestBody = "{\"observationDate\":\"2017-10-19\",\"details\":\"First interstellar object observed\"}";

        mockMvc.perform(post("/api/observations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.observationDate").value("2017-10-19"))
                .andExpect(jsonPath("$.details").value("First interstellar object observed"));

        mockMvc.perform(get("/api/observations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}
