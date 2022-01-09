package com.swiskacper.AllegroInternTask.StarsCounter;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stars")
public class StarsController {
    private final StarsService starsService;

    public StarsController(StarsService starsService) {
        this.starsService = starsService;
    }

    @GetMapping("{user}")
    public ResponseEntity<?> getStarsByUser(@PathVariable String user) {
        return new ResponseEntity<>(starsService.getStarsByUser(user), HttpStatus.OK);
    }
}
