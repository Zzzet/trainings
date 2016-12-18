package com.example.zzz.exerciser.adapter.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.zzz.exerciser.R;
import com.example.zzz.exerciser.adapter.RepetitionAdapter;
import com.example.zzz.exerciser.db.domain.Exercise;
import com.example.zzz.exerciser.db.domain.Repetition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ExerciseViewHolder extends RecyclerView.ViewHolder {
    public TextView exerciseNameView;
    public TextView descriptionView;
    public int exetciseId;
    public int lauchedTrainingId;
    Logger logger = LoggerFactory.getLogger(ExerciseViewHolder.class);
    //lists of repetitions
    private RecyclerView repetitionsView;

    private RepetitionAdapter repetitionAdapter;
    private View myItemView;
    private Exercise exercise;

    public ExerciseViewHolder(View itemView) {
        super(itemView);
        myItemView = itemView;

        exerciseNameView = (TextView) itemView.findViewById(R.id.exercise_name);
        descriptionView = (TextView) itemView.findViewById(R.id.exercise_description);
        repetitionsView = (RecyclerView) itemView.findViewById(R.id.repetitions_recycler_view);

    }


    public void setRepetitions(List<Repetition> repetitions) {
        logger.info("setRepetitions(): repetitions.size = {}", repetitions.size());
        repetitionAdapter = new RepetitionAdapter(repetitions);
        repetitionsView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(myItemView.getContext());
        repetitionsView.setLayoutManager(llm);
        repetitionsView.setAdapter(repetitionAdapter);
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
        lauchedTrainingId = exercise.lauchedTrainingId;
        exerciseNameView.setText(exercise.exerciseName);
        descriptionView.setText(exercise.description);
    }
}

