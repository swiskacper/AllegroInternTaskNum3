package com.swiskacper.AllegroInternTask.UtilTests;

import com.swiskacper.AllegroInternTask.utils.UrlGeneratorUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UrlGeneratorUtilTests {
    @Autowired
    UrlGeneratorUtil UrlGeneratorUtil;

    @Test
    public void checkgenerateFinallUri(){
        //given
        String expectedUrlEnd = "https://api.github.com/users/allegro/repos?page=1&per_page=30";

        //when
        String actualUrlEnd = UrlGeneratorUtil.generateFinallUri("allegro", 1, 30);

        //then
        assertEquals(expectedUrlEnd, actualUrlEnd);
    }


    @Test
    public void generateDetailUri(){
        //given
        String expectedUrlEnd = "https://api.github.com/repos/allegro/";

        //when
        String actualUrlEnd = UrlGeneratorUtil.generateDetailUri("allegro");

        //then
        assertEquals(expectedUrlEnd, actualUrlEnd);
    }
}
