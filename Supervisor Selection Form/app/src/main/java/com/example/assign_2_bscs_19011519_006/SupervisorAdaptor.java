package com.example.assign_2_bscs_19011519_006;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SupervisorAdaptor extends RecyclerView.Adapter<SupervisorAdaptor.myViewHolder>{

    ArrayList<SupervisorModel> dataHolder;
    TextView sname,fname,regno, syno1, summ1, sign1, syno2, summ2, sign2, syno3, summ3, sign3;
    DBHelper2 DB;

    public SupervisorAdaptor(ArrayList<SupervisorModel> dataHolder) {
        this.dataHolder = dataHolder;
    }

    @NonNull
    @Override
    // convert xml to view
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.supervisoradaptor,parent,false);
        return new myViewHolder(view);
    }

    @Override
    //set data in arraylist through references
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.sname.setText(dataHolder.get(position).getStudentName());
        holder.fname.setText(dataHolder.get(position).getFatherName());
        holder.regno.setText(dataHolder.get(position).getRegistrationNo());
        holder.syno1.setText(dataHolder.get(position).getSynop1());
        holder.summ1.setText(dataHolder.get(position).getSumm1());
        holder.sign1.setText(dataHolder.get(position).getSign1());
        holder.syno2.setText(dataHolder.get(position).getSynop2());
        holder.summ2.setText(dataHolder.get(position).getSumm2());
        holder.sign2.setText(dataHolder.get(position).getSign2());
        holder.syno3.setText(dataHolder.get(position).getSynop3());
        holder.summ3.setText(dataHolder.get(position).getSumm3());
        holder.sign3.setText(dataHolder.get(position).getSign3());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder
    {
        TextView sname,fname,regno, syno1, summ1, sign1, syno2, summ2, sign2, syno3, summ3, sign3;
        public myViewHolder(@NonNull View itemView)
        {
            super(itemView);
            sname=itemView.findViewById(R.id.studentName);
            fname=itemView.findViewById(R.id.fatherName);
            regno=itemView.findViewById(R.id.registrationNo);
            syno1=itemView.findViewById(R.id.synop1);
            summ1=itemView.findViewById(R.id.Summ1);
            sign1=itemView.findViewById(R.id.SupSign1);
            syno2=itemView.findViewById(R.id.Synop2);
            summ2=itemView.findViewById(R.id.Summ2);
            sign2=itemView.findViewById(R.id.SupSign2);
            syno3=itemView.findViewById(R.id.Synop3);
            summ3=itemView.findViewById(R.id.Summ3);
            sign3=itemView.findViewById(R.id.SupSign3);
        }
    }
}
