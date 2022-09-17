package com.thehtmlprogrammer.contactsmanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout contact1;
    Button btnNewContact;
    ImageView ivPhotoContact1, ivPhoneContact1, ivEmailContact1, ivLocContact1;
    TextView tvPhoneContact1, tvEmailContact1, tvLocContact1;
    int intentCode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("in onCreate", "main activity created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contact1 = findViewById(R.id.contact1);
        contact1.setVisibility(View.GONE);
        btnNewContact = findViewById(R.id.btnNewContact);

        btnNewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.thehtmlprogrammer.contactsmanager.CreateNewContactActivity.class);
                startActivityForResult(intent, intentCode);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("in onStart", "Started Activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("in onResume", "Resuming Activity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("in onDestroy", "Activity Destroyed");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("in onStop", "Activity Stopped");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("in onRestart", "Activity Restarted");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (data != null) {
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
            }
            ivPhoneContact1.setImageResource(R.drawable.phone);
            ivEmailContact1.setImageResource(R.drawable.email);
            ivLocContact1.setImageResource(R.drawable.location);
            contact1.setVisibility(View.VISIBLE);
        }
    }
}