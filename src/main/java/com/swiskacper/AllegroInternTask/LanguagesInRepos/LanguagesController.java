package com.swiskacper.AllegroInternTask.LanguagesInRepos;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/details")
public class LanguagesController {
    private final LanguagesService languagesService;

    public LanguagesController(LanguagesService languagesService) {
        this.languagesService = languagesService;
    }

    @GetMapping("{user}")
    public ResponseEntity<?> getRepositoriesByUser(@PathVariable String user) {
        return new ResponseEntity<>(new LanguagesRepoAnswear(user, languagesService.getDetails(user)), HttpStatus.OK);
    }
}
