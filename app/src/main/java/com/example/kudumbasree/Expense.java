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

public class Expense extends AppCompatActivity {
    ImageView be;
    EditText KId,Reason,Amount,Date;
    Button Submitbtn;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        be=findViewById(R.id.eb);
        KId=findViewById(R.id.kid);
        Reason=findViewById(R.id.reason);
        Amount=findViewById(R.id.amount);
        Date=findViewById(R.id.date);
        Submitbtn=findViewById(R.id.expensesend);
        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://kudumbasree-581e9-default-rtdb.firebaseio.com/");


        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Expense.this,homescreenpresident.class);
                startActivity(intent);
            }
        });

        Submitbtn.setOnClickListener(view -> {

            String kidStr=KId.getText().toString();
            String reasonStr=Reason.getText().toString();
            String amountStr=Amount.getText().toString();
            String dateStr=Date.getText().toString();


            if(kidStr.isEmpty() || reasonStr.isEmpty() || amountStr.isEmpty() || dateStr.isEmpty()){

                Toast.makeText(Expense.this,"Please enter all the details", Toast.LENGTH_SHORT).show();


            }else{

                databaseReference.child("Expense").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        databaseReference.child("Expense").child(kidStr).child("Kudumbasreeid").setValue(kidStr);
                        databaseReference.child("Expense").child(kidStr).child("Reason").setValue(reasonStr);
                        databaseReference.child("Expense").child(kidStr).child("Amount").setValue(amountStr);
                        databaseReference.child("Expense").child(kidStr).child("Date").setValue(dateStr);
                        Toast.makeText(Expense.this, "Informations are Entered", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                        Toast.makeText(Expense.this,"Error"+error.getMessage().toString(),Toast.LENGTH_SHORT).show();


                    }
                });

            }



        });


    }
}