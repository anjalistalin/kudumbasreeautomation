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

public class PaymentInfo extends AppCompatActivity {

    ImageView Loanpaymentback;
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    PaymentinfoAdapter paymentinfoAdapter;
    ArrayList<PayinfoModelClass> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_info);

        Loanpaymentback=findViewById(R.id.loanpaymentback);
        recyclerView = findViewById(R.id.paymentrecycleviewer);
        databaseReference = FirebaseDatabase.getInstance().getReference("PayLoan");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        paymentinfoAdapter = new PaymentinfoAdapter(this, list);
        recyclerView.setAdapter(paymentinfoAdapter);

        Loanpaymentback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentInfo.this, homescreenmember.class);
                startActivity(intent);

            }
        });

        databaseReference.addValueEventListener(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                        for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                                                            PayinfoModelClass payinfoModelClass = dataSnapshot.getValue(PayinfoModelClass.class);
                                                            list.add(payinfoModelClass);
                                                        }

                                                        paymentinfoAdapter.notifyDataSetChanged();
                                                    }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

                                                }

    }
