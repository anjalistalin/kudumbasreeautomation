package com.example.kudumbasree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class JobAlert extends AppCompatActivity {
    EditText JobCategory,Venue,Interviewdate,Time,Education;
    Button Jobalertbtn;
    ImageView jobback;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_alert);

        JobCategory = findViewById(R.id.jobcategory);
        Venue = findViewById(R.id.venue);
        Interviewdate = findViewById(R.id.interviewdate);
        Time = findViewById(R.id.time);
        Education=findViewById(R.id.education);
        Jobalertbtn = findViewById(R.id.jobalertsend);

        jobback =findViewById(R.id.jobalertback);

        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://kudumbasree-581e9-default-rtdb.firebaseio.com/");

        jobback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JobAlert.this,ADSHomescreen.class);
                startActivity(intent);
            }
        });

        Jobalertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String jobcategoryStr=JobCategory.getText().toString();
                String venueStr=Venue.getText().toString();
                String interviewdateStr=Interviewdate.getText().toString();
                String timeStr=Time.getText().toString();
                String educationStr=Education.getText().toString();

                if(jobcategoryStr.isEmpty() || venueStr.isEmpty() || interviewdateStr.isEmpty() || timeStr.isEmpty() ){

                    Toast.makeText(JobAlert.this, "Please enter all details", Toast.LENGTH_SHORT).show();

                }else{
                    databaseReference.child("JobAlert").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            databaseReference.child("JobAlert").child(jobcategoryStr).child("JobCategory").setValue(jobcategoryStr);
                            databaseReference.child("JobAlert").child(jobcategoryStr).child("Venue").setValue(venueStr);
                            databaseReference.child("JobAlert").child(jobcategoryStr).child("InterviewDate").setValue(interviewdateStr);
                            databaseReference.child("JobAlert").child(jobcategoryStr).child("Time").setValue(timeStr);
                            databaseReference.child("JobAlert").child(jobcategoryStr).child("Education").setValue(educationStr);



                            Toast.makeText(JobAlert.this, "Informations are entered", Toast.LENGTH_SHORT).show();
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                            Toast.makeText(JobAlert.this,"Error"+error.getMessage().toString(),Toast.LENGTH_SHORT).show();

                        }
                    });
                }

            }
        });

    }
}