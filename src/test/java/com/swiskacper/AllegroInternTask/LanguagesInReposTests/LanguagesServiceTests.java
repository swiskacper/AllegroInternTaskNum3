package com.swiskacper.AllegroInternTask.LanguagesInReposTests;


import com.swiskacper.AllegroInternTask.LanguagesInRepos.LanguagesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LanguagesServiceTests {
    @Autowired
    LanguagesService languagesService;

    @Test
    public void shouldReturnLessThanOneHoundedLanguagesFalse() {
        //given
        Map<String, Integer> testMap;
        String name = "swiskacper";

        //when
        testMap = languagesService.getDetails(name);

        //then
        assertFalse(testMap.size() > 100);
    }

    @Test
    public void shouldReturnLessThanOneHoundedLanguagesTrue() {
        //given
        Map<String, Integer> testMap;
        String name = "swiskacper";

        //when

        testMap = languagesService.getDetails(name);

        //then
        assertTrue(testMap.size() < 100);
    }
}
