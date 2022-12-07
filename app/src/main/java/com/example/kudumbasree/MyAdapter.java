package com.example.kudumbasree;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewholder> {

    JobAlertPresident context;
    ArrayList<JobModelClass> list;


    public MyAdapter(JobAlertPresident context, ArrayList<JobModelClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(context).inflate(R.layout.job, parent, false);
        return new MyViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

        JobModelClass jobmodelclass = list.get(position);
        holder.Jobcategory.setText(jobmodelclass.getJobCategory());
        holder.Venue.setText(jobmodelclass.getVenue());
        holder.Interviewdate.setText(jobmodelclass.getInterviewDate());
        holder.Time.setText(jobmodelclass.getTime());
        holder.Education.setText(jobmodelclass.getEducation());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewholder extends RecyclerView.ViewHolder{
        TextView Jobcategory,Venue,Interviewdate,Time,Education;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            Jobcategory = itemView.findViewById(R.id.jobcategory);
            Venue = itemView.findViewById(R.id.venue);
            Interviewdate =itemView.findViewById(R.id.interviewdate);
            Time =itemView.findViewById(R.id.time);
            Education = itemView.findViewById(R.id.education);
        }
    }
}
