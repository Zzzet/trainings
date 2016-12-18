package com.example.zzz.exerciser.adapter.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zzz.exerciser.R;
import com.example.zzz.exerciser.db.domain.Training;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by zzz on 2/29/16.
 */
public class TrainingViewHolder extends RecyclerView.ViewHolder {

    private TextView trainingNameView;
    private TextView trainingDateView;
    private TextView descriptionView;
    private TextView statusView;
    private RelativeLayout relativeLayout;
    private Training training;

    public TrainingViewHolder(final View itemView) {
        super(itemView);
        trainingNameView = (TextView) itemView.findViewById(R.id.training_name);
        descriptionView = (TextView) itemView.findViewById(R.id.training_description);
        trainingDateView = (TextView) itemView.findViewById(R.id.training_lastdate);
        statusView = (TextView) itemView.findViewById(R.id.training_status);
        relativeLayout = (RelativeLayout) itemView.findViewById(R.id.training_layout);
    }

    public void createOnClickListener() {
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(training);
            }
        });
    }

    public void setTraining(Training training) {
        this.training = training;

        trainingNameView.setText(training.name);
        descriptionView.setText(training.description);
        trainingDateView.setText(training.lastFinished);
        statusView.setText(String.valueOf(training.status));
    }
}

