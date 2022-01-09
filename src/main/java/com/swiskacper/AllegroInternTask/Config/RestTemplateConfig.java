package com.swiskacper.AllegroInternTask.Config;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriTemplateHandler;

import java.time.Duration;

@Configuration
public class RestTemplateConfig {
    private final String authToken;
    private final int TIMEOUT;
    private final String urlPrefix;

    public RestTemplateConfig(GitHubConfig gitHubConfig) {
        this.authToken = gitHubConfig.getAuthToken();
        this.urlPrefix = gitHubConfig.getBASE_URL();
        TIMEOUT = 5000;
    }

    @Bean
    public RestTemplate restTemplate(final RestTemplateBuilder restTemplateBuilder) {
        UriTemplateHandler uriTemplateHandler = new DefaultUriBuilderFactory(urlPrefix);
        return restTemplateBuilder
                .setConnectTimeout(Duration.ofMillis(TIMEOUT))
                .setReadTimeout(Duration.ofMillis(TIMEOUT))
                .uriTemplateHandler(uriTemplateHandler)
                .defaultHeader("Authorization", "Bearer " + authToken)
                .build();
    }
}
