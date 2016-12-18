package com.example.zzz.exerciser.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zzz.exerciser.R;
import com.example.zzz.exerciser.adapter.viewholders.AddRepetitionViewHolder;
import com.example.zzz.exerciser.db.domain.Repetition;

import java.util.ArrayList;

/**
 * Created by zzz on 5/1/16.
 */
public class AddRepetitionAdapter extends RecyclerView.Adapter<AddRepetitionViewHolder> {


    ArrayList<Repetition> repetitions;

    public AddRepetitionAdapter(ArrayList<Repetition> repetitions) {
        this.repetitions = repetitions;
    }

    @Override
    public AddRepetitionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.add_repetition_layout, parent, false);

        return new AddRepetitionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AddRepetitionViewHolder holder, int position) {
        Repetition repetition = repetitions.get(position);

        holder.addRepetitionWeightView.setText(repetition.weight);
        holder.addRepetitionCountView.setText(repetition.count);
    }

    @Override
    public int getItemCount() {
        return repetitions.size();
    }
}
