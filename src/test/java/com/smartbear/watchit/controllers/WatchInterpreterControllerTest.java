package com.smartbear.watchit.controllers;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

class WatchInterpreterControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void init() {

        openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(
                        new WatchInterpreterController())
                .build();
    }

    @Test
    public void interpret_whenValidTime_returnTimeSpelledInWords() throws Exception {

        //Given
        final String time = "01:00";

        final MockHttpServletRequestBuilder requestBuilder =
                get("/v1/watch/interpreter")
                        .param("time", time)
                        .contentType(MediaType.APPLICATION_JSON);
        //When
        final ResultActions result = mockMvc.perform(requestBuilder);

        //Then
        result.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.is("one o'clock"))).andDo(print());
    }
}
