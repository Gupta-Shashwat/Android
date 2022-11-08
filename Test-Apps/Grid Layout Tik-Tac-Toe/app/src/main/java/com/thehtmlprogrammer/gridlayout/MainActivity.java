package com.thehtmlprogrammer.gridlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    AppCompatButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnRestart;
    String turn = "X", t1, t2, t3, t4, t5, t6, t7, t8, t9, result;
    int count = 0;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnRestart = findViewById(R.id.btnRestart);
        tvResult = findViewById(R.id.tvResult);
        result = turn + "'s turn";
        tvResult.setText(result);

        btn1.setOnClickListener(v -> clicked(btn1));
        btn2.setOnClickListener(v -> clicked(btn2));
        btn3.setOnClickListener(v -> clicked(btn3));
        btn4.setOnClickListener(v -> clicked(btn4));
        btn5.setOnClickListener(v -> clicked(btn5));
        btn6.setOnClickListener(v -> clicked(btn6));
        btn7.setOnClickListener(v -> clicked(btn7));
        btn8.setOnClickListener(v -> clicked(btn8));
        btn9.setOnClickListener(v -> clicked(btn9));
        btnRestart.setOnClickListener(v -> restart());
    }

    void changeTurn() {
        if (turn.equals("X"))
            turn = "O";
        else
            turn = "X";
    }

    void checkWin() {
        t1 = btn1.getText().toString();
        t2 = btn2.getText().toString();
        t3 = btn3.getText().toString();
        t4 = btn4.getText().toString();
        t5 = btn5.getText().toString();
        t6 = btn6.getText().toString();
        t7 = btn7.getText().toString();
        t8 = btn8.getText().toString();
        t9 = btn9.getText().toString();

        if (t1.equals(t2) && t2.equals(t3) && !t1.isEmpty()) {
            changeTurn();
            result = turn + " Wins";
            tvResult.setText(result);
        } else if (t4.equals(t5) && t5.equals(t6) && !t4.isEmpty()){
            changeTurn();
            result = turn + " Wins";
            tvResult.setText(result);
        } else if (t7.equals(t8) && t8.equals(t9) && !t7.isEmpty()){
            changeTurn();
            result = turn + " Wins";
            tvResult.setText(result);
        } else if (t1.equals(t4) && t4.equals(t7) && !t1.isEmpty()){
            changeTurn();
            result = turn + " Wins";
            tvResult.setText(result);
        } else if (t2.equals(t5) && t5.equals(t8) && !t2.isEmpty()){
            changeTurn();
            result = turn + " Wins";
            tvResult.setText(result);
        } else if (t3.equals(t6) && t6.equals(t9) && !t3.isEmpty()){
            changeTurn();
            result = turn + " Wins";
            tvResult.setText(result);
        } else if (t1.equals(t5) && t5.equals(t9) && !t1.isEmpty()){
            changeTurn();
            result = turn + " Wins";
            tvResult.setText(result);
        } else if (t3.equals(t5) && t5.equals(t7) && !t3.isEmpty()){
            changeTurn();
            result = turn + " Wins";
            tvResult.setText(result);
        } else if (count >= 9){
            result = "It's a draw!!!";
            tvResult.setText(result);
        }
    }

    void clear(Button btn) {
        btn.setText("");
    }

    void restart() {
        clear(btn1);
        clear(btn2);
        clear(btn3);
        clear(btn4);
        clear(btn5);
        clear(btn6);
        clear(btn7);
        clear(btn8);
        clear(btn9);
        turn = "X";
        result = turn + "'s turn";
        tvResult.setText(result);
        count = 0;
    }

    void clicked(Button b) {
        if (tvResult.getText().toString().equals("X Wins") || tvResult.getText().toString().equals("O Wins") || tvResult.getText().toString().equals("It's a draw!!!")) {
            restart();
            return;
        }
        if (b.getText().toString().isEmpty()) {
            count++;
            b.setText(turn);
            changeTurn();
            result = turn + "'s turn";
            tvResult.setText(result);
            if (count >= 5)
                checkWin();
        }
    }
}