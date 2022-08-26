package com.example.note;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class view_holder extends RecyclerView.ViewHolder {

    public TextView tile,amount;
    public view_holder(@NonNull View itemView) {
        super(itemView);
        tile = itemView.findViewById(R.id.title_card_design);
        amount = itemView.findViewById(R.id.amount_card_design);


    }

}
