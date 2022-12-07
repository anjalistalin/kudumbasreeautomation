package com.example.kudumbasree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LoanForADS extends AppCompatActivity {

    ImageView LoanBank;
    Button ComposeLoan,RequestLoan,BorrowersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_for_ads);

        LoanBank=findViewById(R.id.loanback);
        ComposeLoan=findViewById(R.id.composeloan);
        RequestLoan=findViewById(R.id.requestloan);
        BorrowersList=findViewById(R.id.borrowerslist);

        LoanBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoanForADS.this,ADSHomescreen.class);
                startActivity(intent);
            }
        });

        ComposeLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoanForADS.this,CompossLoan.class);
                startActivity(intent);
            }
        });

        RequestLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(LoanForADS.this,Requestloan.class);
                startActivity(intent1);
            }
        });

        BorrowersList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(LoanForADS.this,BorrowersList.class);
                startActivity(intent2);
            }
        });

    }
}