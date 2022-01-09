package com.swiskacper.AllegroInternTask.ListOfReposTests;

import com.swiskacper.AllegroInternTask.ListOfRepos.ReposResponse;
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
public class RepoControllerTests {
    private static final String reposControllerPath = "/api/repos";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldReturn30ReposAndName() throws Exception {
        //given
        String user = "allegro";

        //when
        MockHttpServletResponse response = mockMvc
                .perform(get(reposControllerPath + "/" + user))
                .andReturn()
                .getResponse();
        ReposResponse reposResponse = objectMapper.readValue(response.getContentAsByteArray(), ReposResponse.class);


        //then
        assertEquals(30, reposResponse.getUserReposModel().getUserRepos().size());
        assertEquals(user, reposResponse.getUserReposModel().getNameOfUser());
    }

    @Test
    public void shouldReturn50ReposAndName() throws Exception {
        //given
        String user = "allegro";

        //when
        MockHttpServletResponse response = mockMvc
                .perform(get(reposControllerPath + "/" + user + "?page=1&limit=50"))
                .andReturn()
                .getResponse();
        ReposResponse reposResponse = objectMapper.readValue(response.getContentAsByteArray(), ReposResponse.class);


        //then
        assertEquals(50, reposResponse.getUserReposModel().getUserRepos().size());
        assertEquals(user, reposResponse.getUserReposModel().getNameOfUser());
    }
}
