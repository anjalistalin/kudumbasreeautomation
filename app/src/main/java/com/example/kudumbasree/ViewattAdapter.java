package com.example.kudumbasree;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewattAdapter extends RecyclerView.Adapter<ViewattAdapter.MyViewholder> {
    viewattendance context;
    ArrayList<String> list;

    public ViewattAdapter(viewattendance context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.attendance, parent, false);
        return new ViewattAdapter.MyViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
      //  ViewattModelClass viewattModelClass=list.get(position);
      //  holder.Name.setText(viewattModelClass.getPresent());
         String Person=list.get(position);
        holder.Name.setText(Person);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView Name;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.name);
        }
    }
}

