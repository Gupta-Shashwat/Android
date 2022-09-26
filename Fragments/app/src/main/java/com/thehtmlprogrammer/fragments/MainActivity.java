package com.thehtmlprogrammer.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemClick{

    TextView tvDetails;
    ArrayList<String> details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDetails = findViewById(R.id.tvDetails);

        details = new ArrayList<>();
        details.add("Detail 1");
        details.add("Detail 2");
        details.add("Detail 3");
        details.add("Detail 4");
        details.add("Detail 5");
    }

    @Override
    public void onListClick(int idx) {
        tvDetails = findViewById(R.id.tvDetails);
        tvDetails.setText(details.get(idx));
    }
}