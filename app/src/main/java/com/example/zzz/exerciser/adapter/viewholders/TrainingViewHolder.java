package com.example.zzz.exerciser.adapter.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zzz.exerciser.R;
import com.example.zzz.exerciser.TrainingsActivity;

/**
 * Created by zzz on 2/29/16.
 */
public class TrainingViewHolder extends RecyclerView.ViewHolder {

    public TextView trainingNameView;
    public TextView trainingDateView;
    public TextView descriptionView;
    TrainingsActivity parentActivity;
    RelativeLayout relativeLayout;

    public TrainingViewHolder(final View itemView) {
        super(itemView);
        trainingNameView = (TextView) itemView.findViewById(R.id.training_name);
        descriptionView = (TextView) itemView.findViewById(R.id.training_description);
        trainingDateView = (TextView) itemView.findViewById(R.id.training_lastdate);

        relativeLayout = (RelativeLayout) itemView.findViewById(R.id.training_layout);
    }

    public void setActivity(TrainingsActivity activity) {
        parentActivity = activity;
    }

    public void createOnClickListener() {
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(itemView.getContext(), "traij9jg co9c", Toast.LENGTH_SHORT).show();
                parentActivity.onTrainingClicked(trainingNameView);

            }
        });
    }
}

