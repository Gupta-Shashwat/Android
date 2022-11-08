package com.thehtmlprogrammer.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements ListFrag.onItemClick{

    TextView tvDetails;
    String[] details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDetails = findViewById(R.id.tvDetails);
        details = getResources().getStringArray(R.array.descriptions);

//        // the phone is in portrait mode
//        if (findViewById(R.id.layout_portrait) != null) {
//            FragmentManager manager = this.getSupportFragmentManager();
//            manager.beginTransaction()
//                    .hide(manager.findFragmentById(R.id.detailsFrag))
//                    .show(manager.findFragmentById(R.id.listFrag))
//                    .commit();
//        }
//
//        // the phone is in landscape mode
//        if (findViewById(R.id.layout_land) != null) {
//            FragmentManager manager = this.getSupportFragmentManager();
//            manager.beginTransaction()
//                    .show(manager.findFragmentById(R.id.listFrag))
//                    .show(manager.findFragmentById(R.id.detailsFrag))
//                    .commit();
//        }
    }

    @Override
    public void onListClick(int idx) {
        tvDetails = findViewById(R.id.tvDetails);
        tvDetails.setText(details[idx]);
//
//        if (findViewById(R.id.layout_portrait) != null) {
//            FragmentManager manager = this.getSupportFragmentManager();
//            manager.beginTransaction()
//                    .hide(manager.findFragmentById(R.id.listFrag))
//                    .show(manager.findFragmentById(R.id.detailsFrag))
//                    .addToBackStack(null)
//                    .commit();
//        }
    }
}