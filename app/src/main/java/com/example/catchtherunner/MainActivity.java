package com.example.catchtherunner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void play(View view){
        Intent intent=new Intent(MainActivity.this,Difficulty.class);
        finish();
        startActivity(intent);


    }
    public void HighScore(View view){

        Intent intent=new Intent(MainActivity.this,HighScore.class);
        finish();
        startActivity(intent);
    }
    public void exit(View view){
        System.exit(0);
    }
}