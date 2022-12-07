package com.example.kudumbasree;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchmemMyAdapter extends RecyclerView.Adapter<SearchmemMyAdapter.MyViewholder> {
    Context context;
    ArrayList<EmployeememModelClass> list;

    public SearchmemMyAdapter(Context context, ArrayList<EmployeememModelClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.searchmemitemlayout,parent,false);
        return new SearchmemMyAdapter.MyViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        EmployeememModelClass employeememModelClass=list.get(position);
        holder.Name.setText(employeememModelClass.getName());
        holder.Phoneno.setText(employeememModelClass.getPhoneno());

    }

    @Override
    public int getItemCount() {return list.size();}
    public void filterList(ArrayList<EmployeememModelClass>filterlist){
        list=filterlist;
        notifyDataSetChanged();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView Name,Phoneno;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            Name= itemView.findViewById(R.id.name);
            Phoneno=itemView.findViewById(R.id.phoneno);

        }
    }
}
