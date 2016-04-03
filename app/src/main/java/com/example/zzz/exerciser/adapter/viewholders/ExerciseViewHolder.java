package com.example.zzz.exerciser.adapter.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.zzz.exerciser.R;

public class ExerciseViewHolder extends RecyclerView.ViewHolder {

    public TextView exerciseNameView;
    public TextView descriptionView;
    //lists of repetitions
    public RecyclerView repetitionsView;

    public ExerciseViewHolder(View itemView) {
        super(itemView);
        exerciseNameView = (TextView) itemView.findViewById(R.id.exercise_name);
        descriptionView = (TextView) itemView.findViewById(R.id.exercise_description);
        repetitionsView = (RecyclerView) itemView.findViewById(R.id.exercise_recycler_view);
    }
}

