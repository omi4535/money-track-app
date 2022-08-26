package com.example.note;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class show_data_Act extends AppCompatActivity {
    TextView text;
    RecyclerView recyclerView;
    adapter a;
    database_helper db_helper = com.example.note.database_helper.getdb(this);
    ArrayList<expenses> list = (ArrayList<expenses>) db_helper.e_dao().getallexpense();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);


        text = findViewById(R.id.show_data_textview);
        recyclerView = findViewById(R.id.recyclerView2);





        recyclerView.setLayoutManager(new LinearLayoutManager(this));

         a = new adapter(this,list);
        recyclerView.setAdapter(a);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);





    }
    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,
            ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getAdapterPosition();
            switch (direction)
            {
                case ItemTouchHelper.LEFT:
                    list.remove(position);
                    db_helper.e_dao().delete(a.getexpense(position));
                    a.notifyDataSetChanged();


                    break;
                case ItemTouchHelper.RIGHT:

                    break;
            }
        }
    };
}