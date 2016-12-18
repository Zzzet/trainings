package com.example.zzz.exerciser.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zzz.exerciser.ExercisesActivity;
import com.example.zzz.exerciser.R;
import com.example.zzz.exerciser.adapter.viewholders.ExerciseViewHolder;
import com.example.zzz.exerciser.db.domain.Exercise;
import com.example.zzz.exerciser.db.domain.Repetition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzz on 4/3/16.
 */
public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseViewHolder> {
    private final ArrayList<List<Repetition>> repetitionsList;
    private List<Exercise> exercises;

    public ExerciseAdapter(List<Exercise> exercises, ArrayList<List<Repetition>> repetitionsList) {
        this.exercises = exercises;
        this.repetitionsList = repetitionsList;
    }

    @Override
    public ExerciseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.exercise_layout, parent, false);

        return new ExerciseViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(ExerciseViewHolder holder, int position) {
        Exercise exercise = exercises.get(position);
        holder.setExercise(exercise);
        holder.setRepetitions(repetitionsList.get(position));
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

}
