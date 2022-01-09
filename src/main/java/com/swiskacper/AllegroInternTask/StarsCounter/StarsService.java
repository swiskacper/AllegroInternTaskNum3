package com.swiskacper.AllegroInternTask.StarsCounter;


import com.swiskacper.AllegroInternTask.ListOfRepos.ReposService;
import com.swiskacper.AllegroInternTask.ListOfRepos.UserReposModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StarsService {
    private final ReposService reposService;

    public StarsService(ReposService reposService) {
        this.reposService = reposService;
    }

    public StarsModel getStarsByUser(String name) {
        return new StarsModel(name, countAllStars(name));
    }

    private long countAllStars(String name) {
        long totalStars = 0L;
        int pageNumber = 1;
        int limit = 100;
        UserReposModel userReposModel;
        do {
            userReposModel = reposService.getReposByUser(name, pageNumber, limit).getKey();
            for (int i = 0; i < userReposModel.getUserRepos().size(); i++) {
                totalStars = totalStars + userReposModel.getUserRepos().get(i).getStarCount();
            }
            pageNumber++;
        } while (userReposModel.getUserRepos().size() == limit);
        return totalStars;
    }
}
