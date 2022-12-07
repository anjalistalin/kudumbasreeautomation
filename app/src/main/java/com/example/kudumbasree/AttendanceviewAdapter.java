package com.example.kudumbasree;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AttendanceviewAdapter extends RecyclerView.Adapter<AttendanceviewAdapter.MyViewholder> {
    viewattendance context;
    ArrayList<AttendanceviewModelClass> list;

    public AttendanceviewAdapter(viewattendance context, ArrayList<AttendanceviewModelClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.attendance, parent, false);
        return new AttendanceviewAdapter.MyViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        AttendanceviewModelClass attendanceviewModelClass = list.get(position);
        holder.Name.setText(attendanceviewModelClass.getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView Name;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
