package com.example.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText hfeet,hinches,weight;
        Button cal ;
        TextView result ;
        hfeet = findViewById(R.id.height);
        hinches = findViewById(R.id.hinches);
        weight = findViewById(R.id.weight);
        cal = findViewById(R.id.cal);
        result = findViewById(R.id.result);

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hf = Integer.parseInt(hfeet.getText().toString());
                int hi = Integer.parseInt(hinches.getText().toString());
                double thm= ((hf*30) + (hi*2.5))/100;
                int wkg = Integer.parseInt(weight.getText().toString());
                double bmi = wkg/(thm*thm);
                if(bmi>25)
                    result.setText("you are over weight");
                else if(bmi<18)
                    result.setText("you are under weight");
                else
                    result.setText("you are fit!!!!!");


            }
        });
    }
}