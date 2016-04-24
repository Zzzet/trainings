package com.example.zzz.exerciser.adapter.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.zzz.exerciser.R;
import com.example.zzz.exerciser.adapter.RepetitionAdapter;
import com.example.zzz.exerciser.domain.Repetition;

import java.util.ArrayList;

public class ExerciseViewHolder extends RecyclerView.ViewHolder {

    public TextView exerciseNameView;
    public TextView descriptionView;
    //lists of repetitions
    public RecyclerView repetitionsView;


    RepetitionAdapter repetitionAdapter;

    public ExerciseViewHolder(View itemView) {
        super(itemView);
        exerciseNameView = (TextView) itemView.findViewById(R.id.exercise_name);
        descriptionView = (TextView) itemView.findViewById(R.id.exercise_description);
        repetitionsView = (RecyclerView) itemView.findViewById(R.id.repetitions_recycler_view);


        repetitionAdapter = new RepetitionAdapter(fillRepetitions());
        repetitionsView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(itemView.getContext());
        repetitionsView.setLayoutManager(llm);
        repetitionsView.setAdapter(repetitionAdapter);
    }

    private ArrayList<Repetition> fillRepetitions() {
        ArrayList<Repetition> repetitions = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            repetitions.add(new Repetition("30 kg " + i, i + " times", true));
            System.out.println("added repetition " + i);
        }
        return repetitions;
    }
}

