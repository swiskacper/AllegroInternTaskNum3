package com.swiskacper.AllegroInternTask.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UrlGeneratorUtil {
    @Value("${server.port}")
    private String severPort;

    @Value("${githubApiWithUsers}")
    private String githubApiWithUsersUri;

    @Value("${githubApiWithUser}")
    private String githubApiWithUserUri;

    @Value("${localHostUri}")
    private String localhostUri;

    @Value("${repos.article}")
    private String reposArticle;

    @Value("${githubApiRepo}")
    private String githubApiRepo;

    public UrlGeneratorUtil() {
    }

    public String generateFinallUri(String name, int page, int limit) {
        return githubApiWithUsersUri + name + "/repos" + "?page=" + page + "&per_page=" + limit;
    }

    public String generateDetailUri(String name) {
        return githubApiRepo + name + "/";
    }

    public List<String> makeNewPaginationLinks(List<String> oldLinks, String user) {
        List<String> newLinks = new ArrayList<>();
        String beginingOfNewLink = localhostUri + severPort + reposArticle + user;
        String endOfNewLink;
        for (String oldLink : oldLinks) {
            endOfNewLink = oldLink;
            endOfNewLink = endOfNewLink.replaceAll("[0-9]+/repos", "");
            endOfNewLink = endOfNewLink.replaceAll(githubApiWithUserUri, beginingOfNewLink);
            newLinks.add(endOfNewLink);
        }
        return newLinks;
    }
}
