package com.example.kudumbasree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ExpenseViewBYADS extends AppCompatActivity {
    ImageView ExpenseBack;
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    ExpenseMyAdapter expensemyadapter;
    ArrayList<ExpenseModelClass> list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_view_byads);

        recyclerView = findViewById(R.id.expenserecycle);
        databaseReference = FirebaseDatabase.getInstance().getReference("Expense");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        expensemyadapter = new ExpenseMyAdapter(this,list);
        recyclerView.setAdapter(expensemyadapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    ExpenseModelClass expenseModelClass=dataSnapshot.getValue(ExpenseModelClass.class);
                    list.add(expenseModelClass);
                }

                expensemyadapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}