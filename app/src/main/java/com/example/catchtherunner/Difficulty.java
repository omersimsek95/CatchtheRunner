package com.example.catchtherunner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Difficulty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
    }
    public void Easy(View view){
        Intent intent1=new Intent(Difficulty.this,EasyMode.class);
        startActivity(intent1);
    }
    public void Medium(View view){
        Intent intent2=new Intent(Difficulty.this,MediumMode.class);
        startActivity(intent2);

    }
    public void Hard(View view){
        Intent intent3=new Intent(Difficulty.this,HardMode.class);
        startActivity(intent3);

    }


}