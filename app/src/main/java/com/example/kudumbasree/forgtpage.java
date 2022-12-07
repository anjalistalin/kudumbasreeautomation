package com.example.kudumbasree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class forgtpage extends AppCompatActivity {
    EditText emailET;
    Button Forgotbtn;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgtpage);
        emailET = findViewById(R.id.email);
        Forgotbtn = findViewById(R.id.forgot);
        auth=FirebaseAuth.getInstance();

        Forgotbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // EditText resetMail=new EditText((view.getContext()));
                String mailStr=emailET.getText().toString();
                Toast.makeText(forgtpage.this, mailStr, Toast.LENGTH_SHORT).show();
                auth.sendPasswordResetEmail(mailStr).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(forgtpage.this, "Reset link send to the mail", Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(forgtpage.this, "Error!"+e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });



            }
        });



    }
}