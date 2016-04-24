package com.example.zzz.exerciser.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zzz.exerciser.R;
import com.example.zzz.exerciser.TrainingsActivity;
import com.example.zzz.exerciser.adapter.viewholders.TrainingViewHolder;
import com.example.zzz.exerciser.domain.Training;

import java.util.ArrayList;

public class TrainingAdapter extends RecyclerView.Adapter<TrainingViewHolder> {


    ArrayList<Training> trainings;
    TrainingsActivity trainingsActivity;

    public TrainingAdapter(ArrayList<Training> trainings, TrainingsActivity trainingsActivity) {
        this.trainings = trainings;
        this.trainingsActivity = trainingsActivity;

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

        holder.trainingNameView.setText(training.trainingName);
        holder.descriptionView.setText(training.description);
        holder.trainingDateView.setText(training.lastDate);

        holder.setActivity(trainingsActivity);
        holder.createOnClickListener();
    }

    @Override
    public int getItemCount() {
        return trainings.size();
    }

//from old, not RecyclerView adapter class
//    @Override
//    public int getCount() {
//        return trainings.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return trainings.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        LayoutInflater inflater = (LayoutInflater) context
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View rowView = inflater.inflate(R.layout.training_layout, parent, false);
//        TextView trainingNameView = (TextView) rowView.findViewById(R.id.training_name);
//        TextView descriptionView = (TextView) rowView.findViewById(R.id.training_description);
//        TextView trainingDateView = (TextView) rowView.findViewById(R.id.training_lastdate);
//
//        Training training_layout = trainings.get(position);
//
//
//        trainingNameView.setText(training_layout.trainingName);
//        descriptionView.setText(training_layout.description);
//        trainingDateView.setText(training_layout.lastDate);
//
//        return rowView;
//    }
}
