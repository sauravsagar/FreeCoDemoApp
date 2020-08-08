package com.saurav.freecodemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoCompleteSearchActivity extends AppCompatActivity {

    private static final String[] COLLEGE = new String[]{
            "CMRIT", "MIT", "RV", "BMSIT", "NMIT"
    };

    VideoItemBin videoItemBin = new VideoItemBin();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);

        String[] countries = getResources().getStringArray(R.array.countries);
        final AutoCompleteTextView editText = findViewById(R.id.actv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.custom_list_item, R.id.text_view_list_item, countries);
        editText.setAdapter(adapter);

        editText.setThreshold(1);

    }
}
