package com.swiskacper.AllegroInternTask.ListOfRepos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RepoModel {
    private String name;

    @JsonProperty("stargazers_count")
    private Long starCount;

    public RepoModel() {}

    public RepoModel(String name, Long starCount) {
        this.name = name;
        this.starCount = starCount;
    }

    public Long getStarCount() {
        return starCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStarCount(Long starCount) {
        this.starCount = starCount;
    }
}