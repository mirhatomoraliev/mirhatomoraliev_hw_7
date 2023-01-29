package com.example.hw_2_7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String sum = getIntent().getStringExtra("sum");
        ((TextView)findViewById(R.id.change_text)).setText(sum);

        findViewById(R.id.second_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("shamal", "second Destroy");
    }
}