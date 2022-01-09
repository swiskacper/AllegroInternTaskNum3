package com.swiskacper.AllegroInternTask.LanguagesInRepos;


import com.swiskacper.AllegroInternTask.ListOfRepos.ReposService;
import com.swiskacper.AllegroInternTask.ListOfRepos.UserReposModel;
import com.swiskacper.AllegroInternTask.utils.UrlGeneratorUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class LanguagesService {
    private final ReposService reposService;
    private final RestTemplate restTemplate;
    private final UrlGeneratorUtil urlGeneratorUtil;

    public LanguagesService(ReposService reposService, RestTemplate restTemplate, UrlGeneratorUtil urlGeneratorUtil) {
        this.reposService = reposService;
        this.restTemplate = restTemplate;
        this.urlGeneratorUtil = urlGeneratorUtil;
    }

    public Map<String, Integer> getDetails(String name) {
        return getBytes((name));
    }

    private Map<String, Integer> getBytes(String name) {
        int pageNumber = 1;
        int limit = 100;
        List<String> uriesToDetails = new LinkedList<>();
        UserReposModel userReposModel;
        do {
            userReposModel = generateUris(name, pageNumber, limit, uriesToDetails);
            pageNumber++;
        } while (userReposModel.getUserRepos().size() >= limit);

        String allInformation = "";
        LanguagesInRepoModel languagesInRepoModel = new LanguagesInRepoModel();
        for (String uriesToDetail : uriesToDetails) {
            allInformation = String.valueOf(sendRequest(uriesToDetail));
            if (allInformation != null) {
                cuttingInformation(allInformation, languagesInRepoModel);
            }
        }
        return languagesInRepoModel.getResult();
    }

    private void cuttingInformation(String allInformation, LanguagesInRepoModel languagesInRepoModel) {
        allInformation = allInformation.replaceAll("[{]", " ").
                replaceAll("[}]", " ").
                replaceAll(",", " ");
        String[] namesOfLanguages = StringUtils.substringsBetween(allInformation, " ", "=");
        String[] numberOfBytes = StringUtils.substringsBetween(allInformation, "=", " ");
        if (namesOfLanguages != null)
            for (int k = 0; k < namesOfLanguages.length; k++)
                languagesInRepoModel.countBytes(namesOfLanguages[k].trim(), Integer.parseInt(numberOfBytes[k].trim()));
    }

    private UserReposModel generateUris(String name, int pageNumber, int limit, List<String> uriesToDetails) {
        UserReposModel userReposModel;
        userReposModel = reposService.getReposByUser(name, pageNumber, limit).getKey();
        for (int i = 0; i < userReposModel.getUserRepos().size(); i++) {
            uriesToDetails.add(urlGeneratorUtil.generateDetailUri(name) +
                    userReposModel.getUserRepos().get(i).getName() + "/" + "languages");
        }
        return userReposModel;
    }

    private Object sendRequest(String url) {
        return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        }).getBody();
    }
}
