package com.example.kudumbasree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ReportAdsview extends AppCompatActivity {


    EditText Kudumbasreeid;
    String kudumbasreeIdStr;
    ImageView backr;
    Button Viewbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_adsview);

        Viewbtn = findViewById(R.id.viewreport);
        backr = findViewById(R.id.rback);
        Kudumbasreeid = findViewById(R.id.kudumbasreeid);

        backr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(ReportAdsview.this,ADSHomescreen.class);
                startActivity(intent);

            }
        });

        Viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(ReportAdsview.this,ADSHomescreen.class);
                startActivity(intent1);
            }
        });

    }
}

