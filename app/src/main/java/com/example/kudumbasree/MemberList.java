package com.example.kudumbasree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MemberList extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference,databaseReference1;
    MemberlistMyAdapter myAdapter;
    ArrayList<MemberlistModelClass> list;

    ImageView Memberlistback;
    Button Addmember,Requestlist,Find;
    EditText Kid;
    String Kudumbasreeid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);

        Memberlistback = findViewById(R.id.memberlistback);
        recyclerView = findViewById(R.id.memberlistrecycle);
       Addmember=findViewById(R.id.addmember);
        Requestlist=findViewById(R.id.request);
        Kid=findViewById(R.id.kid);
        Find=findViewById(R.id.find);
        databaseReference = FirebaseDatabase.getInstance().getReference("President");
        Memberlistback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backintent = new Intent(MemberList.this,homescreenpresident.class);
                startActivity(backintent);
            }
        });
        Addmember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentadd = new Intent(MemberList.this,AddMember.class);
                startActivity(intentadd);
            }
        });

        Requestlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentreq = new Intent(MemberList.this,RequestList.class);
                startActivity(intentreq);
            }
        });

        Memberlistback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MemberList.this,homescreenpresident.class);
                startActivity(in);
            }
        });

        Find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Kudumbasreeid=Kid.getText().toString();
                databaseReference.child(Kudumbasreeid).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                            Log.d("111",String.valueOf(dataSnapshot));
                          /*  MemberlistModelClass memberlistModelClass = dataSnapshot.getValue(MemberlistModelClass.class);
                            list.add(memberlistModelClass);*/

                        }

                        list.add(new MemberlistModelClass((String) snapshot.child("Name").getValue(),(String) snapshot.child("PhoneNo").getValue()));
                        myAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new MemberlistMyAdapter(this, list);
        recyclerView.setAdapter(myAdapter);



    }
}
