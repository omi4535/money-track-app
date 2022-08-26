package com.example.note;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText title, amount;
    Button submit,show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.title);
        amount = findViewById(R.id.amount);
        submit = findViewById(R.id.submitbtn);
        show = findViewById(R.id.show);

        database_helper db_helper = com.example.note.database_helper.getdb(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amt = Double.parseDouble( amount.getText().toString());
                db_helper.e_dao().insert( new expenses(title.getText().toString(),amt));


                ArrayList<expenses> list = (ArrayList<expenses>) db_helper.e_dao().getallexpense();

                Toast.makeText(MainActivity.this,""+list.size(),Toast.LENGTH_SHORT).show();
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,show_data_Act.class);
            startActivity(intent);

            }
        });
    }
}