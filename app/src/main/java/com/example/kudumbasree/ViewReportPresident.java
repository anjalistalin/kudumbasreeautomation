package com.example.kudumbasree;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewReportPresident extends AppCompatActivity {

    ListView PDFlistview;
    DatabaseReference databaseReference;
    List<PDFModelClass> uploads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_report_president);
        PDFlistview = findViewById(R.id.pdflistview);
        uploads = new ArrayList<>();

        viewallFiles();
        PDFlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PDFModelClass pdfitem= uploads.get(i);
                Intent intent1 =new Intent(Intent.ACTION_VIEW);
                intent1.setType("Apllication/pdf");
                intent1.setData(Uri.parse(pdfitem.getUrl()));
                startActivity(intent1);
            }
        });
    }
    private void viewallFiles() {
        databaseReference= FirebaseDatabase.getInstance().getReference("Uploads");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                 for(DataSnapshot postsnapshot:snapshot.getChildren()){
                     PDFModelClass PDFmodelclass=postsnapshot.getValue(com.example.kudumbasree.PDFModelClass.class);
                     uploads.add(PDFmodelclass);
                 }
                 String[] Uploads=new String[uploads.size()];
                for (int i=0;i<Uploads.length;i++){
                    Uploads[i]=uploads.get(i).getName();

                }
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_expandable_list_item_1,Uploads){
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        View view=super.getView(position, convertView, parent);
                        TextView text=(TextView) view.findViewById(android.R.id.text1);
                        text.setTextColor(Color.BLACK);
                        text.setTextSize(22);

                        return view;
                    }
                };
                PDFlistview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}