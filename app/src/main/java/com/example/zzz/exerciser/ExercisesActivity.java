package com.example.zzz.exerciser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.zzz.exerciser.adapter.ExerciseAdapter;
import com.example.zzz.exerciser.domain.Exercise;

import java.util.ArrayList;

/**
 * Created by zzz on 3/9/16.
 */
public class ExercisesActivity extends AppCompatActivity {
    ArrayList<Exercise> exercises = new ArrayList<>();
    ExerciseAdapter exerciseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercises_layout);
        createToolbar();

        fillExercises();
        exerciseAdapter = new ExerciseAdapter(exercises);
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

    private void fillExercises() {
        for (int i = 0; i < 6; i++) {
            exercises.add(new Exercise("very hard exercise" + i, "do it" + i));
            System.out.println("added exercise " + i);
        }
    }

}
