package com.example.kudumbasree;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link profile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class profile extends Fragment {

    DatabaseReference databaseReference;
    TextView Emailid, Phoneno, Address, Panchayath, Aadharid, DOB;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public profile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment profile.
     */
    // TODO: Rename and change types and number of parameters
    public static profile newInstance(String param1, String param2) {
        profile fragment = new profile();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        Emailid = v.findViewById(R.id.emailprof);
        Phoneno = v.findViewById(R.id.phoneprof);
        Address = v.findViewById(R.id.addressprof);
        Panchayath = v.findViewById(R.id.panchayathprof);
        Aadharid = v.findViewById(R.id.aadharprof);
        DOB = v.findViewById(R.id.dobprof);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("President");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    String emailidStr = snapshot1.child("EmailId").getValue().toString();
                    String phonenoStr = snapshot1.child("PhoneNo").getValue().toString();
                    String addressStr = snapshot1.child("Address").getValue().toString();
                    String panchayathStr = snapshot1.child("Panchayath").getValue().toString();
                    String aadharStr = snapshot1.child("AAdharId").getValue().toString();
                    String dobStr = snapshot1.child("DOB").getValue().toString();

                    Emailid.setText(emailidStr);
                    Phoneno.setText(phonenoStr);
                    Address.setText(addressStr);
                    Panchayath.setText(panchayathStr);
                    Aadharid.setText(aadharStr);
                    DOB.setText(dobStr);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });
        return v;
    }
}