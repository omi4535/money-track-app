package com.example.ttt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count =0;
    int flag = 0;
    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        find_view_id();
    }
    private void find_view_id(){
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt6 = findViewById(R.id.bt6);
        bt7 = findViewById(R.id.bt7);
        bt8 = findViewById(R.id.bt8);
        bt9 = findViewById(R.id.bt9);
    }
    public  void  cheak(View view){
        Button btncurrent = (Button) view;
        if(btncurrent.getText().toString().equals("")) {
            if (btncurrent.getText().toString().equals("")) {
                count++;
                if (flag == 0) {
                    btncurrent.setText("X");
                    flag = 1;
                } else if (flag == 1) {
                    btncurrent.setText("O");
                    flag = 0;
                }

                if (count >= 4) {
                    String winner;
                    b1 = bt1.getText().toString();
                    b2 = bt2.getText().toString();
                    b3 = bt3.getText().toString();
                    b4 = bt4.getText().toString();
                    b5 = bt5.getText().toString();
                    b6 = bt6.getText().toString();
                    b7 = bt7.getText().toString();
                    b8 = bt8.getText().toString();
                    b9 = bt9.getText().toString();
                    textView = findViewById(R.id.tv1);
                    if ((b1.equals(b2) && b1.equals(b3) && !b1.equals("")) ||
                            (b2.equals(b5) && b2.equals(b8) && !b1.equals("")) ||
                            (b3.equals(b6) && b3.equals(b9) && !b3.equals("")) ||
                            (b1.equals(b5) && b1.equals(b9) && !b1.equals("")) ||
                            (b1.equals(b4) && b1.equals(b7) && !b1.equals("")) ||
                            (b4.equals(b5) && b4.equals(b6) && !b4.equals("")) ||
                            (b7.equals(b8) && b7.equals(b9) && !b7.equals("")) ||
                            (b3.equals(b5) && b3.equals(b7) && !b3.equals(""))
                    ) {
                        if (flag == 0) {
                            winner = "O";

                            textView.setText("The winner is " + winner);

                        } else {
                            winner = "X";
                            textView.setText("The winner is " + winner);
                        }

                    } else if (count == 9) {
                        textView.setText("this game is tie !!!! :)");
                    }
                }

            }

        }
    }
}