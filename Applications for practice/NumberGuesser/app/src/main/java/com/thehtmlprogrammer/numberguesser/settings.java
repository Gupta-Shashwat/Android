package com.thehtmlprogrammer.numberguesser;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class settings extends AppCompatActivity {

    EditText rangeStart, rangeEnd, maxGuesses, hintsAllowed;
    Button startGame;
    int start = 0, end = 100, guesses = 10;
    String hints = "ON";

    public void startNewGame() {
        Intent intent = new Intent(this, com.thehtmlprogrammer.numberguesser.MainActivity.class);
        start = Integer.parseInt(rangeStart.getText().toString().trim());
        end = Integer.parseInt(rangeEnd.getText().toString().trim());
        guesses = Integer.parseInt(maxGuesses.getText().toString().trim());
        hints = hintsAllowed.getText().toString().toUpperCase().trim();
        if (!(hints.equals("ON") || hints.equals("OFF"))){
            Toast.makeText(this, "Invalid hints option", Toast.LENGTH_SHORT).show();
            return;
        }
        intent.putExtra("rangeStart", start);
        intent.putExtra("rangeEnd", end);
        intent.putExtra("maxGuesses", guesses);
        intent.putExtra("hints", hints);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        rangeEnd = findViewById(R.id.rangeEnd);
        rangeStart = findViewById(R.id.rangeStart);
        maxGuesses = findViewById(R.id.maxGuesses);
        hintsAllowed = findViewById(R.id.hint);
        startGame = findViewById(R.id.startGame);

        Intent data = getIntent();
        start = data.getIntExtra("rangeStart", 1);
        end = data.getIntExtra("rangeEnd", 100);
        guesses = data.getIntExtra("maxGuesses", 10);
        hints = data.getStringExtra("hints");
        if (hints == null) {
            hints = "ON";
        }

        rangeStart.setText(String.valueOf(start));
        rangeEnd.setText(String.valueOf(end));
        maxGuesses.setText(String.valueOf(guesses));
        hintsAllowed.setText(hints);

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rangeStart.getText().toString().trim().isEmpty() || rangeEnd.getText().toString().trim().isEmpty() || maxGuesses.getText().toString().trim().isEmpty() || hintsAllowed.getText().toString().trim().isEmpty()) {
                    Toast.makeText(settings.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    startNewGame();
                }
            }
        });
    }

}