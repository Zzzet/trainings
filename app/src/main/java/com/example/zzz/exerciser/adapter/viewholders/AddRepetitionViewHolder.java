package com.example.zzz.exerciser.adapter.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.example.zzz.exerciser.R;

public class AddRepetitionViewHolder extends RecyclerView.ViewHolder {


    public EditText addRepetitionWeightView;
    public EditText addRepetitionCountView;

    public AddRepetitionViewHolder(View itemView) {
        super(itemView);
        addRepetitionWeightView = (EditText) itemView.findViewById(R.id.add_repetition_weight);
        addRepetitionCountView = (EditText) itemView.findViewById(R.id.add_repetition_count);
    }
}

