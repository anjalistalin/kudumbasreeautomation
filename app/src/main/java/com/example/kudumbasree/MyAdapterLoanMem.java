package com.example.kudumbasree;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapterLoanMem extends RecyclerView.Adapter<MyAdapterLoanMem.MyViewholder> {

    LoanDetails context;
    ArrayList<LoanMem> list;

    public MyAdapterLoanMem(LoanDetails context, ArrayList<LoanMem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.loanmemitem,parent,false);
        return new MyViewholder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

        LoanMem loanmem=list.get(position);
        holder.Loanname.setText(loanmem.getLoanName());
        holder.Loanid.setText(loanmem.getLoanId());
        holder.Category.setText(loanmem.getCategory());
        holder.Amount.setText(loanmem.getAmount());
        holder.Permonth.setText(loanmem.getPermonth());
        holder.Period.setText(loanmem.getPeriod());
        holder.Interest.setText(loanmem.getInterest());
        holder.Lastdate.setText(loanmem.getLastDate());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {

        TextView Loanname,Loanid,Category,Amount,Permonth,Period,Interest,Lastdate;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            Loanname=itemView.findViewById(R.id.loanname);
            Loanid=itemView.findViewById(R.id.loanid);
            Category=itemView.findViewById(R.id.category);
            Amount=itemView.findViewById(R.id.amount);
            Permonth=itemView.findViewById(R.id.permonth);
            Period=itemView.findViewById(R.id.period);
            Interest=itemView.findViewById(R.id.interest);
            Lastdate=itemView.findViewById(R.id.lastdate);

        }
    }
}
