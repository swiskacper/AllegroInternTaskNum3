package com.swiskacper.AllegroInternTask.ListOfRepos;

public class UriModel {
    private String direction;
    private String uri;

    public UriModel(String direction, String uri) {
        this.direction = direction;
        this.uri = uri;
    }

    public String getDirection() {
        return direction;
    }

    public String getUri() {
        return uri;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
