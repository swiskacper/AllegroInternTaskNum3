package com.swiskacper.AllegroInternTask.ListOfReposTests;

import com.swiskacper.AllegroInternTask.ListOfRepos.ReposService;
import com.swiskacper.AllegroInternTask.ListOfRepos.UserReposModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.AbstractMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ReposServiceTests {
    @Autowired
    ReposService reposService;

    @Test
    public void shouldReturnTenRepos() {
        //given
        AbstractMap.SimpleImmutableEntry<UserReposModel, List<String>> serviceResponse;

        //when
        serviceResponse = reposService.getReposByUser("allegro", 1, 10);

        //then
        assertEquals(10, serviceResponse.getKey().getUserRepos().size());
        assertFalse(serviceResponse.getValue().isEmpty());
    }

    @Test
    public void shouldReturnFiftyRepos() {
        //given
        AbstractMap.SimpleImmutableEntry<UserReposModel, List<String>> serviceResponse;

        //when
        serviceResponse = reposService.getReposByUser("allegro", 1, 50);

        //then
        assertEquals(50, serviceResponse.getKey().getUserRepos().size());
        assertFalse(serviceResponse.getValue().isEmpty());
    }
}
