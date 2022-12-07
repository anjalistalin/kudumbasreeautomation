package com.example.kudumbasree;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class atviewbymem extends AppCompatActivity {

    ImageView back;
    ListView Attendancelist;
    DatabaseReference databaseReference;
    List<AttendanceModelClass> uploads;
    ViewattModelClass viewattModelClass;
    ArrayList<String> Present;
    public static final String DATE_FORMAT = "yyyy-MM-dd";


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atviewbymem);
        Attendancelist = findViewById(R.id.attlistviewbymem);
        Present=new ArrayList<String>();
        back=findViewById(R.id.searchback);

viewAllFiles();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(atviewbymem.this,homescreenmember.class);
                startActivity(intent);
            }
        });


    }
    public String dateToString() {
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateToString = dateFormat.format(calendar.getTime());
        return dateToString;
    }

    private void viewAllFiles() {
        databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kudumbasree-581e9-default-rtdb.firebaseio.com/Attendence");
        String dateStr=this.dateToString();
        databaseReference.child("Present").child(dateStr).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Present= (ArrayList<String>) snapshot.getValue();

                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, Present) {
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);
                        TextView text = (TextView) view.findViewById(android.R.id.text1);
                        text.setTextColor(Color.BLACK);
                        text.setTextSize(22);

                        return view;
                    }
                };
                Attendancelist.setAdapter(adapter);


        }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}