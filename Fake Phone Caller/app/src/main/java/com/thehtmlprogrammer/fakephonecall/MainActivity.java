package com.thehtmlprogrammer.fakephonecall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText pNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pNumber = findViewById(R.id.pNumber);

        if (getIntent().getData() != null) {
            pNumber.setText(getIntent().getData().toString().trim());
        }
    }
}