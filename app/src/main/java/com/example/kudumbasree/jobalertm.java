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

public class jobalertm extends AppCompatActivity {

    ImageView Jobalertback;
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    MyAdapterMem myAdaptermem;
    ArrayList<JobModelClassMem> list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobalertm);

        recyclerView = findViewById(R.id.jobalertmemrecycle);
        databaseReference = FirebaseDatabase.getInstance().getReference("JobAlert");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        myAdaptermem = new MyAdapterMem(this, list);
        recyclerView.setAdapter(myAdaptermem);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    JobModelClassMem jobModelClassMem = dataSnapshot.getValue(JobModelClassMem.class);
                    list.add(jobModelClassMem);
                }

                myAdaptermem.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



            }



    }

