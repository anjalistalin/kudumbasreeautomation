package com.example.kudumbasree;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
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
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class viewattendance extends AppCompatActivity {

    ListView Attendancelist;
    DatabaseReference databaseReference;
    List<AttendanceModelClass> uploads;
    ImageView Searchbk;
    ViewattModelClass viewattModelClass;
    ArrayList<String> Present;
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewattendance);
        Searchbk = findViewById(R.id.searchback);
        Attendancelist = findViewById(R.id.attlistview);
     //   uploads = new ArrayList<>();
        Present=new ArrayList<String>();
        //  Date=findViewById(R.id.date);

        viewAllFiles();
    /*    Attendancelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AttendanceModelClass listitem = uploads.get(i);
            }
        }); */


        //    Search=findViewById(R.id.search);
 /*       databaseReference = FirebaseDatabase.getInstance().getReference("Attendence");
      Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Attendancedate=Date.getText().toString();
                databaseReference.child(Attendancedate).addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                            Log.d("111",String.valueOf(dataSnapshot));


                        }
                        for (int i=0;i<=10;i++){
                            list.add(new ViewattModelClass((String) snapshot.child(getString(i)).getValue()));
                        }

                        myAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getApplicationContext(),"Error"+error.getMessage().toString(),Toast.LENGTH_SHORT).show();

                    }
                });


                }
        });  */


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
              //      AttendanceModelClass attendanceModelClass = snapshot.getValue(AttendanceModelClass.class);
                // viewattModelClass = snapshot.getValue(ViewattModelClass.class);
                   Present= (ArrayList<String>) snapshot.getValue();

                   // uploads.add(attendanceModelClass);
               //     uploads.add(viewattModelClass);

                }
     /*           String[] Uploads = new String[uploads.size()];
                for (int i = 0; i <= uploads.size(); i++) {
                    Log.d("111", String.valueOf(snapshot.child(String.valueOf(i)).getValue()));
                    uploads.add(new AttendanceModelClass((String) snapshot.child(String.valueOf(i)).getValue()));

                } */
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
        Searchbk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentsearchback = new Intent(viewattendance.this,homescreenpresident.class);
                startActivity(intentsearchback);
            }
        });
    }


}
