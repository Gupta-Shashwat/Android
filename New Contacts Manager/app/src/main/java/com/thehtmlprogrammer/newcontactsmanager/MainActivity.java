package com.thehtmlprogrammer.newcontactsmanager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnNewContact;
    ImageView ivContact1;
    TextView tvNameContact1, tvPhoneContact1, tvWebsiteContact1, tvLocationContact1;
    LinearLayout llhContact1, llhPhoneContact1, llhWebsiteContact1, llhLocationContact1;
    int requestCode = 0;
    String name = "", phone = "", website = "", location = "", pfp = "";

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy", "Destroying activity");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llhContact1 = findViewById(R.id.llhContact1);
        llhContact1.setVisibility(View.GONE);

        llhPhoneContact1 = findViewById(R.id.llhPhoneContact1);
        llhWebsiteContact1 = findViewById(R.id.llhWebsiteContact1);
        llhLocationContact1 = findViewById(R.id.llhLocationContact1);

        btnNewContact = findViewById(R.id.btnCreateContact);

        ivContact1 = findViewById(R.id.ivContact1);

        tvNameContact1 = findViewById(R.id.tvNameContact1);
        tvPhoneContact1 = findViewById(R.id.tvPhoneContact1);
        tvWebsiteContact1 = findViewById(R.id.tvWebsiteContact1);
        tvLocationContact1 = findViewById(R.id.tvLocationContact1);

        btnNewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.thehtmlprogrammer.newcontactsmanager.NewContactActivity.class);
                startActivityForResult(intent, requestCode);
            }
        });

        llhPhoneContact1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
                startActivity(intent);
            }
        });

        llhWebsiteContact1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + website));
                startActivity(intent);
            }
        });

        llhLocationContact1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            llhContact1 = findViewById(R.id.llhContact1);
            llhContact1.setVisibility(View.VISIBLE);

            pfp = data.getStringExtra("pfp");
            name = data.getStringExtra("name");
            phone = data.getStringExtra("phone");
            website = data.getStringExtra("website");
            location = data.getStringExtra("address");

            tvNameContact1 = findViewById(R.id.tvNameContact1);
            tvPhoneContact1 = findViewById(R.id.tvPhoneContact1);
            tvWebsiteContact1 = findViewById(R.id.tvWebsiteContact1);
            tvLocationContact1 = findViewById(R.id.tvLocationContact1);

            tvNameContact1.setText(name);
            tvPhoneContact1.setText(phone);
            tvWebsiteContact1.setText(website);
            tvLocationContact1.setText(location);
            switch (pfp) {
                case "satisfied":
                    ivContact1.setImageResource(R.drawable.satisfied);
                case "neutral":
                    ivContact1.setImageResource(R.drawable.neutral);
                case "dissatisfied":
                    ivContact1.setImageResource(R.drawable.dissatisfied);
            }

        } else {
            Toast.makeText(this, "No data passed through", Toast.LENGTH_SHORT).show();
        }
    }
}