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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginPageForUnitMember extends AppCompatActivity {
    Button prelogin;
    TextView textview,password;
    FirebaseAuth fAuth;
    EditText email,Password,Phoneno;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page_for_unit_member);

        prelogin=findViewById(R.id.loginpre);
        textview=findViewById(R.id.createnew);
        password=findViewById(R.id.forgt);
        email=findViewById(R.id.mailmem);
        Password=findViewById(R.id.passmem);
        Phoneno=findViewById(R.id.phonemem);

        fAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://kudumbasree-581e9-default-rtdb.firebaseio.com/");

        prelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailStr = email.getText().toString();
                String passwordStr = password.getText().toString();
                String phoneStr = Phoneno.getText().toString();

                if (emailStr.isEmpty() || passwordStr.isEmpty() || phoneStr.isEmpty()) {
                    Toast.makeText(LoginPageForUnitMember.this, "Please enter all the details", Toast.LENGTH_SHORT).show();

                } else {
                    databaseReference.child("UnitMember").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(phoneStr)) {
                                final String getPassword=snapshot.child(phoneStr).child("Phoneno").getValue(String.class);
                                if(getPassword.equals(phoneStr)){
                                    Toast.makeText(LoginPageForUnitMember.this,"successfully logged in",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LoginPageForUnitMember.this,homescreenmember.class));
                                    finish();
                                }
else{
    Toast.makeText(LoginPageForUnitMember.this,"Invalid Entry",Toast.LENGTH_SHORT).show();
                                }

                                }
                            else {
                                Toast.makeText(LoginPageForUnitMember.this,"Wrong entry",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                /* fAuth.signInWithEmailAndPassword(emailStr,passwordStr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                         if (task.isSuccessful()){
                                Intent intent=new Intent(LoginPageForUnitMember.this,homescreenmember.class);
                                intent.putExtra("Phoneno",phoneStr);
                                startActivity(intent);
                           }else{
                                Toast.makeText(LoginPageForUnitMember.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(LoginPageForUnitMember.this, "Error"+e.getMessage().toString(), Toast.LENGTH_LONG).show();
                        }
                    });*/
                }


            }
        });
                    password.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            Intent intent = new Intent(LoginPageForUnitMember.this, forgtpage.class);
                            startActivity(intent);

                        }
                    });
                    textview.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(LoginPageForUnitMember.this, RegistrationForMember.class);
                            startActivity(intent);

                        }
                    });
                }
            }
