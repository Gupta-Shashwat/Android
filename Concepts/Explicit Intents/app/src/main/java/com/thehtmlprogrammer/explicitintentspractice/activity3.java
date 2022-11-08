package com.thehtmlprogrammer.explicitintentspractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity3 extends AppCompatActivity {

    EditText act3input;
    Button act3button;
    Button act3cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        act3button = findViewById(R.id.act3button);
        act3input = findViewById(R.id.act3input);
        act3cancel = findViewById(R.id.act3cancel);

        act3button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String surname = act3input.getText().toString().trim();
                if (surname.isEmpty()){
                    Toast.makeText(activity3.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("surname", surname);
                    setResult(RESULT_OK, intent);
                    activity3.this.finish();
                }
            }
        });

        act3cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity3.this.finish();
            }
        });
    }
}