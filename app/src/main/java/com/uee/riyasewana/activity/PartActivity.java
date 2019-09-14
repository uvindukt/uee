package com.uee.riyasewana.activity;

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

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import com.uee.riyasewana.R;
import com.uee.riyasewana.fragment.PartFragment;
import com.uee.riyasewana.model.Part;

public class PartActivity extends AppCompatActivity {
    public static final int CALL_REQUEST = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part);

        Intent intent = getIntent();
        final Part part = PartFragment.parts.get(intent.getIntExtra(PartFragment.EXTRA_PART_POSITION, 0));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView toolBarTitle = findViewById(R.id.toolbar_title);
        toolBarTitle.setText(toolbar.getTitle());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        ImageView imageView = findViewById(R.id.part_img);
        TextView name = findViewById(R.id.part_name);
        TextView price = findViewById(R.id.part_price);
        TextView location = findViewById(R.id.part_location);
        TextView description = findViewById(R.id.part_description);
        TextView email = findViewById(R.id.part_email);
        TextView telephone = findViewById(R.id.part_telephone);

        imageView.setImageResource(part.getImageWideDrawable());
        name.setText(part.getName());
        price.setText(part.getPrice());
        location.setText(part.getLocation());
        description.setText(part.getDescription());
        email.setText(part.getEmail());
        telephone.setText(part.getTelephone());

        Button callButton = findViewById(R.id.part_call_button);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(part.getTelephone()));
                intent.setData(Uri.parse("tel:" + part.getTelephone()));

                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(PartActivity.this, new String[]{Manifest.permission.CALL_PHONE}, CALL_REQUEST);
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
            startActivity(new Intent(this, SearchPartActivity.class));
        return super.onOptionsItemSelected(item);
    }
}
