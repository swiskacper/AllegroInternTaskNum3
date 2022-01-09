package com.swiskacper.AllegroInternTask.StarsCounterTests;


import com.swiskacper.AllegroInternTask.StarsCounter.StarsModel;
import com.swiskacper.AllegroInternTask.StarsCounter.StarsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StarsServiceTests {
    @Autowired
    StarsService starsService;

    @Test
    public void shouldReturnMoreThanOneHoundedStars() {
        //given
        StarsModel starsModel;
        String name = "allegro";

        //when
        starsModel = starsService.getStarsByUser(name);

        //then
        assertTrue(starsModel.getNumberOfStars() > 100);
        assertEquals(starsModel.getName(), name);
    }

    @Test
    public void shouldReturnLessThanOneHoundedStars() {
        //given
        StarsModel starsModel;
        String name = "swiskacper";

        //when
        starsModel = starsService.getStarsByUser(name);

        //then
        assertTrue(starsModel.getNumberOfStars() < 100);
        assertEquals(starsModel.getName(), name);
    }
}
