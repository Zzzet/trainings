package com.example.zzz.exerciser.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zzz.exerciser.R;
import com.example.zzz.exerciser.adapter.viewholders.TrainingViewHolder;
import com.example.zzz.exerciser.db.domain.Training;

import java.util.List;

public class TrainingAdapter extends RecyclerView.Adapter<TrainingViewHolder> {


    private List<Training> trainings;


    public TrainingAdapter(List<Training> trainings) {
        this.trainings = trainings;


    }

    @Override
    public TrainingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.training_layout, parent, false);

        return new TrainingViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TrainingViewHolder holder, int position) {
        Training training = trainings.get(position);
        holder.setTraining(training);
        holder.createOnClickListener();
    }

    @Override
    public int getItemCount() {
        return trainings.size();
    }

}
