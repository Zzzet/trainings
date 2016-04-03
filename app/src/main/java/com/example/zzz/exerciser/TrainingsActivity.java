package com.example.zzz.exerciser;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.zzz.exerciser.adapter.TrainingAdapter;
import com.example.zzz.exerciser.domain.Training;

import java.util.ArrayList;

public class TrainingsActivity extends AppCompatActivity {
    TrainingAdapter trainingAdapter;
    ArrayList<Training> trainings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trainings_layout);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.trainings_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        fillData();
        trainingAdapter = new TrainingAdapter(trainings);
//        ListView lvMain = (ListView) findViewById(R.id.main_listview);
//        lvMain.setAdapter(trainingAdapter);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.trainings_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
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
