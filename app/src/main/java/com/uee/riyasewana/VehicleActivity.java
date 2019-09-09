package com.uee.riyasewana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.uee.riyasewana.model.Vehicle;

public class VehicleActivity extends AppCompatActivity {

    public static final int CALL_REQUEST = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);

        Intent intent = getIntent();
        final Vehicle vehicle = MainActivity.VEHICLES.get(intent.getIntExtra(MainActivity.EXTRA_VEHICLE_POSITION, 0));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView toolBarTitle = findViewById(R.id.toolbar_title);
        toolBarTitle.setText(toolbar.getTitle());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        ImageView imageView = findViewById(R.id.vehicle_img);
        TextView name = findViewById(R.id.vehicle_name);
        TextView price = findViewById(R.id.vehicle_price);
        TextView location = findViewById(R.id.vehicle_location);
        TextView description = findViewById(R.id.vehicle_description);
        TextView email = findViewById(R.id.email);
        TextView telephone = findViewById(R.id.telephone);

        imageView.setImageResource(vehicle.getImageWideDrawable());
        name.setText(vehicle.getName());
        price.setText(vehicle.getPrice());
        location.setText(vehicle.getLocation());
        description.setText(vehicle.getDescription());
        email.setText(vehicle.getEmail());
        telephone.setText(vehicle.getTelephone());

        Button callButton = findViewById(R.id.call_button);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(vehicle.getTelephone()));
                intent.setData(Uri.parse("tel:" + vehicle.getTelephone()));

                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(VehicleActivity.this, new String[]{Manifest.permission.CALL_PHONE}, CALL_REQUEST);
                    return;
                }

                startActivity(intent);
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
}
