package com.example.kudumbasree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ApplyLoan extends AppCompatActivity {
    EditText Unitname,Unitid,Totalamount,Memno;
    TextView LoanName,LoanId;
    Button Sendreq;
    DatabaseReference databaseReference;
    ImageView Loanapplyback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_loan);

        Sendreq=findViewById(R.id.sendreq);
        Loanapplyback=findViewById(R.id.loanapplyback);
        Unitname=findViewById(R.id.unitname);
        Unitid=findViewById(R.id.unitid);
        LoanName=findViewById(R.id.loanname);
        LoanId=findViewById(R.id.loanid);
        Totalamount=findViewById(R.id.totalamount);
        Memno=findViewById(R.id.memno);
        Intent intent=getIntent();
        String loanidStr=intent.getStringExtra("Loanid");
        String loannameStr=intent.getStringExtra("Loanname");
        LoanName.setText(loannameStr);
        LoanId.setText(loanidStr);

        Toast.makeText(ApplyLoan.this,loanidStr+loannameStr,Toast.LENGTH_SHORT).show();

        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://kudumbasree-581e9-default-rtdb.firebaseio.com/");

        Loanapplyback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ApplyLoan.this,homescreenpresident.class);
                startActivity(intent);
            }
        });

        Sendreq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String unitnameStr=Unitname.getText().toString();
                String UnitidStr=Unitid.getText().toString();
                String TotalamountStr=Totalamount.getText().toString();
                String MemnoStr=Memno.getText().toString();





                if(unitnameStr.isEmpty() || UnitidStr.isEmpty() ||  TotalamountStr.isEmpty() || MemnoStr.isEmpty()){
                    Toast.makeText(ApplyLoan.this, "Please Enter All the Details", Toast.LENGTH_SHORT).show();
                }else{
                    databaseReference.child("LoanRequest").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            databaseReference.child("LoanRequest").child(UnitidStr).child("UnitName").setValue(unitnameStr);
                            databaseReference.child("LoanRequest").child(UnitidStr).child("UnitId").setValue(UnitidStr);
                            databaseReference.child("LoanRequest").child(UnitidStr).child("TotalAmount").setValue(TotalamountStr);
                            databaseReference.child("LoanRequest").child(UnitidStr).child("Memno").setValue(MemnoStr);

                            Toast.makeText(ApplyLoan.this, "Informations are entered", Toast.LENGTH_SHORT).show();


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(ApplyLoan.this,"Error"+error.getMessage().toString(),Toast.LENGTH_SHORT).show();

                        }
                    });

                    //databaseReference=FirebaseDatabase.getInstance().getReference("Loan");
       /*         databaseReference.ch.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                String loanidStr = snapshot1.child("LoanId").getValue().toString();
                                String loannameStr = snapshot1.child("LoanName").getValue().toString();
                                Loanid.setText(loanidStr);
                                LoanName.setText(loannameStr);



                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                          Toast.makeText(ApplyLoan.this,"Error"+error.getMessage().toString(),Toast.LENGTH_LONG).show();
                        }
                    }); */

                }
        }

    });

    }
}