package com.example.kudumbasree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class JoinKudumbasree extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    JoinMyAdapter myAdapter;
    ArrayList<JoinModelClass> list;
    ImageView kj;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_kudumbasree);


        kj=findViewById(R.id.jk);
        recyclerView=findViewById(R.id.joinrecyclerview);
        searchView=findViewById(R.id.searchView);
        databaseReference= FirebaseDatabase.getInstance().getReference("President");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list=new ArrayList<>();
        myAdapter =new JoinMyAdapter(this,list);
        recyclerView.setAdapter(myAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                            JoinModelClass joinModelClass = dataSnapshot.getValue(JoinModelClass.class);
                                                            list.add(joinModelClass);


                                                        }
                                                        myAdapter.notifyDataSetChanged();

                                                    }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),"Error loading data"+error.getMessage(),Toast.LENGTH_SHORT).show();


            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<JoinModelClass> filteredlist = new ArrayList<>();
                for (JoinModelClass item : list) {
                    if (item.getKudumbasreeName().toLowerCase().contains(s.toLowerCase())) {
                        filteredlist.add(item);
                    }
                }
                if (filteredlist.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "No Data Found..", Toast.LENGTH_SHORT).show();
                } else {
                    myAdapter.filterdList(filteredlist);

                }
                return false;
            }
        });


}
}