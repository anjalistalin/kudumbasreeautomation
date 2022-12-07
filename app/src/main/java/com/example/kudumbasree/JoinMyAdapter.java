package com.example.kudumbasree;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class JoinMyAdapter extends RecyclerView.Adapter<JoinMyAdapter.MyViewholder> {
   JoinKudumbasree context;
    ArrayList<JoinModelClass> list;
    DatabaseReference databaseReference;

    public JoinMyAdapter(JoinKudumbasree context, ArrayList<JoinModelClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.joinrequestlayout,parent,false);
        return new MyViewholder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        JoinModelClass joinModelClass=list.get(position);
        holder.Kname.setText(joinModelClass.getKudumbasreeName());
        holder.Ward.setText(joinModelClass.getWardNo());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void filterdList(ArrayList<JoinModelClass> filteredlist) {
        list = filteredlist;
        notifyDataSetChanged();

    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView Kname,Ward;
        Button Requestjoin;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            Kname= itemView.findViewById(R.id.itemkname);
            Ward=itemView.findViewById(R.id.itemward);
            Requestjoin=itemView.findViewById(R.id.requestjoin);
        }
    }
}
