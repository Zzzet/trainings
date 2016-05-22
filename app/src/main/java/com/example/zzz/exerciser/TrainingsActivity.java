package com.example.zzz.exerciser;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.zzz.exerciser.adapter.TrainingAdapter;
import com.example.zzz.exerciser.domain.Training;

import java.util.ArrayList;

public class TrainingsActivity extends AppCompatActivity {
    TrainingAdapter trainingAdapter;
    ArrayList<Training> trainings = new ArrayList<>();

    //скорее всего есть способ лучше перехватывать нажатия на один из элементов адаптера
    public void onTrainingClicked(TextView trainingNameView) {
        Intent intent = new Intent(getBaseContext(), ExercisesActivity.class);
        intent.putExtra("trainingName", trainingNameView.getText());
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.training_list_layout);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.trainings_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(getBaseContext(), AddTrainingActivity.class);
                startActivity(intent);
            }
        });


        Toolbar myToolbar = (Toolbar) findViewById(R.id.trainings_toolbar);
        setSupportActionBar(myToolbar);


        fillData();
        trainingAdapter = new TrainingAdapter(trainings, this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.trainings_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(trainingAdapter);

    }

    private void fillData() {
        for (int i = 0; i < 30; i++) {
            trainings.add(new Training("Training name " + i, "description " + i, "last finished " + i));
            System.out.println("added " + i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
