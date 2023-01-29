package com.example.hw_2_7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView textView, sum;
    private Integer first, second, operation;
    private Boolean isOperationClick, isNumberClick=false;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        findViewById(R.id.fl_btn).setVisibility(View.GONE);
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        findViewById(R.id.fl_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum = ((TextView)findViewById(R.id.text_view));
                intent.putExtra("sum", sum.getText().toString());
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("shamal", "first Destroy");
    }

    public void onNumberClick(View view) {
        if (isNumberClick){
            findViewById(R.id.fl_btn).setVisibility(View.GONE);
        }
        switch (view.getId()){
            case R.id.btn_zero:
                onClickNumber("0");
                break;
            case R.id.btn_one:
                onClickNumber("1");
                break;
            case R.id.btn_two:
                onClickNumber("2");
                break;
            case R.id.btn_three:
                onClickNumber("3");
                break;
            case R.id.btn_four:
                onClickNumber("4");
                break;
            case R.id.btn_five:
                onClickNumber("5");
                break;
            case R.id.btn_six:
                onClickNumber("6");
                break;
            case R.id.btn_seven:
                onClickNumber("7");
                break;
            case R.id.btn_eight:
                onClickNumber("8");
                break;
            case R.id.btn_nine:
                onClickNumber("9");
                break;
            case R.id.btn_point:

            case R.id.btn_ac:
                textView.setText("0");
                first=0;
                second=0;
                break;
        }
        isOperationClick=false;
        isNumberClick=true;
    }
    public void onClickNumber(String number){
        if (textView.getText().toString().equals("0") || isOperationClick){
            textView.setText(number);
        }
        else {
            textView.append(number);
        }
    }


    public void onOperationClick(View view) {
        switch (view.getId()){
            case R.id.btn_plus:
                firstNum();
                operation = R.id.btn_plus;
                break;
            case R.id.btn_minus:
                firstNum();
                operation = R.id.btn_minus;
                break;
            case R.id.btn_multiple:
                firstNum();
                operation = R.id.btn_multiple;
                break;
            case R.id.btn_division:
                firstNum();
                operation = R.id.btn_division;
                break;
            case R.id.btn_percent:
                    percent();
                    break;

            case R.id.btn_equal:
                switch (operation){
                    case R.id.btn_plus:
                        plus();
                        break;
                    case R.id.btn_minus:
                        minus();
                        break;
                    case R.id.btn_multiple:
                        multiple();
                        break;
                    case R.id.btn_division:
                        division();
                        break;
                }
                findViewById(R.id.fl_btn).setVisibility(View.VISIBLE);
                break;
        }
        isOperationClick=true;
    }
    public void minus() {
        secondNum();
        Integer result = first - second;
        textView.setText(result.toString());
    }
    public void plus() {
        secondNum();
        Integer result = first + second;
        textView.setText(result.toString());
    }
    public void multiple() {
        secondNum();
        Integer result = first * second;
        textView.setText(result.toString());
    }
    public void division() {
        secondNum();
        Integer result = first / second;
        textView.setText(result.toString());
    }
    public void percent(){
        first = Integer.valueOf(textView.getText().toString());
        Integer firstN = first;
        Double result = (double) firstN/100;
        textView.setText(result.toString());
    }
    public void firstNum() {
        first = Integer.valueOf(textView.getText().toString());
    }
    public void secondNum() {
        second = Integer.valueOf(textView.getText().toString());
    }
}