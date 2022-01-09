package com.swiskacper.AllegroInternTask.StarsCounter;

public class StarsModel {
    private String name;
    private Long numberOfStars;

    public StarsModel() {}

    public StarsModel(String name, Long numberOfStars) {
        this.name = name;
        this.numberOfStars = numberOfStars;
    }

    public String getName() {
        return name;
    }

    public Long getNumberOfStars() {
        return numberOfStars;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfStars(Long numberOfStars) {
        this.numberOfStars = numberOfStars;
    }
}
