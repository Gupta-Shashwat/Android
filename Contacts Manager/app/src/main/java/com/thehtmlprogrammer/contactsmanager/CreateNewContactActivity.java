package com.thehtmlprogrammer.contactsmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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


        ivSatisfied.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("name", etName.getText().toString());
                intent.putExtra("phone", etPhone.getText().toString());
                intent.putExtra("email", etEmail.getText().toString());
                intent.putExtra("address", etAddress.getText().toString());
                intent.putExtra("photo", 0);
                setResult(RESULT_OK);
                CreateNewContactActivity.this.finish();
            }
        });

        ivGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("name", etName.getText().toString().trim());
                intent.putExtra("phone", etPhone.getText().toString().trim());
                intent.putExtra("email", etEmail.getText().toString().trim());
                intent.putExtra("address", etAddress.getText().toString().trim());
                intent.putExtra("photo", 1);
                setResult(RESULT_OK);
                CreateNewContactActivity.this.finish();
            }
        });

        ivDissatisfied.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("name", etName.getText().toString().trim());
                intent.putExtra("phone", etPhone.getText().toString().trim());
                intent.putExtra("email", etEmail.getText().toString().trim());
                intent.putExtra("address", etAddress.getText().toString().trim());
                intent.putExtra("photo", 2);
                setResult(RESULT_OK);
                CreateNewContactActivity.this.finish();
            }
        });
    }
}