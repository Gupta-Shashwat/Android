package com.thehtmlprogrammer.newcontactsmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class NewContactActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etPhone, etWebsite, etLocation;
    ImageView ivSatisfied, ivNeutral, ivDissatisfied;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        ivSatisfied = findViewById(R.id.satisfied);
        ivNeutral = findViewById(R.id.neutral);
        ivDissatisfied = findViewById(R.id.dissatisfied);

        ivSatisfied.setOnClickListener(this);
        ivNeutral.setOnClickListener(this);
        ivDissatisfied.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etWebsite = findViewById(R.id.etWebsite);
        etLocation = findViewById(R.id.etLocation);

        if (etName.getText().toString().isEmpty() || etPhone.getText().toString().isEmpty() || etWebsite.getText().toString().isEmpty() || etLocation.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent();
            intent.putExtra("name", etName.getText().toString().trim());
            intent.putExtra("phone", etPhone.getText().toString().trim());
            intent.putExtra("website", etWebsite.getText().toString().trim());
            intent.putExtra("address", etLocation.getText().toString().trim());
            if (view.getId() == R.id.satisfied) {
                intent.putExtra("pfp", "satisfied");
            } else if (view.getId() == R.id.neutral) {
                intent.putExtra("pfp", "neutral");
            } else if (view.getId() == R.id.dissatisfied){
                intent.putExtra("pfp", "dissatisfied");
            }
            setResult(RESULT_OK, intent);
            NewContactActivity.this.finish();
        }
    }
}