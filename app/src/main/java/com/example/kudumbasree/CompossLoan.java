package com.example.kudumbasree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.Period;

public class CompossLoan extends AppCompatActivity {
    ImageView CompossBack;
    EditText Loanname,LoanId,Category,Amount,Permonth,Period,Interest,LastDate;
    Button Send;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_composs_loan);

        CompossBack=findViewById(R.id.compossback);
        Send=findViewById(R.id.send);

        Loanname = findViewById(R.id.loanname);
        LoanId = findViewById(R.id.loanid);
        Category = findViewById(R.id.category);
        Amount = findViewById(R.id.amount);
        Permonth = findViewById(R.id.permonth);
        Period = findViewById(R.id.period);
        Interest = findViewById(R.id.interest);
        LastDate =findViewById(R.id.lastdate);


        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://kudumbasree-581e9-default-rtdb.firebaseio.com/");

        CompossBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CompossLoan.this,ADSHomescreen.class);
                startActivity(intent);
            }
        });


        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loannameStr=Loanname.getText().toString();
                String loanidStr=LoanId.getText().toString();
                String categoryStr=Category.getText().toString();
                String amountStr=Amount.getText().toString();
                String permonthStr=Permonth.getText().toString();
               String periodStr=Period.getText().toString();
                String interestStr=Interest.getText().toString();
                String lastdateStr=LastDate.getText().toString();

                if(loannameStr.isEmpty() || loanidStr.isEmpty() || categoryStr.isEmpty() || amountStr.isEmpty() || permonthStr.isEmpty() || periodStr.isEmpty() || interestStr.isEmpty()){

                    Toast.makeText(CompossLoan.this, "Please enter all details", Toast.LENGTH_SHORT).show();

                }else{

                    databaseReference.child("Loan").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            databaseReference.child("Loan").child(loanidStr).child("LoanId").setValue(loanidStr);
                            databaseReference.child("Loan").child(loanidStr).child("LoanName").setValue(loannameStr);
                            databaseReference.child("Loan").child(loanidStr).child("Category").setValue(categoryStr);
                            databaseReference.child("Loan").child(loanidStr).child("Amount").setValue(amountStr);
                            databaseReference.child("Loan").child(loanidStr).child("Permonth").setValue(permonthStr);
                            databaseReference.child("Loan").child(loanidStr).child("Period").setValue(periodStr);
                            databaseReference.child("Loan").child(loanidStr).child("Interest").setValue(interestStr);
                            databaseReference.child("Loan").child(loanidStr).child("LastDate").setValue(lastdateStr);

                            Toast.makeText(CompossLoan.this, "Informations are entered", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(CompossLoan.this,"Error"+error.getMessage().toString(),Toast.LENGTH_SHORT).show();

                        }
                    });

                }
            }
        });
    }
}