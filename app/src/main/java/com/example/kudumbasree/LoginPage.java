package com.example.kudumbasree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.nio.file.WatchEvent;

public class LoginPage extends AppCompatActivity {
    Button prelogin;
    TextView textview,frgtPassword;
    FirebaseAuth fAuth;
    EditText email,password,kId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        prelogin=findViewById(R.id.loginpre);
        textview=findViewById(R.id.createnew);
        frgtPassword=findViewById(R.id.forgt);
        email=findViewById(R.id.emailLogin);
        password=findViewById(R.id.passwrdlogin);
        kId=findViewById(R.id.kudumbasreeidlogin);

        fAuth=FirebaseAuth.getInstance();
        prelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String emailStr=email.getText().toString();
               String passwordStr=password.getText().toString();
               String kidStr=kId.getText().toString();

               if (emailStr.isEmpty()|| passwordStr.isEmpty()||kidStr.isEmpty()){
                   Toast.makeText(LoginPage.this, "Please Enter the All details", Toast.LENGTH_SHORT).show();
               }else{

                   fAuth.signInWithEmailAndPassword(emailStr,passwordStr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if (task.isSuccessful()){
                               Intent intent=new Intent(LoginPage.this,homescreenpresident.class);
                               intent.putExtra("Kid",kidStr);
                               startActivity(intent);
                           }else{
                               Toast.makeText(LoginPage.this, "Login failed", Toast.LENGTH_SHORT).show();
                           }
                       }
                   }).addOnFailureListener(new OnFailureListener() {
                       @Override
                       public void onFailure(@NonNull Exception e) {
                           Toast.makeText(LoginPage.this, "Error"+e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                       }
                   });
               }


            }
        });

        frgtPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(LoginPage.this,forgtpage.class);
                startActivity(intent);

            }
        });

        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginPage.this,registrationpage.class);
                startActivity(intent);

            }
        });


    }
}