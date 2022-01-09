package com.swiskacper.AllegroInternTask.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GitHubConfig {
    @Value("${authToken}")
    private String authToken;
    @Value("${githubApiWithUsers}")
    private String urlPrefix;

    public GitHubConfig() {}

    public String getAuthToken() {
        return authToken;
    }

    public String getBASE_URL() {
        return urlPrefix;
    }

}
