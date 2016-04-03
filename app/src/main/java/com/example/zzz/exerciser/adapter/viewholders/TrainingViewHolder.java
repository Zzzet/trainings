package com.example.zzz.exerciser.adapter.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.zzz.exerciser.R;

/**
 * Created by zzz on 2/29/16.
 */
public class TrainingViewHolder extends RecyclerView.ViewHolder {


    public TextView trainingNameView;
    public TextView trainingDateView;
    public TextView descriptionView;

    public TrainingViewHolder(View itemView) {
        super(itemView);
        trainingNameView = (TextView) itemView.findViewById(R.id.training_name);
        descriptionView = (TextView) itemView.findViewById(R.id.training_description);
        trainingDateView = (TextView) itemView.findViewById(R.id.training_lastdate);

    }
}

