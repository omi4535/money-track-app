package com.example.note;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<view_holder>{

    private Context context;
    private ArrayList<expenses> list;

    adapter(Context context,ArrayList<expenses> list)
    {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new view_holder(LayoutInflater.from(context).inflate(R.layout.design_card,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull view_holder holder, int position) {
        holder.amount.setText(""+list.get(position).getAmount());
        holder.tile.setText(""+list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public expenses getexpense(int i)
    {
        return list.get(i);
    }
}
