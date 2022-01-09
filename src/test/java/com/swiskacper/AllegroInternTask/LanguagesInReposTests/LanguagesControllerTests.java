package com.swiskacper.AllegroInternTask.LanguagesInReposTests;

import com.swiskacper.AllegroInternTask.LanguagesInRepos.LanguagesInRepoModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class LanguagesControllerTests {
    private static final String starsControllerPath = "/api/details";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldReturnMoreThanOneLanguage() throws Exception {
        //given
        String user = "swiskacper";

        //when
        MockHttpServletResponse response = mockMvc
                .perform(get(starsControllerPath + "/" + user))
                .andReturn()
                .getResponse();

        LanguagesInRepoModel languagesInRepoModel = objectMapper.readValue(response.getContentAsByteArray(), LanguagesInRepoModel.class);

        //then
        assertTrue(languagesInRepoModel.getResult().size() > 1);
    }


    @Test
    public void shouldReturnLessTenLanguages() throws Exception {
        //given
        String user = "swiskacper";

        //when
        MockHttpServletResponse response = mockMvc
                .perform(get(starsControllerPath + "/" + user))
                .andReturn()
                .getResponse();

        LanguagesInRepoModel languagesInRepoModel = objectMapper.readValue(response.getContentAsByteArray(), LanguagesInRepoModel.class);

        //then
        assertTrue(languagesInRepoModel.getResult().size() < 10);
    }
}
