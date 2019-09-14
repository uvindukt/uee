package com.uee.riyasewana.activity;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.jaygoo.widget.RangeSeekBar;
import com.uee.riyasewana.R;

public class SearchPartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_part);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView toolBarTitle = findViewById(R.id.toolbar_title);
        toolBarTitle.setText(toolbar.getTitle());

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayShowTitleEnabled(false);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        RangeSeekBar rangeSeekBar = findViewById(R.id.rangeSeekBar);
        rangeSeekBar.setIndicatorTextDecimalFormat("0.0");

        String[] category = new String[]{"Engine", "Brakes", "Battery", "Chassis", "Mirrors"};
        String[] locations = new String[]{"Galle", "Matara", "Colombo", "Malabe", "Gampaha"};
        String[] type = new String[]{"Used", "Brand New"};

        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, R.layout.dropdown_menu_popup_item, category);
        ArrayAdapter<String> locationAdapter = new ArrayAdapter<>(this, R.layout.dropdown_menu_popup_item, locations);
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<>(this, R.layout.dropdown_menu_popup_item, type);

        AutoCompleteTextView selectCategory = findViewById(R.id.select_category_dropdown);
        selectCategory.setAdapter(categoryAdapter);

        AutoCompleteTextView selectLocation = findViewById(R.id.select_location_dropdown);
        selectLocation.setAdapter(locationAdapter);

        AutoCompleteTextView selectType = findViewById(R.id.select_type_dropdown);
        selectType.setAdapter(typeAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null)
                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }
}
