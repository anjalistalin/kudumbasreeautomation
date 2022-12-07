package com.example.kudumbasree;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchMyAdapter extends RecyclerView.Adapter<SearchMyAdapter.MyViewholder> {
    Context context;
    ArrayList<Employee> list;

    public SearchMyAdapter(Context context, ArrayList<Employee> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.searchitemlayout,parent,false);
        return new MyViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        Employee employee=list.get(position);
        holder.Kudumbasreename.setText(employee.getKudumbasreeName());
        holder.Name.setText(employee.getName());
        holder.Phoneno.setText(employee.getPhoneNo());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void filterList(ArrayList<Employee>filterList){
     list=filterList;
     notifyDataSetChanged();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView Kudumbasreename,Name,Phoneno;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            Kudumbasreename= itemView.findViewById(R.id.kudumbasreename);
            Name= itemView.findViewById(R.id.name);
            Phoneno=itemView.findViewById(R.id.phoneno);
        }
    }
}
