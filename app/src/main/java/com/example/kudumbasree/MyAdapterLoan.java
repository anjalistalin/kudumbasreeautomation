package com.example.kudumbasree;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.core.Context;

import java.util.ArrayList;

public class MyAdapterLoan extends RecyclerView.Adapter<MyAdapterLoan.MyViewholder> {

    Loanlist context;
    ArrayList<LoanPresident> list;

    public MyAdapterLoan(Loanlist context, ArrayList<LoanPresident> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.loanitem, parent, false);
        return new MyViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

        LoanPresident loanpresident=list.get(position);
        holder.Loanname.setText(loanpresident.getLoanName());
        holder.Loanid.setText(loanpresident.getLoanId());
        holder.Category.setText(loanpresident.getCategory());
        holder.Amount.setText(loanpresident.getAmount());
        holder.Permonth.setText(loanpresident.getPermonth());
        holder.Period.setText(loanpresident.getPeriod());
        holder.Interest.setText(loanpresident.getInterest());
        holder.Lastdate.setText(loanpresident.getLastDate());
        String loanidStr=holder.Loanid.getText().toString();
        String loannameStr=holder.Loanname.getText().toString();
    //    String lastdateStr2=loanpresident.getLastDate().toString();
        holder.Apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),ApplyLoan.class);
                intent.putExtra("Loanid",loanidStr);
                intent.putExtra("Loanname",loannameStr);
                view.getContext().startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewholder extends RecyclerView.ViewHolder{

        TextView Loanname,Loanid,Category,Amount,Permonth,Period,Interest,Lastdate;
        Button Apply;

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
            Apply=itemView.findViewById(R.id.applyloan);

        }
    }
}
