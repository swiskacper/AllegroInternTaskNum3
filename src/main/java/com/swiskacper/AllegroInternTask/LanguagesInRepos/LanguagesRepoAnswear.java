package com.swiskacper.AllegroInternTask.LanguagesInRepos;

import java.util.Map;

public class LanguagesRepoAnswear {
    private String user;
    private Map<String, Integer> result;

    public LanguagesRepoAnswear(String user, Map<String, Integer> result) {
        this.user = user;
        this.result = result;
    }

    public Map<String, Integer> getResult() {
        return result;
    }

    public String getUser() {
        return user;
    }

    public void setResult(Map<String, Integer> result) {
        this.result = result;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
