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
import com.example.zzz.exerciser.db.MyDatabase;
import com.example.zzz.exerciser.db.domain.Training;
import com.example.zzz.exerciser.db.domain.tables.MyTables;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TrainingsActivity extends AppCompatActivity {
    Logger logger = LoggerFactory.getLogger(TrainingsActivity.class);
    TrainingAdapter trainingAdapter;
    List<Training> trainings;
    MyDatabase databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.training_list_layout);
        databaseHelper = new MyDatabase(getApplicationContext());
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


        getData();
        trainingAdapter = new TrainingAdapter(trainings);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.trainings_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(trainingAdapter);

    }

    @Subscribe
    public void onTrainingClicked(Training training){
        Intent intent = new Intent(getBaseContext(), ExercisesActivity.class);
        intent.putExtra("training_name", training.getName());
        intent.putExtra("training_id", training.getId());
        intent.putExtra("launched_training_id", training.getLaunchedTrainingId());
        startActivity(intent);
    }

    private void getData() {
        trainings = databaseHelper.getStartedTrainings();

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

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
}
