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

public class Requestloan extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    RequestloanMyAdapter myAdapter;
    ArrayList<RequestloanModelClass> list;
    ImageView Requestloanback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestloan);
        recyclerView = findViewById(R.id.requestloanrecycle);
        Requestloanback = findViewById(R.id.requestloanback);

        Requestloanback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Requestloan.this, ADSHomescreen.class);
                startActivity(intent2);
            }
        });
        databaseReference = FirebaseDatabase.getInstance().getReference("LoanRequest");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new RequestloanMyAdapter(this, list);
        recyclerView.setAdapter(myAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    RequestloanModelClass requestloanModelClass = dataSnapshot.getValue(RequestloanModelClass.class);
                    list.add(requestloanModelClass);
                }
                myAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}