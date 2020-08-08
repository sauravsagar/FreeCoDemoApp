package com.saurav.freecodemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    String[] collegeNameList;
    ArrayList<CollegeNames> arraylist = new ArrayList<CollegeNames>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        collegeNameList = new String[]{"NIT Jalandhar", "NIT Bhopal", "DTU",
                "IIT Delhi", "LPU", "Thapar University"};

        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < collegeNameList.length; i++) {
            CollegeNames collegeNames = new CollegeNames(collegeNameList[i]);
            // Binds all strings into an array
            arraylist.add(collegeNames);
        }

        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }
}
