package com.example.zzz.exerciser.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zzz.exerciser.R;
import com.example.zzz.exerciser.adapter.TrainingAdapter;
import com.example.zzz.exerciser.db.MyDatabase;
import com.example.zzz.exerciser.db.domain.Training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TrainingsFragment extends Fragment {
    Logger logger = LoggerFactory.getLogger(TrainingsFragment.class);
    TrainingAdapter trainingAdapter;
    List<Training> trainings;
    MyDatabase databaseHelper;



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        databaseHelper = new MyDatabase(getActivity().getApplicationContext());

        getData();
        trainingAdapter = new TrainingAdapter(trainings);
        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.trainings_fr_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(trainingAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.trainings_fragment_layout, container, false);
    }

    private void getData() {
        trainings = databaseHelper.getStartedTrainings();
    }
}
