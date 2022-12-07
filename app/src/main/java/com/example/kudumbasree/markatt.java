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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class markatt extends AppCompatActivity implements AttendanceMyAdapter.AdapterCallback {

    RecyclerView recyclerView;
    DatabaseReference databaseReference, databaseReference1, databaseReference2;
    AttendanceMyAdapter attendanceMyAdapter;
    ArrayList<AttendanceModelClass> list;
    ArrayList<String> presentList, absentList;
    Button Submit;
    ImageView Markback;

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markatt);

        Submit = findViewById(R.id.submit);
        Markback=findViewById(R.id.markback);
        recyclerView = findViewById(R.id.attendancerecycle);
        databaseReference = FirebaseDatabase.getInstance().getReference("UnitMember");
        databaseReference2 = FirebaseDatabase.getInstance().getReference("President");
        databaseReference1 = FirebaseDatabase.getInstance().getReference("Attendence");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        attendanceMyAdapter = new AttendanceMyAdapter(markatt.this, list, this);
        recyclerView.setAdapter(attendanceMyAdapter);

        presentList = new ArrayList<>();
        absentList = new ArrayList<>();

        Markback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentback=new Intent(markatt.this,homescreenpresident.class);
                startActivity(intentback);
            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference1.child("Attendence").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference1.child("Present").child(dateToString()).setValue(presentList);
                        Toast.makeText(markatt.this, "Attendance id recorded", Toast.LENGTH_SHORT).show();



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getApplicationContext(), "Error present List" + error.getMessage().toString(), Toast.LENGTH_SHORT);

                    }
                });
                Intent submitback = new Intent(markatt.this,homescreenpresident.class);
                startActivity(submitback);


            }
        });
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    AttendanceModelClass attendanceModelClass = dataSnapshot.getValue(AttendanceModelClass.class);
                    list.add(attendanceModelClass);


                }
                attendanceMyAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Error loading data" + error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    AttendanceModelClass attendanceModelClass = dataSnapshot.getValue(AttendanceModelClass.class);
                    list.add(attendanceModelClass);


                }
                attendanceMyAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Error" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void addToPresentList(String name) {
        presentList.add(name);
        Log.d("presentList", presentList.get(0));
    }

    public String dateToString() {
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateToString = dateFormat.format(calendar.getTime());
        return dateToString;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }


}