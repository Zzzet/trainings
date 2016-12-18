package com.example.zzz.exerciser.db;

import com.example.zzz.exerciser.db.domain.Exercise;
import com.example.zzz.exerciser.db.domain.Training;

import java.util.List;

public interface IDatabaseHandler {

    public void addTraining();

    public void getTraining();

    public List<Training> getAllTrainings();

    public void addExercise();

    public void getExercise();

    public List<Exercise> getAllExercises(Training training);

    public List<Exercise> getExercisesFromStartedTraining(Training training);

    public void addRepetition();

    public void getRepetition();

    public void getAllRepetitions();

    public void addHistoryItem();


}