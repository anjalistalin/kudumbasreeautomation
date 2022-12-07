package com.example.kudumbasree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LoanDetails extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    MyAdapterLoanMem myAdapterLoanMem;
    ArrayList<LoanMem> list;
    ImageView Loanback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_details);

        Loanback=findViewById(R.id.loanbackmembtn);
        recyclerView=findViewById(R.id.loanmemrecycle);

       Loanback.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(LoanDetails.this,homescreenmember.class);
               startActivity(i);
           }
       });

        databaseReference= FirebaseDatabase.getInstance().getReference("Loan");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list=new ArrayList<>();
        myAdapterLoanMem= new MyAdapterLoanMem(this,list);
        recyclerView.setAdapter(myAdapterLoanMem);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot: snapshot.getChildren()){

                    LoanMem loanMem=dataSnapshot.getValue(LoanMem.class);
                    list.add(loanMem);

            }
                myAdapterLoanMem.notifyDataSetChanged();


        }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

            });

    }
}