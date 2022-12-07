package com.example.kudumbasree;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapterMem extends RecyclerView.Adapter<MyAdapterMem.MyViewholder> {

    jobalertm context;
    ArrayList<JobModelClassMem> list;

    public MyAdapterMem(jobalertm context, ArrayList<JobModelClassMem> list) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapterMem.MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.jobmem, parent, false);
        return new MyViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterMem.MyViewholder holder, int position) {
        JobModelClassMem jobmodelclassmem = list.get(position);
        holder.Jobcategory.setText(jobmodelclassmem.getJobcategory());
        holder.Venue.setText(jobmodelclassmem.getVenue());
        holder.Interviewdate.setText(jobmodelclassmem.getInterviewDate());
        holder.Time.setText(jobmodelclassmem.getTime());
        holder.Education.setText(jobmodelclassmem.getEducation());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {

        TextView Jobcategory,Venue,Interviewdate,Time,Education;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            Jobcategory = itemView.findViewById(R.id.jobcategory);
            Venue = itemView.findViewById(R.id.venue);
            Interviewdate = itemView.findViewById(R.id.interviewdate);
            Time = itemView.findViewById(R.id.time);
            Education = itemView.findViewById(R.id.education);
        }
    }
}

