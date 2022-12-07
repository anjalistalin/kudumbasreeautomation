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
 * Use the {@link profilemem#newInstance} factory method to
 * create an instance of this fragment.
 */
public class profilemem extends Fragment {
    DatabaseReference databaseReference;
    TextView Emailid, Phoneno, Address, Aadharid, DOB;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public profilemem() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment profilemem.
     */
    // TODO: Rename and change types and number of parameters
    public static profilemem newInstance(String param1, String param2) {
        profilemem fragment = new profilemem();
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
        View v = inflater.inflate(R.layout.fragment_profilemem, container, false);
        Emailid = v.findViewById(R.id.emailmem);
        Phoneno = v.findViewById(R.id.phonemem);
     //   Address = v.findViewById(R.id.addressmem);
        DOB = v.findViewById(R.id.dobmem);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("UnitMember");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    String emailidStr = snapshot1.child("EmailId").getValue().toString();
                    String phonenoStr = snapshot1.child("Phoneno").getValue().toString();
              //      String addressStr = snapshot1.child("Address").getValue().toString();

                    String dobStr = snapshot1.child("DOB").getValue().toString();

                    Emailid.setText(emailidStr);
                    Phoneno.setText(phonenoStr);
             //       Address.setText(addressStr);
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
