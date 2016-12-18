package com.example.zzz.exerciser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.zzz.exerciser.adapter.ExerciseAdapter;
import com.example.zzz.exerciser.db.MyDatabase;
import com.example.zzz.exerciser.db.domain.Exercise;
import com.example.zzz.exerciser.db.domain.Repetition;
import com.example.zzz.exerciser.db.domain.Training;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzz on 3/9/16.
 */
public class ExercisesActivity extends AppCompatActivity {
    Logger logger = LoggerFactory.getLogger(ExercisesActivity.class);

    private List<Exercise> exercises;
    private ExerciseAdapter exerciseAdapter;
    private MyDatabase databaseHelper;
    private ArrayList<List<Repetition>> repetitionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_list_layout);
        createToolbar();
        databaseHelper = new MyDatabase(getApplicationContext());

        getExercises();
        getRepetitions();
        exerciseAdapter = new ExerciseAdapter(exercises, repetitionsList);

        RecyclerView exercisesView = (RecyclerView) findViewById(R.id.exercises_recycler_view);
        exercisesView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        exercisesView.setLayoutManager(llm);
        exercisesView.setAdapter(exerciseAdapter);
    }

    private void createToolbar() {
        Intent intent = getIntent();
        String trainingName = intent.getStringExtra("trainingName");

        Toolbar myToolbar = (Toolbar) findViewById(R.id.exercises_toolbar);
        myToolbar.setTitle(trainingName);
        setSupportActionBar(myToolbar);
    }

    @Subscribe
    public List<Repetition> getRepetitions(Exercise ex) {
        return databaseHelper.getAllRepetitionsFromStartedExercise(ex);
    }

    private void getExercises() {
        int trainingId = getIntent().getIntExtra("training_id", -1);
        int launchedTrainingId = getIntent().getIntExtra("launched_training_id", -1);

        if (trainingId >= 0) {
            Training training = new Training();
            training.setId(trainingId);
            training.setLaunchedTrainingId(launchedTrainingId);
            exercises = databaseHelper.getExercisesFromStartedTraining(training);
        } else Toast.makeText(this, "No such training with id -1", Toast.LENGTH_LONG);
    }

    private void getRepetitions() {
        repetitionsList = new <List<Repetition>>ArrayList();
        for (Exercise e : exercises) {
            List<Repetition> repetitions = databaseHelper.getAllRepetitionsFromStartedExercise(e);
            repetitionsList.add(repetitions);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
}
