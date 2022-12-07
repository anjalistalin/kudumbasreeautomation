package com.example.kudumbasree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button preslog,memlogin,loginads;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preslog=findViewById(R.id.prelogin);
        memlogin=findViewById(R.id.login);
        loginads=findViewById(R.id.adslogin);

        preslog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,LoginPage.class);
                startActivity(intent);
            }
        });

        memlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,LoginPageForUnitMember.class);
                startActivity(intent);

            }
        });

        loginads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AdsLogin.class);
                startActivity(intent);

            }
        });
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();

        }


    }
}
