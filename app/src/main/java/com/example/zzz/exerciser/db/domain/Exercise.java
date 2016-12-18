package com.example.zzz.exerciser.db.domain;

/**
 * Created by zzz on 4/3/16.
 */
public class Exercise {
    public String exerciseName;
    public String description;
    public int id;
    public int training_id;
    public int lauchedTrainingId;
    public int status;


    public Exercise(String exerciseName, String description) {
        this.exerciseName = exerciseName;
        this.description = description;
    }

    public Exercise() {
    }
}
