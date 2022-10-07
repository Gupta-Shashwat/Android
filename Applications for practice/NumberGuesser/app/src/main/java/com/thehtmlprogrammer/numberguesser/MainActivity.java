package com.thehtmlprogrammer.numberguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    EditText guess;
    Button submitButton;
    ImageView settings;
    TextView remainingGuesses, result;
    int guessNumber, rGuesses;
    int rangeStart = 1, rangeEnd = 100, maxGuesses = 10;
    String res, strGuesses, hints = "ON";

    public void restart() {

        rGuesses = maxGuesses;
        guessNumber = (int) ((Math.random() * (rangeEnd - rangeStart + 1)) + rangeStart);

        strGuesses = "Remaining Guesses: " + rGuesses;
        remainingGuesses.setText(strGuesses);

        result.setText("");
        result.setVisibility(View.GONE);
        submitButton.setText(R.string.guess_button_text);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guess = findViewById(R.id.guess);
        submitButton = findViewById(R.id.submitButton);
        settings = findViewById(R.id.settings);
        remainingGuesses = findViewById(R.id.remainingGuesses);
        result = findViewById(R.id.result);

        Intent intent = getIntent();
        rangeStart = intent.getIntExtra("rangeStart", 1);
        rangeEnd = intent.getIntExtra("rangeEnd", 100);
        maxGuesses = intent.getIntExtra("maxGuesses", 10);
        hints = intent.getStringExtra("hints");
        if (!(hints.equals("ON") || hints.equals("OFF"))) {
            hints = "ON";
        }

        restart();

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.thehtmlprogrammer.numberguesser.settings.class);
                intent.putExtra("rangeStart", rangeStart);
                intent.putExtra("rangeEnd", rangeEnd);
                intent.putExtra("maxGuesses", maxGuesses);
                intent.putExtra("hints", hints);
                startActivity(intent);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rGuesses != 0 && submitButton.getText().toString().trim().equals("Guess")) {
                    if (guess.getText().toString().trim().isEmpty()) {
                        Toast.makeText(MainActivity.this, "Please enter a number in guess field", Toast.LENGTH_SHORT).show();
                    } else if (Integer.parseInt(guess.getText().toString().trim()) == guessNumber) {
                        strGuesses = "Remaining Guesses: " + (--rGuesses);
                        remainingGuesses.setText(strGuesses);
                        res = "You won!!! The correct guess was " + guessNumber;
                        result.setText(res);
                        result.setVisibility(View.VISIBLE);
                        Toast.makeText(MainActivity.this, "You Won!!!", Toast.LENGTH_SHORT).show();
                        guess.setText("");
                        submitButton.setText(R.string.restart);
                    } else {
                        strGuesses = "Remaining Guesses: " + (--rGuesses);
                        remainingGuesses.setText(strGuesses);
                        if (rGuesses == 0){
                            res = "You lost!!! The correct guess was " + guessNumber;
                            Toast.makeText(MainActivity.this, "You Lost!!!", Toast.LENGTH_SHORT).show();
                            result.setText(res);
                            result.setVisibility(View.VISIBLE);
                            submitButton.setText(R.string.restart);
                        } else if (Integer.parseInt(guess.getText().toString().trim()) > guessNumber && hints.equals("ON")) {
                            Toast.makeText(MainActivity.this, "Try a little smaller number", Toast.LENGTH_SHORT).show();
                        } else if (hints.equals("ON")){
                            Toast.makeText(MainActivity.this, "Try a little larger number", Toast.LENGTH_SHORT).show();
                        }
                        guess.setText("");
                    }
                } else {
                    restart();
                }
            }
        });
    }
}