package com.thehtmlprogrammer.contactsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class CreateNewContactActivity extends AppCompatActivity {

    EditText etName, etPhone, etEmail, etAddress;
    ImageView ivSatisfied, ivGood, ivDissatisfied;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_contact);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etAddress= findViewById(R.id.etAddress);
        ivSatisfied = findViewById(R.id.ivSatisfied);
        ivGood = findViewById(R.id.ivGood);
        ivDissatisfied = findViewById(R.id.ivDissatisfied);

        Intent intent = new Intent();
        intent.putExtra("name", etName.getText().toString().trim());
        intent.putExtra("phone", etPhone.getText().toString().trim());
        intent.putExtra("email", etEmail.getText().toString().trim());
        intent.putExtra("address", etAddress.getText().toString().trim());

        ivSatisfied.setOnClickListener(view -> {
            intent.putExtra("photo", 0);
            CreateNewContactActivity.this.finish();
        });

        ivGood.setOnClickListener(view -> {
            intent.putExtra("photo", 1);
            CreateNewContactActivity.this.finish();
        });

        ivDissatisfied.setOnClickListener(view -> {
            intent.putExtra("photo", 2);
            CreateNewContactActivity.this.finish();
        });
    }
}