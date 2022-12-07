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

public class ExpenseViewByMember extends AppCompatActivity {
    ImageView btns;
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    ExpenseMemMyAdapter expensememmyadapter;
    ArrayList<ExpenseMemModelClass> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_view_by_member);
        recyclerView = findViewById(R.id.expensememrecycle);
        btns=findViewById(R.id.expensebackadsbtn);
        databaseReference = FirebaseDatabase.getInstance().getReference("Expense");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<ExpenseMemModelClass>();

        expensememmyadapter = new ExpenseMemMyAdapter(this,list);
        recyclerView.setAdapter(expensememmyadapter);


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    ExpenseMemModelClass expenseMemModelClass=dataSnapshot.getValue(ExpenseMemModelClass.class);
                    list.add(expenseMemModelClass);

            }
                expensememmyadapter.notifyDataSetChanged();

        }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
            });
        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExpenseViewByMember.this,homescreenmember.class);
                startActivity(intent);
            }
        });

            }


    }
