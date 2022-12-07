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

public class RequestMyAdapter extends RecyclerView.Adapter<RequestMyAdapter.MyViewholder> {
    RequestList context;
    ArrayList<RequestModelClass> list;
    DatabaseReference databaseReference,databaseReference1;


    public RequestMyAdapter(RequestList context, ArrayList<RequestModelClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.requestlist, parent, false);
        return new RequestMyAdapter.MyViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        RequestModelClass requestModelClass=list.get(position);
        holder.Name.setText(requestModelClass.getName());
        holder.EmailId.setText(requestModelClass.getEmailId());
        holder.Phoneno.setText(requestModelClass.getPhoneno());
        databaseReference= FirebaseDatabase.getInstance().getReference("UnitMember");
        databaseReference1= FirebaseDatabase.getInstance().getReference("RequestTable");
        holder.Accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameStr=holder.Name.getText().toString();
                String emailStr=holder.EmailId.getText().toString();
                String phonenoStr=holder.Phoneno.getText().toString();

                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.child(phonenoStr).child("Name").setValue(nameStr);
                        databaseReference.child(phonenoStr).child("EmailId").setValue(emailStr);
                        databaseReference.child(phonenoStr).child("Phoneno").setValue(phonenoStr);

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
                String nameStr=holder.Name.getText().toString();
                String emailStr=holder.EmailId.getText().toString();
                String phonenoStr=holder.Phoneno.getText().toString();

                Query applesQuery = databaseReference1.orderByChild("Phoneno").equalTo(phonenoStr);
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

                //list.remove(position);

            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView Name,EmailId,Phoneno;
        Button Accept,Reject;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.name);
            EmailId=itemView.findViewById(R.id.emailid);
            Phoneno=itemView.findViewById(R.id.phoneno);
       //     Dob=itemView.findViewById(R.id.dob);
      //      Address=itemView.findViewById(R.id.address);
            Accept=itemView.findViewById(R.id.accept);
            Reject=itemView.findViewById(R.id.reject);
        }
    }

}
