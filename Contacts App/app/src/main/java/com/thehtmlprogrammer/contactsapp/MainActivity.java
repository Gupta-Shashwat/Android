package com.thehtmlprogrammer.contactsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout contact1;
    Button btnNewContact;
    ImageView ivPhotoContact1, ivPhoneContact1, ivEmailContact1, ivLocContact1;
    TextView tvPhoneContact1, tvEmailContact1, tvLocContact1;
    int intentCode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNewContact = findViewById(R.id.btnNewContact);
        ivPhoneContact1.setImageResource(R.drawable.phone);
        ivEmailContact1.setImageResource(R.drawable.email);
        ivLocContact1.setImageResource(R.drawable.location);

        btnNewContact.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CreateNewContactActivity.class);
            startActivityForResult(intent, intentCode);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == intentCode) {
            if (resultCode == RESULT_OK) {
                int x = data.getIntExtra("photo", 0);
                switch (x) {
                    case 0:
                        ivPhotoContact1.setImageResource(R.drawable.satisfied);
                        break;
                    case 1:
                        ivPhotoContact1.setImageResource(R.drawable.good);
                        break;
                    case 2:
                        ivPhotoContact1.setImageResource(R.drawable.dissatisfied);
                        break;
                }
                tvPhoneContact1.setText(Integer.parseInt(data.getStringExtra("phone")));
                tvEmailContact1.setText(data.getStringExtra("email"));
                tvLocContact1.setText(data.getStringExtra("address"));
                contact1.setVisibility(View.VISIBLE);
            }
        }
    }
}