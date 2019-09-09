package com.uee.riyasewana.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uee.riyasewana.R;

public class VehicleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView imageView;
    public TextView name;
    public TextView price;
    public TextView location;
    public OnVehicleListener vehicleListener;

    public VehicleViewHolder(@NonNull View itemView, OnVehicleListener vehicleListener) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.imageView_poster);
        this.name = itemView.findViewById(R.id.textView_name);
        this.price = itemView.findViewById(R.id.textView_price);
        this.location = itemView.findViewById(R.id.textView_location);
        this.vehicleListener = vehicleListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        vehicleListener.onVehicleClick(getAdapterPosition());
    }
}
