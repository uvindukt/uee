package com.uee.riyasewana.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uee.riyasewana.R;

public class PartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    View itemView;
    ImageView imageView;
    TextView name;
    TextView price;
    TextView location;
    OnPartListener partListener;

    PartViewHolder(@NonNull View itemView, OnPartListener partListener) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.imageView_poster);
        this.name = itemView.findViewById(R.id.textView_name);
        this.price = itemView.findViewById(R.id.textView_price);
        this.location = itemView.findViewById(R.id.textView_location);
        this.partListener = partListener;
        this.itemView = itemView;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        partListener.onPartClick(getAdapterPosition());
    }
}
