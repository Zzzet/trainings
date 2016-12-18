package com.example.zzz.exerciser.adapter.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zzz.exerciser.R;
import com.example.zzz.exerciser.adapter.AddRepetitionAdapter;
import com.example.zzz.exerciser.db.domain.Exercise;
import com.example.zzz.exerciser.db.domain.Repetition;

import java.util.ArrayList;

/**
 * Created by zzz on 5/1/16.
 */
public class AddExerciseViewHolder extends RecyclerView.ViewHolder {

    public EditText newExerciseNameView;
    public EditText newDescriptionView;
    public Button addRepetitionBtn;
    public RecyclerView repetitionsView;
    public int position;
    Exercise exercise;

    ArrayList<Repetition> repetitions = new ArrayList<>();
    private AddRepetitionAdapter addRepetitionAdapter;

    public AddExerciseViewHolder(View itemView) {
        super(itemView);
        newExerciseNameView = (EditText) itemView.findViewById(R.id.new_exercise_name);
        newDescriptionView = (EditText) itemView.findViewById(R.id.new_exercise_description);
        addRepetitionBtn = (Button) itemView.findViewById(R.id.add_new_repetition_button);
        repetitionsView = (RecyclerView) itemView.findViewById(R.id.add_repetitions_recycler_view);

        addRepetitionAdapter = new AddRepetitionAdapter(repetitions);
        LinearLayoutManager llm = new LinearLayoutManager(itemView.getContext());
        repetitionsView.setLayoutManager(llm);
        repetitionsView.setAdapter(addRepetitionAdapter);

        addRepetitionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repetitions.add(new Repetition("", "", 1));
                addRepetitionAdapter.notifyItemInserted(addRepetitionAdapter.getItemCount() + 1);
            }
        });

        newExerciseNameView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String text = v.getText().toString();
                exercise.exerciseName = text;
                return true;
            }
        });


        newExerciseNameView.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                if (exercise != null) {
                    String text = s.toString();
                    exercise.exerciseName = text;
                }
            }
        });


        newDescriptionView.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                if (exercise != null) {
                    String text = s.toString();
                    exercise.description = text;
                }
            }
        });
    }

    public void setListElement(Exercise exercise) {
        this.exercise = exercise;
        newDescriptionView.setText(exercise.description);
        newExerciseNameView.setText(exercise.exerciseName);
    }
}
