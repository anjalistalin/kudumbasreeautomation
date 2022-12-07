package com.example.kudumbasree;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class PaymentinfoAdapter extends RecyclerView.Adapter<PaymentinfoAdapter.MyViewholder> {
    PaymentInfo context;
    ArrayList<PayinfoModelClass> list;

    public PaymentinfoAdapter(PaymentInfo context, ArrayList<PayinfoModelClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.paymentitem,parent,false);
        return new PaymentinfoAdapter.MyViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        PayinfoModelClass payinfoModelClass=list.get(position);
        holder.Loanid.setText(payinfoModelClass.getLoanid());
        holder.Installmentno.setText(payinfoModelClass.getInstallmentNo());
        holder.Payamount.setText(payinfoModelClass.getPayAmount());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView Loanid,Installmentno,Payamount;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            Loanid=itemView.findViewById(R.id.loanid);
            Installmentno=itemView.findViewById(R.id.installmentnol);
            Payamount=itemView.findViewById(R.id.payamount);
        }
    }
}
