package com.example.zzz.exerciser.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.zzz.exerciser.R;

public class ExerciseViewHolder extends RecyclerView.ViewHolder {


    protected  TextView exerciseNameView;
    protected  TextView descriptionView;

    public ExerciseViewHolder(View itemView) {
        super(itemView);
        exerciseNameView = (TextView) itemView.findViewById(R.id.exercise_name);
        descriptionView = (TextView) itemView.findViewById(R.id.exercise_description);
    }
}

