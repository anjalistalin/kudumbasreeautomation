package com.example.kudumbasree;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link homemem#newInstance} factory method to
 * create an instance of this fragment.
 */
public class homemem extends Fragment {
    Button AttendanceView;
    TextView  Emailid,Name,PhoneNo;
    DatabaseReference databaseReference;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public homemem() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment homemem.
     */
    // TODO: Rename and change types and number of parameters
    public static homemem newInstance(String param1, String param2) {
        homemem fragment = new homemem();
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
        View v = inflater.inflate(R.layout.fragment_homemem, container, false);
        AttendanceView = v.findViewById(R.id.attendanceview);

        Name = v.findViewById(R.id.name);
        PhoneNo = v.findViewById(R.id.phone);
        Emailid =v.findViewById(R.id.email);

        AttendanceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), atviewbymem.class);
                startActivity(intent);
            }
        });
        databaseReference = FirebaseDatabase.getInstance().getReference().child("UnitMember");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    String nameStr = snapshot1.child("Name").getValue().toString();
                    String phonenoStr = snapshot1.child("Phoneno").getValue().toString();
                    String emailStr = snapshot1.child("EmailId").getValue().toString();

                    Name.setText(nameStr);
                    PhoneNo.setText(phonenoStr);
                    Emailid.setText(emailStr);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        return v;
    }
}