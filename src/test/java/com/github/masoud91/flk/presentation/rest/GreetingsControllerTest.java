package com.github.masoud91.flk.presentation.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.masoud91.flk.presentation.dto.GreetingRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class GreetingsControllerTest {

    private final MockMvc mockMvc;

    @Autowired
    public GreetingsControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void should_say_welcome_to_the_user() throws Exception {
        GreetingRequestDto dto = new GreetingRequestDto("John");

        mockMvc.perform(
                        post("/greetings")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content(new ObjectMapper().writeValueAsString(dto))
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.message", is("Welcome John!")));
    }

}