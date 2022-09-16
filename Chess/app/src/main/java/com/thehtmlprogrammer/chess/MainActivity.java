package com.thehtmlprogrammer.chess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button newGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newGame = findViewById(R.id.newGame);

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNewGame = new Intent(MainActivity.this, com.thehtmlprogrammer.chess.CreateGame.class);
                intentNewGame.putExtra("testVar", 6);
                startActivity(intentNewGame);
            }
        });
    }
}