package com.example.kudumbasree;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MemberlistMyAdapter extends RecyclerView.Adapter<MemberlistMyAdapter.MyViewholder> {
    MemberList context;
    ArrayList<MemberlistModelClass> list;

    public MemberlistMyAdapter(MemberList context, ArrayList<MemberlistModelClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.memberitem, parent, false);
        return new MemberlistMyAdapter.MyViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        MemberlistModelClass memberlistModelClass=list.get(position);
        holder.Name.setText(memberlistModelClass.getName());
        holder.Phoneno.setText(memberlistModelClass.getPhoneNo());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView Name,Phoneno;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.name);
            Phoneno=itemView.findViewById(R.id.phoneno);
        }
    }
}
