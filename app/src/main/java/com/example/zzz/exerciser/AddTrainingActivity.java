package com.example.zzz.exerciser;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.zzz.exerciser.adapter.AddExerciseAdapter;
import com.example.zzz.exerciser.db.domain.Exercise;

import java.util.ArrayList;

/**
 * Created by zzz on 4/30/16.
 */
public class AddTrainingActivity extends AppCompatActivity {
    ArrayList exercises = new <Exercise>ArrayList();
    private AddExerciseAdapter addExerciseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_training_layout);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.add_training_toolbar);
        setSupportActionBar(myToolbar);

        exercises.add(new Exercise("", ""));

        addExerciseAdapter = new AddExerciseAdapter(exercises);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.new_exercise_recyclerview);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(addExerciseAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_training_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exercises.add(new Exercise("", ""));
                addExerciseAdapter.notifyItemInserted(addExerciseAdapter.getItemCount()+1);
            }
        });

    }


}
