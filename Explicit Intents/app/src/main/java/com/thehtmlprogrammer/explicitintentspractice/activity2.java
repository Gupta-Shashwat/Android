package com.thehtmlprogrammer.explicitintentspractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity2 extends AppCompatActivity {

    TextView act2welcome;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        back = findViewById(R.id.returnFromAct2);
        act2welcome = findViewById(R.id.act2welcome);
        String welcomeText = getText(R.string.activity2MainText).toString() + " " + getIntent().getStringExtra("name");
        act2welcome.setText(welcomeText);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity2.this.finish();
            }
        });
    }
}