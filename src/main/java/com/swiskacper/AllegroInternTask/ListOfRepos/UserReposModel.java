package com.swiskacper.AllegroInternTask.ListOfRepos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserReposModel {
    private String nameOfUser;

    @JsonProperty("user_repos")
    private final List<RepoModel> userRepos;

    public UserReposModel(String nameOfUser, List<RepoModel> userRepos) {
        this.nameOfUser = nameOfUser;
        this.userRepos = userRepos;
    }

    public List<RepoModel> getUserRepos() {
        return userRepos;
    }

    public String getNameOfUser() {
        return nameOfUser;
    }

    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }
}
