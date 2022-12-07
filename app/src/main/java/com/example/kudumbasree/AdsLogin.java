package com.example.kudumbasree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AdsLogin extends AppCompatActivity {
   FirebaseAuth fAuth;
    EditText email,password;

    Button lads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads_login);
        email=findViewById(R.id.emailads);
        password=findViewById(R.id.passads);
        lads=findViewById(R.id.adl);

        fAuth=FirebaseAuth.getInstance();

        lads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String emailStr=email.getText().toString();
                String passwordStr=password.getText().toString();

                if (emailStr.isEmpty()|| passwordStr.isEmpty()){
                    Toast.makeText(AdsLogin.this, "Please enter all the details", Toast.LENGTH_SHORT).show();}
                else{
                    fAuth.signInWithEmailAndPassword(emailStr,passwordStr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){

                                Intent intent= new Intent(AdsLogin.this,ADSHomescreen.class);
                                startActivity(intent);

                            }else{
                                Toast.makeText(AdsLogin.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(AdsLogin.this,"Error"+e.getMessage().toString(),Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });
    }
}