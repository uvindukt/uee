package com.uee.riyasewana.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uee.riyasewana.R;
import com.uee.riyasewana.model.Vehicle;

import java.util.List;

public class VehicleRecyclerAdapter extends RecyclerView.Adapter<VehicleViewHolder> {

    private List<Vehicle> vehicles;
    private OnVehicleListener vehicleListener;
    private View v;

    public VehicleRecyclerAdapter(List<Vehicle> vehicles, OnVehicleListener vehicleListener) {
        this.vehicles = vehicles;
        this.vehicleListener = vehicleListener;
    }

    @NonNull
    @Override
    public VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list, parent, false);
        return new VehicleViewHolder(v, vehicleListener);
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleViewHolder holder, int position) {
        holder.itemView.setAnimation(AnimationUtils.loadAnimation(v.getContext(), R.anim.anim_scale_transition));
        holder.imageView.setImageResource(vehicles.get(position).getImageDrawable());
        holder.name.setText(vehicles.get(position).getName());
        holder.price.setText(vehicles.get(position).getPrice());
        holder.location.setText(vehicles.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return vehicles.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void insert(int position, Vehicle vehicle) {
        vehicles.add(position, vehicle);
        notifyItemInserted(position);
    }

    public void remove(Vehicle vehicle) {
        int position = vehicles.indexOf(vehicle);
        vehicles.remove(position);
        notifyItemRemoved(position);
    }
}
