package com.example.kudumbasree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LoanViewByMember extends AppCompatActivity {
    Button  dl,dp;
    ImageView backloan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_view_by_member);

        dl=findViewById(R.id.ld);
        dp=findViewById(R.id.pd);
        backloan=findViewById(R.id.loanback);

        backloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(LoanViewByMember.this,homescreenmember.class);
                startActivity(in);
            }
        });


        dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoanViewByMember.this,LoanDetails.class);
                startActivity(intent);
            }
        });

        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(LoanViewByMember.this,PaymentInfo.class);
                startActivity(intent1);
            }
        });
    }
}