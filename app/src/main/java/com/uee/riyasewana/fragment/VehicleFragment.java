package com.uee.riyasewana.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.uee.riyasewana.R;
import com.uee.riyasewana.activity.MainActivity;
import com.uee.riyasewana.activity.SearchVehicleActivity;
import com.uee.riyasewana.activity.VehicleActivity;
import com.uee.riyasewana.adapter.OnVehicleListener;
import com.uee.riyasewana.adapter.VehicleRecyclerAdapter;
import com.uee.riyasewana.model.Vehicle;

import java.util.ArrayList;
import java.util.Objects;

public class VehicleFragment extends Fragment implements OnVehicleListener {
    public static final String EXTRA_VEHICLE_POSITION = "com.uee.riyasewana.VEHICLE";
    public static ArrayList<Vehicle> VEHICLES;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vehicle, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.listVehicles);
        VehicleRecyclerAdapter adapter = new VehicleRecyclerAdapter(VEHICLES, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if(!recyclerView.canScrollVertically(-1)) {
                    Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).getSupportActionBar()).setElevation(0);
                } else {
                    Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).getSupportActionBar()).setElevation(50);
                }
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        VEHICLES = new ArrayList<>();
        VEHICLES.add(new Vehicle(R.drawable.raptor, R.drawable.raptor_wide,"Ford Raptor F-150", "Rs. 180, 000, 000/=", "Galle - Sri Lanka", getString(R.string.sample), "uvindu.sanjana@gmail.com", "0771003087"));
        VEHICLES.add(new Vehicle(R.drawable.patrol, R.drawable.patrol_wide,"Nissan Patrol", "Rs. 9, 800, 000 /=", "Colombo - Sri Lanka", getString(R.string.sample), "john.c@gmail.com", "0716539248"));
        VEHICLES.add(new Vehicle(R.drawable.wrangler, R.drawable.wrangler_wide,"Jeep Wrangler Rubicon", "Rs. 22, 000, 000/=", "Kandy - Sri Lanka", getString(R.string.sample), "nimal.s@gmail.com", "0771231234"));
        VEHICLES.add(new Vehicle(R.drawable.mustang, R.drawable.mustang_wide,"Ford Mustang GT", "Rs. 20, 000, 000/=", "Matara - Sri Lanka", getString(R.string.sample), "jason.d@gmail.com", "0756893214"));
        VEHICLES.add(new Vehicle(R.drawable.land_cruiser, R.drawable.land_cruiser_wide,"Toyota Land Cruiser V8", "Rs. 50, 000, 000/=", "Colombo - Sri Lanka", getString(R.string.sample), "sunil.g@gmail.com", "0702359874"));
        VEHICLES.add(new Vehicle(R.drawable.nissan_gtr, R.drawable.nissan_gtr_wide,"Nissan GTR", "Rs. 28, 000, 000/=", "Galle - Sri Lanka", getString(R.string.sample), "loyd.s@gmail.com", "0762789214"));
        VEHICLES.add(new Vehicle(R.drawable.laferrari, R.drawable.laferrari_wide,"Ferrari LaFerrari", "Rs. 85, 500, 000/=", "Kandy - Sri Lanka", getString(R.string.sample), "paul.r@gmail.com", "0775869423"));
        VEHICLES.add(new Vehicle(R.drawable.huracan, R.drawable.huracan_wide,"Lamborghini Huracan", "Rs. 60, 430, 000/=", "Galle - Sri Lanka", getString(R.string.sample), "sri.h@gmail.com", "0725682469"));
        VEHICLES.add(new Vehicle(R.drawable.a6_avant, R.drawable.a6_avant_wide,"Audi A6 Avant", "Rs. 1, 200, 000/=", "Colombo - Sri Lanka", getString(R.string.sample), "kamal.g@gmail.com", "0775689324"));
    }

    @Override
    public void onVehicleClick(int position) {
        Intent intent = new Intent(getContext(), VehicleActivity.class);
        intent.putExtra(VehicleFragment.EXTRA_VEHICLE_POSITION, position);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            //
        if (item.getItemId() == R.id.facebook)
            Toast.makeText(getContext(), "Share", Toast.LENGTH_LONG).show();
        if (item.getItemId() == R.id.twitter)
            Toast.makeText(getContext(), "Help & Feedback", Toast.LENGTH_LONG).show();
        if (item.getItemId() == R.id.search)
            startActivity(new Intent(getContext(), SearchVehicleActivity.class));
        return super.onOptionsItemSelected(item);
    }
}
