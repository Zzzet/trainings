package com.example.zzz.exerciser.domain;

/**
 * Created by zzz on 2/29/16.
 */
public class Training {
    public String trainingName;
    public String description;
    public String lastDate;

    public Training(String trainingName, String description, String lastDate) {
        this.trainingName = trainingName;
        this.lastDate = lastDate;
        this.description = description;
    }
}
