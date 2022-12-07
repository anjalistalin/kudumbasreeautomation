package com.example.kudumbasree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class RegistrationForMember extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button regbtn;
    EditText name,emaiL,phoneNumber,Dob,Address,Password,Cpassword,Aadhar;
    String[] district = {"Trivardrum","Kottayam","Ernakulam","Thrissur","Idukkki","Palakkad","Wayanad"};
    String item_position;
    FirebaseAuth fAuth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_for_member);
        regbtn = findViewById(R.id.regmem_submit);
        Spinner spin = findViewById(R.id.spinner);

        name = findViewById(R.id.personname);
        emaiL =findViewById(R.id.email);

        phoneNumber =findViewById(R.id.phone);
        Dob = findViewById(R.id.dob);
        Address =findViewById(R.id.address);
        Password = findViewById(R.id.passwrd);
        Cpassword = findViewById(R.id.cpswd);
        Aadhar =findViewById(R.id.aadhar);
        fAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://kudumbasree-581e9-default-rtdb.firebaseio.com/");

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                item_position = String.valueOf(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameStr = name.getText().toString();
                String addressStr = Address.getText().toString();
                String emailStr = emaiL.getText().toString();
                String phonenumberStr = phoneNumber.getText().toString();
                String Dobstr = Dob.getText().toString();
                String passwordStr = Password.getText().toString();
                String CpasswordStr = Cpassword.getText().toString();
                String AadharStr = Aadhar.getText().toString();
                String spinStr = spin.getSelectedItem().toString();

                validateinfo(phonenumberStr,emailStr);


                if (nameStr.isEmpty() || addressStr.isEmpty() || emailStr.isEmpty() || phonenumberStr.isEmpty() || Dobstr.isEmpty() ||
                        passwordStr.isEmpty() || CpasswordStr.isEmpty() || AadharStr.isEmpty() || spinStr.isEmpty()) {

                    Toast.makeText(RegistrationForMember.this, "Please enter all details", Toast.LENGTH_SHORT).show();

                } else {
                    fAuth.createUserWithEmailAndPassword(emailStr, passwordStr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                databaseReference.child("RequestTable").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        databaseReference.child("RequestTable").child(phonenumberStr).child("EmailId").setValue(emailStr);
                                        databaseReference.child("RequestTable").child(phonenumberStr).child("Name").setValue(nameStr);
                                        databaseReference.child("RequestTable").child(phonenumberStr).child("Phoneno").setValue(phonenumberStr);
                                        databaseReference.child("RequestTable").child(phonenumberStr).child("DOB").setValue(Dobstr);
                                        databaseReference.child("RequestTable").child(phonenumberStr).child("Address").setValue(addressStr);
                                        databaseReference.child("RequestTable").child(phonenumberStr).child("Password").setValue(passwordStr);
                                        databaseReference.child("RequestTable").child(phonenumberStr).child("ConfirmPassword").setValue(CpasswordStr);
                                        databaseReference.child("RequestTable").child(phonenumberStr).child("Adhaarno").setValue(AadharStr);

                                        Toast.makeText(RegistrationForMember.this, "User Created", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(RegistrationForMember.this, LoginPageForUnitMember.class);
                                        startActivity(intent);
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        Toast.makeText(RegistrationForMember.this, "Error" + error.getMessage().toString(), Toast.LENGTH_SHORT).show();

                                    }
                                });


                            }
                        }

                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(RegistrationForMember.this, "Error" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });

                }

            }

            private boolean validateinfo(String phonenumberStr, String emailStr) {
                if(emailStr.length()==0){
                    emaiL.requestFocus();
                    emaiL.setError("Field cnanot be empty");
                }
                else if(!emailStr.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
                    emaiL.requestFocus();
                    emaiL.setError("Enter valid EMAIL");
                    return false;

                }else if(phonenumberStr.length()==0){
                    phoneNumber.requestFocus();
                    phoneNumber.setError("Field can not be empty");
                    return false;
                }else if(!phonenumberStr.matches("^[+][0-9]{10}")){
                    phoneNumber.requestFocus();
                    phoneNumber.setError("correct format: 10 digits");
                    return false;
                }
                return false;
            }

        });
        spin.setOnItemSelectedListener(this);
        ArrayAdapter aa =new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,district);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLUE);
        ((TextView) adapterView.getChildAt(0)).setTextSize(15);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}