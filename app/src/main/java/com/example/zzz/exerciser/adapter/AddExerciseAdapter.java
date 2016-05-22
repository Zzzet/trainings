package com.example.zzz.exerciser.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zzz.exerciser.R;
import com.example.zzz.exerciser.adapter.viewholders.AddExerciseViewHolder;
import com.example.zzz.exerciser.domain.Exercise;

import java.util.ArrayList;

/**
 * Created by zzz on 5/1/16.
 */
    public class AddExerciseAdapter extends RecyclerView.Adapter<AddExerciseViewHolder> {


    ArrayList<Exercise> exercises;

    public AddExerciseAdapter(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }

    @Override
    public AddExerciseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.add_exercise_layout, parent, false);

        return new AddExerciseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AddExerciseViewHolder holder, int position) {
        Exercise exercise = exercises.get(position);
        holder.setListElement(exercise);
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }
}
