package com.example.kudumbasree;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class splashactivity extends AppCompatActivity {
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(splashactivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();

        }
    }
}