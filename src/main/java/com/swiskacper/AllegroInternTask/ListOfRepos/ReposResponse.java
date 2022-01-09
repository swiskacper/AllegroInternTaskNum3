package com.swiskacper.AllegroInternTask.ListOfRepos;

import java.util.List;

public class ReposResponse {
    UserReposModel userReposModel;
    List<UriModel> uriModelsList;

    public ReposResponse(UserReposModel userReposModel, List<UriModel> uriModelsList) {
        this.userReposModel = userReposModel;
        this.uriModelsList = uriModelsList;
    }

    public List<UriModel> getUriModelsList() {
        return uriModelsList;
    }

    public UserReposModel getUserReposModel() {
        return userReposModel;
    }

    public void setUriModelsList(List<UriModel> uriModelsList) {
        this.uriModelsList = uriModelsList;
    }

    public void setUserReposModel(UserReposModel userReposModel) {
        this.userReposModel = userReposModel;
    }
}
