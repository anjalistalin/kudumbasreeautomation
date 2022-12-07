package com.example.kudumbasree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

public class registrationpage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button regbtn;
    String[] district = {"Trivardrum","Kottayam","Ernakulam","Thrissur","Idukkki","Palakkad","Wayanad"};
    EditText name,emaiL,kudumbasreename,phoneNumber,Dob,Address,Password,Cpassword,Aadhar,KudumbaSname,Panchayath,Ward,KudumbaSreeId,Place;
    FirebaseAuth fAuth;
    AlertDialog.Builder builder;
    DatabaseReference databaseReference;
    String item_position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationpage);

        regbtn = findViewById(R.id.dia_submit);
        Spinner spin = findViewById(R.id.spinner);

        name = findViewById(R.id.personname);
        emaiL =findViewById(R.id.email);
        kudumbasreename = findViewById(R.id.kudumbasreename);
        phoneNumber =findViewById(R.id.phone);
        Dob = findViewById(R.id.dob);
        Address =findViewById(R.id.address);
        Password = findViewById(R.id.passwrd);
        Cpassword = findViewById(R.id.cpswd);
        Aadhar =findViewById(R.id.aadhar);
        KudumbaSname = findViewById(R.id.kudumbasreename);
        Panchayath = findViewById(R.id.panchayath);
        Ward = findViewById(R.id.ward);
        KudumbaSreeId = findViewById(R.id.kudumbasreeid);
        Place=findViewById(R.id.place);

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


        builder=new AlertDialog.Builder(this);
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameStr=name.getText().toString();
                String  kudumbasreenameStr=kudumbasreename.getText().toString();
                String  addressStr=Address.getText().toString();
                String  emailStr=emaiL.getText().toString();
                String  phonenumberStr=phoneNumber.getText().toString();
                String  Dobstr=Dob.getText().toString();
                String  passwordStr=Password.getText().toString();
                String  CpasswordStr=Cpassword.getText().toString();
                String  AadharStr=Aadhar.getText().toString();
                String  panchayathStr=Panchayath.getText().toString();
                String  WardStr=Ward.getText().toString();
                String  kudumbasreeidStr=KudumbaSreeId.getText().toString();
                String  placeStr=Place.getText().toString();
                String spinStr=spin.getSelectedItem().toString();

                boolean check=    validateinfo(emailStr,phonenumberStr,AadharStr,kudumbasreeidStr);
                if(check == true){
                    Toast.makeText(getApplicationContext(),"Data is vaild",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(registrationpage.this, "Sorry!! check the information aganin", Toast.LENGTH_SHORT).show();
                }

                if(nameStr.isEmpty() || kudumbasreenameStr.isEmpty() || addressStr.isEmpty() || emailStr.isEmpty() || phonenumberStr.isEmpty() || Dobstr.isEmpty() ||
                passwordStr.isEmpty() || CpasswordStr.isEmpty() || AadharStr.isEmpty() || panchayathStr.isEmpty() || WardStr.isEmpty() || kudumbasreeidStr.isEmpty()
                || spinStr.isEmpty() || placeStr.isEmpty()){

                    Toast.makeText(registrationpage.this, "Please enter all details", Toast.LENGTH_SHORT).show();

                }
                else{
                    fAuth.createUserWithEmailAndPassword(emailStr,passwordStr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                          if (task.isSuccessful()){
                              databaseReference.child("President").addListenerForSingleValueEvent(new ValueEventListener() {
                                  @Override
                                  public void onDataChange(@NonNull DataSnapshot snapshot) {
                                      databaseReference.child("President").child(kudumbasreeidStr).child("Kid").setValue(kudumbasreeidStr);
                                      databaseReference.child("President").child(kudumbasreeidStr).child("Name").setValue(nameStr);
                                      databaseReference.child("President").child(kudumbasreeidStr).child("EmailId").setValue(emailStr);
                                      databaseReference.child("President").child(kudumbasreeidStr).child("PhoneNo").setValue(phonenumberStr);
                                      databaseReference.child("President").child(kudumbasreeidStr).child("DOB").setValue(Dobstr);
                                      databaseReference.child("President").child(kudumbasreeidStr).child("Address").setValue(addressStr);
                                      databaseReference.child("President").child(kudumbasreeidStr).child("Password").setValue(passwordStr);
                                      // databaseReference.child("President").child(kudumbasreeidStr).child("ConfirmPassword").setValue(CpasswordStr);
                                      databaseReference.child("President").child(kudumbasreeidStr).child("AAdharId").setValue(AadharStr);
                                      databaseReference.child("President").child(kudumbasreeidStr).child("KudumbasreeName").setValue(kudumbasreenameStr);
                                      databaseReference.child("President").child(kudumbasreeidStr).child("District").setValue(item_position);
                                      databaseReference.child("President").child(kudumbasreeidStr).child("Panchayath").setValue(panchayathStr);
                                      databaseReference.child("President").child(kudumbasreeidStr).child("WardNo").setValue(WardStr);
                                      databaseReference.child("President").child(kudumbasreeidStr).child("Place").setValue(placeStr);

                                      builder.setMessage("Your are suceessfully registrated")
                                              .setCancelable(false)
                                              .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                  @Override
                                                  public void onClick(DialogInterface dialogInterface, int i) {
                                                      Intent ilog = new Intent(registrationpage.this, LoginPage.class);
                                                      startActivity(ilog);
                                                  }
                                              });
                                      AlertDialog alert = builder.create();
                                      alert.setTitle("Information registered");
                                      alert.show();



                                  }

                                  @Override
                                  public void onCancelled(@NonNull DatabaseError error) {
                                      Toast.makeText(registrationpage.this, "Error"+error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                                  }
                              });



                          }



                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(registrationpage.this, "Error"+e.getMessage().toString(), Toast.LENGTH_SHORT).show();

                        }
                    });

                }




              //  Intent intent = new Intent(registrationpage.this, LoginPage.class);
               // startActivity(intent);


            }

            private boolean validateinfo(String emailStr, String phonenumberStr, String aadharStr, String kudumbasreeidStr) {
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
                }else if(!phonenumberStr.matches("^[0-9]{10,13}")){
                    phoneNumber.requestFocus();
                    phoneNumber.setError("correct format: xxxxxxxxxx");
                    return false;
                }

                else{
                    return true;

                }
                return false;
            }
        });

        spin.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, district);
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