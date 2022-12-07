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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Bankloanpayment extends AppCompatActivity {
    EditText Loanname,Loanid, Loanamount,Payamount,Installmentno;
    Button Payloan;
    DatabaseReference databaseReference;
    ImageView SearchBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bankloanpayment);
        Loanname=findViewById(R.id.loanname);
        Loanid=findViewById(R.id.loanid);
        Loanamount=findViewById(R.id.loanamount);
        Payamount=findViewById(R.id.payamount);
        Payloan=findViewById(R.id.payloan);
        SearchBack=findViewById(R.id.searchback);
        Installmentno=findViewById(R.id.installmentno);

        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://kudumbasree-581e9-default-rtdb.firebaseio.com/");
        Payloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String LoannameStr=Loanname.getText().toString();
                String LoanidStr=Loanid.getText().toString();
                String LoanamountStr=Loanamount.getText().toString();
                String PayamountStr=Payamount.getText().toString();
                String InstallmentStr=Installmentno.getText().toString();

                if(LoanamountStr.isEmpty() || PayamountStr.isEmpty() || LoannameStr.isEmpty() || LoanidStr.isEmpty() || InstallmentStr.isEmpty()){
                    Toast.makeText(Bankloanpayment.this, "Please enter all details", Toast.LENGTH_SHORT).show();

                }else{
                    databaseReference.child("PayLoan").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            databaseReference.child("PayLoan").child(LoanidStr).child("Loanid").setValue(LoanidStr);
                            databaseReference.child("PayLoan").child(LoanidStr).child("LoanName").setValue(LoannameStr);
                            databaseReference.child("PayLoan").child(LoanidStr).child("LoanAmount").setValue(LoanamountStr);
                            databaseReference.child("PayLoan").child(LoanidStr).child("InstalllmentNo").setValue(InstallmentStr);
                            databaseReference.child("PayLoan").child(LoanidStr).child("PayAmount").setValue(PayamountStr);
                            Toast.makeText(Bankloanpayment.this, "Loan paid successfully", Toast.LENGTH_SHORT).show();


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(Bankloanpayment.this, "Error" + error.getMessage().toString(), Toast.LENGTH_SHORT).show();


                        }
                    });
                }
            }
        });
        SearchBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(Bankloanpayment.this,homescreenpresident.class);
                startActivity(inte);
            }
        });


    }
}