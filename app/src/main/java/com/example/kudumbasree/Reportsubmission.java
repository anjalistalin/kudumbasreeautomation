package com.example.kudumbasree;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Reportsubmission extends AppCompatActivity {
    Button Choosefile,Viewbtn;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    EditText Kudumbasreeid,Fromdate,Todate;
    String kudumbasreeIdStr,fromdateStr,todateStr;

    ImageView backr;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportsubmission);
         Choosefile=findViewById(R.id.choosefile);
        Viewbtn=findViewById(R.id.viewreport);
        backr=findViewById(R.id.rback);

        Kudumbasreeid = findViewById(R.id.kudumbasreeid);
        Fromdate =findViewById(R.id.fromdate);
        Todate = findViewById(R.id.todate);

        backr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Reportsubmission.this,homescreenpresident.class);
                startActivity(intent);
            }
        });

        storageReference= FirebaseStorage.getInstance().getReferenceFromUrl("gs://kudumbasree-581e9.appspot.com");
        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://kudumbasree-581e9-default-rtdb.firebaseio.com/");
        Choosefile.setOnClickListener(new View.OnClickListener() {

                                      @Override
                                      public void onClick(View view) {
                                          kudumbasreeIdStr = Kudumbasreeid.getText().toString();
                                          fromdateStr = Fromdate.getText().toString();
                                          todateStr = Todate.getText().toString();


                                          Intent intent=new Intent(); intent.setType("application/pdf");
                                          intent.setAction(Intent.ACTION_GET_CONTENT);
                                          startActivityForResult(Intent.createChooser(intent,"Select PDF Files..."),1);
                                      }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1 && resultCode==RESULT_OK && data.getData()!=null){
            UploadFiles(data.getData());
            Toast.makeText(Reportsubmission.this,"phase 1" ,Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(Reportsubmission.this,"error" ,Toast.LENGTH_SHORT).show();
        }
    }

    private void UploadFiles(Uri data){
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Uploading");
        progressDialog.show();


        StorageReference reference=storageReference.child("Uploads");
        reference.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Task<Uri> uriTask=taskSnapshot.getStorage().getDownloadUrl();
                        while (!uriTask.isComplete());
                        Uri url=uriTask.getResult();

                        PDFModelClass pdfclas=new PDFModelClass(Kudumbasreeid.getText().toString(),url.toString());
                        databaseReference.child("Uploads").child(databaseReference.push().getKey()).setValue(pdfclas);

                        Toast.makeText(Reportsubmission.this,"files uploaded" ,Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }

                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                        double progress=(100.0* snapshot.getBytesTransferred())/snapshot.getTotalByteCount();
                        progressDialog.setMessage("uploaded:"+(int)progress+"%");

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Reportsubmission.this,"Error"+e.getMessage().toString() ,Toast.LENGTH_SHORT).show();
                    }
                });




        Viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(Reportsubmission.this,ViewReportPresident.class);
                startActivity(intent1);
            }
        });
    }
}