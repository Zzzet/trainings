package com.example.zzz.exerciser.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zzz.exerciser.R;
import com.example.zzz.exerciser.adapter.viewholders.RepetitionViewHolder;
import com.example.zzz.exerciser.db.domain.Repetition;

import java.util.List;

/**
 * Created by zzz on 4/2/16.
 */
public class RepetitionAdapter extends RecyclerView.Adapter<RepetitionViewHolder> {

    List<Repetition> repetitions;

    public RepetitionAdapter(List<Repetition> repetitions) {
        this.repetitions = repetitions;

    }

    @Override
    public RepetitionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.repetitions_layout, parent, false);

        return new RepetitionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RepetitionViewHolder holder, int position) {
        Repetition repetition = repetitions.get(position);

        holder.repetitionWeightView.setText(repetition.weight);
        holder.repetitiomCountView.setText(repetition.count);
        holder.repetitionCheckbox.setActivated(repetition.getStatus());

    }

    @Override
    public int getItemCount() {
        return repetitions.size();
    }


}
