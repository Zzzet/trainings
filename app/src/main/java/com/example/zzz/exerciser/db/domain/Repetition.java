package com.example.zzz.exerciser.db.domain;

/**
 * Created by zzz on 4/2/16.
 */
public class Repetition {
    public int id;
    public String name;
    public String description;

    public String weight;
    public String count;
    public int status;


    public Repetition() {

    }

    public Repetition(String repetitionWeight, String repetitionCount, int repetitionCheckbox) {
        this.weight = repetitionWeight;
        this.count = repetitionCount;
        this.status = repetitionCheckbox;
    }

    public boolean getStatus() {
        return status == 1 ? true : false;
    }
}
