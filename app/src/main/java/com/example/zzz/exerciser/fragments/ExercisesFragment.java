package com.example.zzz.exerciser.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.zzz.exerciser.R;
import com.example.zzz.exerciser.adapter.ExerciseAdapter;
import com.example.zzz.exerciser.db.MyDatabase;
import com.example.zzz.exerciser.db.domain.Exercise;
import com.example.zzz.exerciser.db.domain.Repetition;
import com.example.zzz.exerciser.db.domain.Training;

import org.greenrobot.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzz on 3/9/16.
 */
public class ExercisesFragment extends Fragment {
    Logger logger = LoggerFactory.getLogger(ExercisesFragment.class);

    private List<Exercise> exercises;
    private ExerciseAdapter exerciseAdapter;
    private MyDatabase databaseHelper;
    private ArrayList<List<Repetition>> repetitionsList;

    private int trainingId = 0;
    private int launchedTrainingId = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        trainingId = getArguments().getInt("training_id");
        launchedTrainingId = getArguments().getInt("launched_training_id");

        databaseHelper = new MyDatabase(getActivity().getApplicationContext());

        getExercises();
        getRepetitions();
        exerciseAdapter = new ExerciseAdapter(exercises, repetitionsList);

        RecyclerView exercisesView = (RecyclerView) getActivity().findViewById(R.id.trainings_fr_recycler_view);
        exercisesView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        exercisesView.setLayoutManager(llm);
        exercisesView.setAdapter(exerciseAdapter);
    }

    //todo update layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.trainings_fragment_layout, container, false);
    }


    @Subscribe
    public List<Repetition> getRepetitions(Exercise ex) {
        return databaseHelper.getAllRepetitionsFromStartedExercise(ex);
    }

    private void getExercises() {
        if (trainingId >= 0) {
            Training training = new Training();
            training.setId(trainingId);
            training.setLaunchedTrainingId(launchedTrainingId);
            exercises = databaseHelper.getExercisesFromStartedTraining(training);
        } else Toast.makeText(getActivity(), "No such training with id -1", Toast.LENGTH_LONG);
    }

    private void getRepetitions() {
        repetitionsList = new <List<Repetition>>ArrayList();
        for (Exercise e : exercises) {
            List<Repetition> repetitions = databaseHelper.getAllRepetitionsFromStartedExercise(e);
            repetitionsList.add(repetitions);
        }
    }


}
