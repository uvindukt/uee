package com.uee.riyasewana;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.uee.riyasewana.Database.DBHelper;
import com.uee.riyasewana.adapter.OnVehicleListener;
import com.uee.riyasewana.adapter.VehicleRecyclerAdapter;
import com.uee.riyasewana.model.Vehicle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnVehicleListener {

    public static final String EXTRA_VEHICLE_POSITION = "com.uee.riyasewana.VEHICLE";
    public static ArrayList<Vehicle> VEHICLES;
    private VehicleRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView toolBarTitle = findViewById(R.id.toolbar_title);
        toolBarTitle.setText(toolbar.getTitle());

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayShowTitleEnabled(false);

        /*vehicles = new ArrayList<>();

        vehicles.add(new Vehicle(R.drawable.raptor, R.drawable.raptor_wide,"Ford Raptor F-150", "Rs. 180, 000, 000/=", "Galle - Sri Lanka", getString(R.string.sample), "uvindu.sanjana@gmail.com", "0771003087"));
        vehicles.add(new Vehicle(R.drawable.patrol, R.drawable.patrol_wide,"Nissan Patrol", "Rs. 9, 800, 000 /=", "Colombo - Sri Lanka", getString(R.string.sample), "john.c@gmail.com", "0716539248"));
        vehicles.add(new Vehicle(R.drawable.wrangler, R.drawable.wrangler_wide,"Jeep Wrangler Rubicon", "Rs. 22, 000, 000/=", "Kandy - Sri Lanka", getString(R.string.sample), "nimal.s@gmail.com", "0771231234"));
        vehicles.add(new Vehicle(R.drawable.mustang, R.drawable.mustang_wide,"Ford Mustang GT", "Rs. 20, 000, 000/=", "Matara - Sri Lanka", getString(R.string.sample), "jason.d@gmail.com", "0756893214"));
        vehicles.add(new Vehicle(R.drawable.land_cruiser, R.drawable.land_cruiser_wide,"Toyota Land Cruiser V8", "Rs. 50, 000, 000/=", "Colombo - Sri Lanka", getString(R.string.sample), "sunil.g@gmail.com", "0702359874"));
        vehicles.add(new Vehicle(R.drawable.nissan_gtr, R.drawable.nissan_gtr_wide,"Nissan GTR", "Rs. 28, 000, 000/=", "Galle - Sri Lanka", getString(R.string.sample), "loyd.s@gmail.com", "0762789214"));
        vehicles.add(new Vehicle(R.drawable.laferrari, R.drawable.laferrari_wide,"Ferrari LaFerrari", "Rs. 85, 500, 000/=", "Kandy - Sri Lanka", getString(R.string.sample), "paul.r@gmail.com", "0775869423"));
        vehicles.add(new Vehicle(R.drawable.huracan, R.drawable.huracan_wide,"Lamborghini Huracan", "Rs. 60, 430, 000/=", "Galle - Sri Lanka", getString(R.string.sample), "sri.h@gmail.com", "0725682469"));
        vehicles.add(new Vehicle(R.drawable.a6_avant, R.drawable.a6_avant_wide,"Audi A6 Avant", "Rs. 1, 200, 000/=", "Colombo - Sri Lanka", getString(R.string.sample), "kamal.g@gmail.com", "0775689324"));*/


        DBHelper db = new DBHelper(this);

        /*for (Vehicle vehicle : VEHICLES) {
            db.insert(vehicle);
        }*/

        VEHICLES = db.getAll();

        RecyclerView recyclerView = findViewById(R.id.listVehicles);
        adapter = new VehicleRecyclerAdapter(VEHICLES, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if(!recyclerView.canScrollVertically(-1)) {
                    toolbar.setElevation(0);
                } else {
                    toolbar.setElevation(50);
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        if (item.getItemId() == R.id.facebook)
            Toast.makeText(getApplication(), "Share", Toast.LENGTH_LONG).show();
        if (item.getItemId() == R.id.twitter)
            Toast.makeText(getApplication(), "Help & Feedback", Toast.LENGTH_LONG).show();
        if (item.getItemId() == R.id.search)
            startActivity(new Intent(this, SearchActivity.class));
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onVehicleClick(int position) {
        Intent intent = new Intent(this, VehicleActivity.class);
        intent.putExtra(MainActivity.EXTRA_VEHICLE_POSITION, position);
        startActivity(intent);
    }
}
