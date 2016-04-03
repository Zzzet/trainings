package com.example.zzz.exerciser.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zzz.exerciser.R;
import com.example.zzz.exerciser.adapter.viewholders.ExerciseViewHolder;
import com.example.zzz.exerciser.domain.Exercise;

import java.util.ArrayList;

/**
 * Created by zzz on 4/3/16.
 */
public class ExerciseAdapter  extends RecyclerView.Adapter<ExerciseViewHolder>  {
    ArrayList<Exercise> exercises;
    ArrayList<RecyclerView> repetitions;

    public ExerciseAdapter(ArrayList<Exercise> exercises,  ArrayList<RecyclerView> repetitions) {
        this.exercises = exercises;
        this.repetitions = repetitions;
    }

    @Override
    public ExerciseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.exercises_layout, parent, false);

        return new ExerciseViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(ExerciseViewHolder holder, int position) {
        Exercise exercise = exercises.get(position);
        RecyclerView repetition = repetitions.get(position);

        holder.exerciseNameView.setText(exercise.exerciseName);
        holder.descriptionView.setText(exercise.description);
        holder.repetitionsView = repetition;
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

}
