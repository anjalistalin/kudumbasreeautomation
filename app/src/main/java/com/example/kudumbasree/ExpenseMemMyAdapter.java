package com.example.kudumbasree;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExpenseMemMyAdapter extends RecyclerView.Adapter<ExpenseMemMyAdapter.MyViewholder> {
    ExpenseViewByMember context;
    ArrayList<ExpenseMemModelClass> list;

    public ExpenseMemMyAdapter(ExpenseViewByMember context, ArrayList<ExpenseMemModelClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.expensememrecycle,parent,false);
       return new MyViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

        ExpenseMemModelClass expenseMemModelClass = list.get(position);
        holder.Kudumbasreeid.setText(expenseMemModelClass.getKudumbasreeid());
        holder.Reason.setText(expenseMemModelClass.getReason());
        holder.Amount.setText(expenseMemModelClass.getAmount());
        holder.Date.setText(expenseMemModelClass.getDate());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {

        TextView Kudumbasreeid,Reason,Amount,Date;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            Kudumbasreeid = itemView.findViewById(R.id.kid);
            Reason = itemView.findViewById(R.id.reason);
            Amount = itemView.findViewById(R.id.amount);
            Date = itemView.findViewById(R.id.date);
        }
    }
}
