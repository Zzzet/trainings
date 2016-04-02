package com.example.zzz.exerciser.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.zzz.exerciser.R;

public class RepetitionViewHolder extends RecyclerView.ViewHolder {


    protected TextView repetitionWeightView;
    protected TextView repetitiomCountView;
    protected CheckBox repetitionCheckbox;

    public RepetitionViewHolder(View itemView) {
        super(itemView);
        repetitionWeightView = (TextView) itemView.findViewById(R.id.repetition_weight);
        repetitiomCountView = (TextView) itemView.findViewById(R.id.repetition_count);
        repetitionCheckbox = (CheckBox) itemView.findViewById(R.id.repetition_checkbox);
    }
}

