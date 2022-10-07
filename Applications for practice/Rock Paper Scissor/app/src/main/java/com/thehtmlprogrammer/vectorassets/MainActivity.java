package com.thehtmlprogrammer.vectorassets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnChange;
    ImageView mainImage, image1, image2, image3;
    int i;
    int next(int x) {
        if (x == 2){
            return 0;
        }
        return ++x;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i = 0;

        btnChange = findViewById(R.id.btnChange);
        mainImage = findViewById(R.id.mainImg);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);

        int[] images = {R.drawable.api, R.drawable.apps, R.drawable.android_logo};

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = next(i);
                mainImage.setImageResource(images[i]);
            }
        });

        mainImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = next(i);
                mainImage.setImageResource(images[i]);
            }
        });

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 0;
                mainImage.setImageResource(images[i]);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 1;
                mainImage.setImageResource(images[i]);
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 2;
                mainImage.setImageResource(images[i]);
            }
        });
    }
}