package com.example.kudumbasree;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExpenseMyAdapter extends RecyclerView.Adapter<ExpenseMyAdapter.MyViewHolder>{
    ExpenseViewBYADS context;
    ArrayList<ExpenseModelClass> list;

    public ExpenseMyAdapter(ExpenseViewBYADS context, ArrayList<ExpenseModelClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.expenserecycle,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseMyAdapter.MyViewHolder holder, int position) {

        ExpenseModelClass expenseModelClass = list.get(position);
        holder.Kudumbasreeid.setText(expenseModelClass.getKudumbasreeid());
        holder.Reason.setText(expenseModelClass.getReason());
        holder.Amount.setText(expenseModelClass.getAmount());
        holder.Date.setText(expenseModelClass.getDate());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView Kudumbasreeid,Reason,Amount,Date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Kudumbasreeid = itemView.findViewById(R.id.kid);
            Reason = itemView.findViewById(R.id.reason);
            Amount = itemView.findViewById(R.id.amount);
            Date = itemView.findViewById(R.id.date);

        }
    }
}
