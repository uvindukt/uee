package com.uee.riyasewana.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uee.riyasewana.R;
import com.uee.riyasewana.model.Part;

import java.util.List;

public class PartRecyclerAdapter extends RecyclerView.Adapter<PartViewHolder> {
    private List<Part> parts;
    private OnPartListener partListener;
    private View v;

    public PartRecyclerAdapter(List<Part> parts, OnPartListener partListener) {
        this.parts = parts;
        this.partListener = partListener;
    }

    @NonNull
    @Override
    public PartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list, parent, false);
        return new PartViewHolder(v, partListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PartViewHolder holder, int position) {
        holder.itemView.setAnimation(AnimationUtils.loadAnimation(v.getContext(), R.anim.anim_scale_transition));
        holder.imageView.setImageResource(parts.get(position).getImageDrawable());
        holder.name.setText(parts.get(position).getName());
        holder.price.setText(parts.get(position).getPrice());
        holder.location.setText(parts.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return parts.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
