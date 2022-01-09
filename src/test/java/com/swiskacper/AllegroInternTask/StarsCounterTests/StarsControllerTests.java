package com.swiskacper.AllegroInternTask.StarsCounterTests;

import com.swiskacper.AllegroInternTask.StarsCounter.StarsModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class StarsControllerTests {
    private static final String starsControllerPath = "/api/stars";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldReturnMoreThanOneThousandStars() throws Exception {
        //given
        String user = "allegro";

        //when
        MockHttpServletResponse response = mockMvc
                .perform(get(starsControllerPath + "/" + user))
                .andReturn()
                .getResponse();
        StarsModel starsModel = objectMapper.readValue(response.getContentAsByteArray(), StarsModel.class);

        //then
        assertEquals(user, starsModel.getName());
        assertTrue(starsModel.getNumberOfStars() > 1000);
    }

    @Test
    public void shouldReturnLessThanten() throws Exception {
        //given
        String user = "swiskacper";

        //when
        MockHttpServletResponse response = mockMvc
                .perform(get(starsControllerPath + "/" + user))
                .andReturn()
                .getResponse();
        StarsModel starsModel = objectMapper.readValue(response.getContentAsByteArray(), StarsModel.class);

        //then
        assertEquals(user, starsModel.getName());
        assertTrue(starsModel.getNumberOfStars() < 10);
    }
}
