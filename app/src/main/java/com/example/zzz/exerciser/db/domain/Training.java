package com.example.zzz.exerciser.db.domain;

/**
 * Created by zzz on 2/29/16.
 */
public class Training {
    public int id;
    public String name;
    public String description;
    public String lastFinished = "date";
    public int launchedTrainingId;
    public int status;

    public Training() {
    }


    public Training(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getStatus() {
        return status;
    }

    public int getLaunchedTrainingId() {
        return launchedTrainingId;
    }

    public void setLaunchedTrainingId(int startedTrainingId) {
        this.launchedTrainingId = startedTrainingId;
    }
}
