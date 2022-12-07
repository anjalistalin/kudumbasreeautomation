package com.example.kudumbasree;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotifyAdapter extends RecyclerView.Adapter<NotifyAdapter.MyViewholder> {
    Notificationxmljava context;
    ArrayList<NotifyModelClass> list;

    public NotifyAdapter(Notificationxmljava context, ArrayList<NotifyModelClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.notifyitem,parent,false);
        return new NotifyAdapter.MyViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        NotifyModelClass notifyModelClass=list.get(position);
        holder.MeetingId.setText(notifyModelClass.getMeetnigId());
        holder.MeetingTitle.setText(notifyModelClass.getMeetingTitle());
        holder.Date.setText(notifyModelClass.getDate());
        holder.Time.setText(notifyModelClass.getTime());
        holder.Particapants.setText(notifyModelClass.getParticipants());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView MeetingId,MeetingTitle,Date,Time,Particapants;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            MeetingId=itemView.findViewById(R.id.meetingid);
            MeetingTitle=itemView.findViewById(R.id.meeetingtitle);
            Date=itemView.findViewById(R.id.date);
            Time=itemView.findViewById(R.id.time);
            Particapants=itemView.findViewById(R.id.participants);




        }
    }
}
