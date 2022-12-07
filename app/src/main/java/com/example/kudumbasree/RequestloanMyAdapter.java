package com.example.kudumbasree;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RequestloanMyAdapter extends RecyclerView.Adapter<RequestloanMyAdapter.MyViewholder> {
    Requestloan context;
    ArrayList<RequestloanModelClass> list;
    DatabaseReference databaseReference,databaseReference1;

    public RequestloanMyAdapter(Requestloan context, ArrayList<RequestloanModelClass> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.requestloan, parent, false);
        return new RequestloanMyAdapter.MyViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        RequestloanModelClass requestloanModelClass=list.get(position);
        holder.Unitname.setText(requestloanModelClass.getUnitName());
        holder.Unitid.setText(requestloanModelClass.getUnitId());
        holder.Totalamount.setText(requestloanModelClass.getTotalAmount());
        holder.Memberno.setText(requestloanModelClass.getMemno());

        databaseReference= FirebaseDatabase.getInstance().getReference("RequestLoan");
        databaseReference1= FirebaseDatabase.getInstance().getReference("LoanRequest");
        holder.Accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String unitnameStr=holder.Unitname.getText().toString();
                String unitidStr=holder.Unitid.getText().toString();
                String membernoStr=holder.Memberno.getText().toString();
                String totalamountStr=holder.Totalamount.getText().toString();

                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.child(unitidStr).child("UnitName").setValue(unitnameStr);
                        databaseReference.child(unitidStr).child("UnitId").setValue(unitidStr);
                        databaseReference.child(unitidStr).child("Memno").setValue(membernoStr);
                        databaseReference.child(unitidStr).child("TotalAmount").setValue(totalamountStr);


                        Toast.makeText(context, "Request accepted", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
        holder.Reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String unitnameStr=holder.Unitname.getText().toString();
                String unitidStr=holder.Unitid.getText().toString();
                String membernoStr=holder.Memberno.getText().toString();
                String totalamountStr=holder.Totalamount.getText().toString();

                Query applesQuery = databaseReference1.orderByChild("UnitId").equalTo(unitidStr);
                applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot appleSnapshot: snapshot.getChildren()) {
                            appleSnapshot.getRef().removeValue();
                        }
                        Toast.makeText(context.getApplication(), "Deleted",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


                }

            });
        }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView Unitname,Unitid,Totalamount,Memberno;
        Button Accept,Reject;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            Unitname=itemView.findViewById(R.id.unitname);
            Unitid=itemView.findViewById(R.id.unitid);
            Memberno=itemView.findViewById(R.id.memberno);
            Totalamount=itemView.findViewById(R.id.totalamount);
            Accept=itemView.findViewById(R.id.accept);
            Reject=itemView.findViewById(R.id.reject);
        }
    }
}
