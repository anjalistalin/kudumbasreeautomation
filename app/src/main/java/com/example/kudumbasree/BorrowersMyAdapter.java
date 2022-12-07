package com.example.kudumbasree;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BorrowersMyAdapter extends RecyclerView.Adapter<BorrowersMyAdapter.MyViewholder> {

    BorrowersList context;
    ArrayList<BorrowersModelClass> list;
    DatabaseReference databaseReference;

    public BorrowersMyAdapter(BorrowersList context, ArrayList<BorrowersModelClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v= LayoutInflater.from(context).inflate(R.layout.borrowersitem,parent,false);
      return new MyViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        BorrowersModelClass borrowersModelClass = list.get(position);
        holder.Loanname.setText(borrowersModelClass.getLoanName());
        holder.Loanid.setText(borrowersModelClass.getLoanid());
        holder.Loanamount.setText(borrowersModelClass.getLoanAmount());
        holder.Payamount.setText(borrowersModelClass.getPayAmount());
        holder.Instlmentno.setText(borrowersModelClass.getInstallmentNo());
        databaseReference= FirebaseDatabase.getInstance().getReference("PayLoan");
        holder.Closeloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loannameStr=holder.Loanname.getText().toString();
                String loanidStr=holder.Loanid.getText().toString();
                String loanamountStr=holder.Loanamount.getText().toString();
                String payamountStr=holder.Payamount.getText().toString();
                Query applesQuery = databaseReference.orderByChild("Loanid").equalTo(loanidStr);
                applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot appleSnapshot: snapshot.getChildren()) {
                            appleSnapshot.getRef().removeValue();
                        }
                        Toast.makeText(context.getApplication(), "Deleted",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


                }
            });

   /*     holder.Closeloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(view.getRootView().getContext());
                builder.setMessage("Do you want to close the loan").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(BorrowersMyAdapter.this,LoanForADS.class);
                        intent.putExtra("module")
                    }
                })
            }
        }); */
     /*   holder.Closeloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loannameStr=holder.Loanname.getText().toString();
                String loanidStr=holder.Loanid.getText().toString();
                String loanamountStr=holder.Loanamount.getText().toString();
                String payamountStr=holder.Payamount.getText().toString();
                Query applesQuery = databaseReference.orderByChild("Phoneno").equalTo(phonenoStr);
                applesQuery.addListenerForSingleValueEvent(new ValueEventListen




            }
        }); */

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView Loanname,Loanid,Loanamount,Payamount,Instlmentno;
        Button Closeloan;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            Loanname = itemView.findViewById(R.id.loanname);
            Loanid = itemView.findViewById(R.id.loanid);
            Loanamount = itemView.findViewById(R.id.loanamount);
            Payamount = itemView.findViewById(R.id.payamount);
            Instlmentno=itemView.findViewById(R.id.installmentno);
          Closeloan = itemView.findViewById(R.id.closeloan);
        }
    }
}
