package com.thehtmlprogrammer.explicitintentspractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText enterText;
    Button btnGreetFirstName;
    Button btnGreetFullName;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterText = findViewById(R.id.enterText);
        btnGreetFirstName = findViewById(R.id.activity2);
        btnGreetFullName = findViewById(R.id.activity3);
        text = findViewById(R.id.output);

        btnGreetFirstName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = enterText.getText().toString().trim();
                if (firstName.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, activity2.class);
                    intent.putExtra("name", firstName);
                    startActivity(intent);
                }
            }
        });

        btnGreetFullName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int requestCode = 0;
                Intent intentAct3 = new Intent(MainActivity.this, activity3.class);
                startActivityForResult(intentAct3, requestCode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0){
            if (resultCode == RESULT_OK) {
                String firstName = enterText.getText().toString().trim();
                String lastName = data.getStringExtra("surname");
                String output = getText(R.string.act1output).toString() + " " + firstName + " " + lastName;
                text.setText(output);
            }
        }
    }
}