package com.example.kudumbasree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MListForMember extends AppCompatActivity {
    ImageView backmemlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mlist_for_member);

        backmemlist=findViewById(R.id.memlistback);

        backmemlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MListForMember.this,homescreenmember.class);
                startActivity(intent);
            }
        });
    }
}