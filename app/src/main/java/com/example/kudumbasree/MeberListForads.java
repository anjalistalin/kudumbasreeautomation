package com.example.kudumbasree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MeberListForads extends AppCompatActivity {

    ImageView ListBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meber_list_forads);

        ListBack=findViewById(R.id.listback);

        ListBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(MeberListForads.this,ADSHomescreen.class);
               startActivity(intent);
            }
        });

    }
}