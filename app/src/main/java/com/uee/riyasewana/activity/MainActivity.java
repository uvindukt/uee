package com.uee.riyasewana.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.uee.riyasewana.R;
import com.uee.riyasewana.adapter.OnVehicleListener;
import com.uee.riyasewana.adapter.VehicleRecyclerAdapter;
import com.uee.riyasewana.fragment.AccountFragment;
import com.uee.riyasewana.fragment.HomeFragment;
import com.uee.riyasewana.fragment.PartFragment;
import com.uee.riyasewana.fragment.TermsFragment;
import com.uee.riyasewana.fragment.VehicleFragment;
import com.uee.riyasewana.model.Vehicle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView toolBarTitle = findViewById(R.id.toolbar_title);
        toolBarTitle.setText(toolbar.getTitle());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;
        Class fragmentClass = null;

        if (id == R.id.menu_home)
            fragmentClass = HomeFragment.class;
        else if (id == R.id.menu_account)
            fragmentClass = AccountFragment.class;
        else if (id == R.id.menu_vehicle)
            fragmentClass = VehicleFragment.class;
        else if (id == R.id.menu_parts)
            fragmentClass = PartFragment.class;
        else if (id == R.id.menu_terms)
            fragmentClass = TermsFragment.class;

        try {
            if (fragmentClass != null)
                fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragment != null)
            fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(null).commit();

        item.setChecked(true);
        return true;
    }

    public void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }
}
