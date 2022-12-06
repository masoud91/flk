package com.github.masoud91.flk.presentation.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.masoud91.flk.presentation.dto.PositionDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class LocationControllerTest {

    private final MockMvc mockMvc;

    @Autowired
    public LocationControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void should_submit_location() throws Exception {
        PositionDto dto = new PositionDto(12.34, 56.78);
        String riderId = "100";

        mockMvc.perform(
                        post("/location/100/now")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content(new ObjectMapper().writeValueAsString(dto))
                )
                .andExpect(status().isOk());
    }

    @Test
    void should_get_n_max_location() throws Exception {
        String riderId = "100";

        mockMvc.perform(
                        get("/location/" + riderId + "?max=" + 10)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.rider_id", is(riderId)));
        ;
    }

}