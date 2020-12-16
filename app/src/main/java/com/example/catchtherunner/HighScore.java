package com.example.catchtherunner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class HighScore extends AppCompatActivity {
    int high,high1,high2;
    TextView textView;
    TextView textView2;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        SharedPreferences sharedPreferences=getSharedPreferences("com.example.catchtherunner",MODE_PRIVATE);
        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);

        high=sharedPreferences.getInt("high",0);
        high1=sharedPreferences.getInt("high1",0);
        high2=sharedPreferences.getInt("high2",0);

        textView.setText("Easy Mode :"+high);
        textView2.setText("Medium Mode: "+high2);
        textView3.setText("Hard Mode : "+high1);



    }
}