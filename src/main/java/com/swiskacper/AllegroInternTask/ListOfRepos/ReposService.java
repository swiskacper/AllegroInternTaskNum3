package com.swiskacper.AllegroInternTask.ListOfRepos;


import com.swiskacper.AllegroInternTask.Exceptions.RestTemplateResponseErrorHandler;
import com.swiskacper.AllegroInternTask.utils.UrlGeneratorUtil;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class ReposService {
    private final RestTemplate restTemplate;
    private final UrlGeneratorUtil urlGeneratorUtil;

    public ReposService(RestTemplate restTemplate, UrlGeneratorUtil urlGeneratorUtil) {
        this.restTemplate = restTemplate;
        this.urlGeneratorUtil = urlGeneratorUtil;
        RestTemplateResponseErrorHandler restTemplateResponseErrorHandler = new RestTemplateResponseErrorHandler();
        restTemplate.setErrorHandler(restTemplateResponseErrorHandler);
    }

    public AbstractMap.SimpleImmutableEntry<UserReposModel, List<String>> getReposByUser(String user, int page, int limit) {
        ResponseEntity<List<RepoModel>> responseEntity = sendRequest(urlGeneratorUtil.generateFinallUri(user, page, limit));
        List<String> paginationLinks = new LinkedList<>();
        HttpHeaders headers = responseEntity.getHeaders();
        if (headers.get("Link") != null)
            paginationLinks = urlGeneratorUtil.makeNewPaginationLinks(Objects.requireNonNull(headers.get("Link")), user);
        return new AbstractMap.SimpleImmutableEntry<>(new UserReposModel(user, responseEntity.getBody()), paginationLinks);

    }

    private ResponseEntity<List<RepoModel>> sendRequest(String url) {
        return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
    }
}
