package com.example.kudumbasree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class memlogin extends AppCompatActivity {
    Button loginmem;
    TextView textview,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memlogin);

        loginmem=findViewById(R.id.membloginbtn);
        textview=findViewById(R.id.createnew);
        password=findViewById(R.id.forgt);

        loginmem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(memlogin.this,homescreenmember.class);
                startActivity(intent);
            }
        });

        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(memlogin.this,forgtpage.class);
                startActivity(intent);

            }
        });

        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(memlogin.this,RegistrationForMember.class);
                startActivity(intent);

            }
        });
    }
}