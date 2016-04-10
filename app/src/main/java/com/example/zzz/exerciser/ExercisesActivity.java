package com.example.zzz.exerciser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zzz.exerciser.adapter.ExerciseAdapter;
import com.example.zzz.exerciser.adapter.RepetitionAdapter;
import com.example.zzz.exerciser.domain.Exercise;
import com.example.zzz.exerciser.domain.Repetition;

import java.util.ArrayList;

/**
 * Created by zzz on 3/9/16.
 */
public class ExercisesActivity extends AppCompatActivity {
    ArrayList<Repetition> repetitions = new ArrayList<>();
    ArrayList<RecyclerView> repetitionsViews = new ArrayList<>();
    ArrayList<Exercise> exercises = new ArrayList<>();

    RepetitionAdapter repetitionAdapter;
    ExerciseAdapter exerciseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fillRepetitions();
        fillExercises();
        setContentView(R.layout.exercise_list_layout);


        //fill exercise with repetitions
        for (int i = 0; i < 6; i++) {
            repetitionAdapter = new RepetitionAdapter(repetitions);

            //Возвращает Null потому что exercise_recycler_view нет в exercise_list_layout
            RecyclerView repetitionsRecyclerView = (RecyclerView) findViewById(R.id.exercise_recycler_view);
            repetitionsRecyclerView.setHasFixedSize(true);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            repetitionsRecyclerView.setLayoutManager(llm);
            repetitionsRecyclerView.setAdapter(repetitionAdapter);
            repetitionsViews.add(repetitionsRecyclerView);
        }


        exerciseAdapter = new ExerciseAdapter(exercises, repetitionsViews);

        RecyclerView exercisesView = (RecyclerView) findViewById(R.id.exercises_recycler_view);
        exercisesView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        exercisesView.setLayoutManager(llm);
        exercisesView.setAdapter(exerciseAdapter);

    }


    private void fillRepetitions() {
        for (int i = 0; i < 6; i++) {
            repetitions.add(new Repetition("30 kg " + i, i + " times", true));
            System.out.println("added repetition " + i);
        }
    }

    private void fillExercises() {
        for (int i = 0; i < 6; i++) {
            exercises.add(new Exercise("very hard exercise" + i, "do it" + i));
            System.out.println("added exercise " + i);
        }
    }

}
