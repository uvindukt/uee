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
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.uee.riyasewana.activity.MainActivity;
import com.uee.riyasewana.activity.PartActivity;
import com.uee.riyasewana.R;
import com.uee.riyasewana.activity.SearchVehicleActivity;
import com.uee.riyasewana.adapter.OnPartListener;
import com.uee.riyasewana.adapter.PartRecyclerAdapter;
import com.uee.riyasewana.model.Part;

import java.util.ArrayList;
import java.util.Objects;

public class PartFragment extends Fragment implements OnPartListener {
    public static final String EXTRA_PART_POSITION = "com.uee.riyasewana.PART";
    public static ArrayList<Part> parts;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_part, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.list_vehicle_parts);
        PartRecyclerAdapter adapter = new PartRecyclerAdapter(parts, this);
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
        parts = new ArrayList<>();
        parts.add(new Part(R.drawable.bmw_v8_engine, R.drawable.bmw_v8_engine_wide, "BMW V8 Engine", "Rs. 900, 000/=", "Galle - Sri Lanka", getString(R.string.sample), "damion.pearson@gmail.com", "0778846090"));
        parts.add(new Part(R.drawable.cyclone_engine_block, R.drawable.cyclone_engine_block_wide, "Cyclone Engine Block", "Rs. 100, 000/=", "Colombo - Sri Lanka", getString(R.string.sample), "john.c@gmail.com", "0716539248"));
        parts.add(new Part(R.drawable.dt_530_navistar_300, R.drawable.dt_530_navistar_300_wide, "DT 530 Navistar 300", "Rs. 1, 000, 000/=", "Kandy - Sri Lanka", getString(R.string.sample), "nimal.s@gmail.com", "0771231234"));
        parts.add(new Part(R.drawable.ducati_testastretta, R.drawable.ducati_testastretta_wide,"Ducati Testastretta", "Rs. 500, 000/=", "Matara - Sri Lanka", getString(R.string.sample), "jason.d@gmail.com", "0756893214"));
        parts.add(new Part(R.drawable.ford_coyote_v8_engine, R.drawable.ford_coyote_v8_engine_wide,"Ford Coyote V8 Engine", "Rs. 15, 000, 000/=", "Colombo - Sri Lanka", getString(R.string.sample), "sunil.g@gmail.com", "0702359874"));
        parts.add(new Part(R.drawable.ford_eco_engine, R.drawable.ford_eco_engine_wide,"Ford Eco Engine", "Rs. 13, 000, 000/=", "Galle - Sri Lanka", getString(R.string.sample), "loyd.s@gmail.com", "0762789214"));
        parts.add(new Part(R.drawable.ford_f_150_engine, R.drawable.ford_f_150_engine_wide,"Ford F 150 Engine Wide", "Rs. 18, 500, 000/=", "Kandy - Sri Lanka", getString(R.string.sample), "paul.r@gmail.com", "0775869423"));
        parts.add(new Part(R.drawable.ford_f_v6_engine, R.drawable.ford_f_v6_engine_wide,"Ford F V6 Engine", "Rs. 14, 430, 000/=", "Galle - Sri Lanka", getString(R.string.sample), "sri.h@gmail.com", "0725682469"));
        parts.add(new Part(R.drawable.mustang_engine_block, R.drawable.mustang_engine_block_wide,"Mustang Engine Block", "Rs. 10, 200, 000/=", "Colombo - Sri Lanka", getString(R.string.sample), "kamal.g@gmail.com", "0775689324"));
    }

    @Override
    public void onPartClick(int position) {
        Intent intent = new Intent(getContext(), PartActivity.class);
        intent.putExtra(PartFragment.EXTRA_PART_POSITION, position);
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
