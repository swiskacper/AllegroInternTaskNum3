package com.swiskacper.AllegroInternTask.ListOfRepos;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/repos")
public class RepoController {

    private final ReposService reposService;

    @Autowired
    public RepoController(ReposService reposService) {
        this.reposService = reposService;
    }

    @GetMapping("{user}")
    public ResponseEntity<?> getRepositoriesByUser(@RequestParam(value = "page", defaultValue = "1") int page,
                                                   @RequestParam(value = "limit", defaultValue = "30") int limit,
                                                   @PathVariable String user) {
        AbstractMap.SimpleImmutableEntry<UserReposModel, List<String>> response = reposService.getReposByUser(user, page, limit);
        HttpHeaders responseHeaders = new HttpHeaders();
        if (response.getValue() != null) {
            responseHeaders.set("Link", String.valueOf(response.getValue()));
            return getResponseEntity(response, responseHeaders);
        }
        return getResponseEntity(response, responseHeaders);
    }

    private ResponseEntity<?> getResponseEntity(AbstractMap.SimpleImmutableEntry<UserReposModel, List<String>> response, HttpHeaders responseHeaders) {
        if (response.getValue().size() > 0) {
            return new ResponseEntity<>(getObjectsToResponse(response), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ReposResponse(response.getKey(), null), responseHeaders, HttpStatus.OK);
    }


    private ReposResponse getObjectsToResponse(AbstractMap.SimpleImmutableEntry<UserReposModel, List<String>> response) {
        String[] uries = StringUtils.substringsBetween(String.valueOf(response.getValue()), "<", ">");
        List<UriModel> uriModelsList = new LinkedList<>();
        uriModelsList.add(new UriModel("Prev", uries[0]));
        uriModelsList.add(new UriModel("Next", uries[1]));
        return new ReposResponse(response.getKey(), uriModelsList);
    }


}
