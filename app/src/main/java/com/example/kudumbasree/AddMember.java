package com.example.kudumbasree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

public class AddMember extends AppCompatActivity {
    Button Add;
    EditText Emailid, Name,Phoneno,Unitname,Unitid, Password,Dob;
    FirebaseAuth fAuth;
    DatabaseReference databaseReference;
    ImageView Addback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);

        Add = findViewById(R.id.addm);
        Emailid = findViewById(R.id.emailid);
        Phoneno = findViewById(R.id.phoneno);
        Name = findViewById(R.id.name);
        Unitname = findViewById(R.id.unitname);
        Unitid = findViewById(R.id.kid);
        Addback = findViewById(R.id.addback);
        Password = findViewById(R.id.password);
        Dob =findViewById(R.id.dob);

        fAuth = FirebaseAuth.getInstance();

        databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kudumbasree-581e9-default-rtdb.firebaseio.com/");


        Addback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddMember.this, MemberList.class);
                startActivity(intent);
            }
        });
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailStr = Emailid.getText().toString();
                String phoneStr = Phoneno.getText().toString();
                String nameStr = Name.getText().toString();
                String unitnameStr = Unitname.getText().toString();
                String unitidStr = Unitid.getText().toString();
                String passwordStr = Password.getText().toString();
                String dobStr =Dob.getText().toString();


                if (nameStr.isEmpty() || emailStr.isEmpty() || dobStr.isEmpty() || phoneStr.isEmpty() || unitidStr.isEmpty() || unitnameStr.isEmpty() || passwordStr.isEmpty()) {

                    Toast.makeText(AddMember.this, "Please enter all details", Toast.LENGTH_SHORT).show();

                } else {
                    fAuth.createUserWithEmailAndPassword(emailStr, passwordStr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                databaseReference.child("RegistrationTable").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        databaseReference.child("RegistrationTable").child(unitidStr).child("UnitId").setValue(unitidStr);
                                        databaseReference.child("RegistrationTable").child(unitidStr).child("Unitname").setValue(unitnameStr);
                                        databaseReference.child("RegistrationTable").child(unitidStr).child("Name").setValue(nameStr);
                                        databaseReference.child("RegistrationTable").child(unitidStr).child("Emailid").setValue(emailStr);
                                        databaseReference.child("RegistrationTable").child(unitidStr).child("Phoneno").setValue(phoneStr);
                                        databaseReference.child("RegistrationTable").child(unitidStr).child("password").setValue(passwordStr);
                                        databaseReference.child("RegistrationTable").child(unitidStr).child("DOB").setValue(dobStr);

                                        Toast.makeText(AddMember.this, "User Created", Toast.LENGTH_SHORT).show();


                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        Toast.makeText(AddMember.this, "Error" + error.getMessage().toString(), Toast.LENGTH_SHORT).show();

                                    }
                                });


                            }
                        }

                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(AddMember.this, "Error" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();

                        }
                    });

                }
            }

        });
    }
}
