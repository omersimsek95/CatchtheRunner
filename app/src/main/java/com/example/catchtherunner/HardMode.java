package com.example.catchtherunner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class HardMode extends AppCompatActivity {
    TextView time1Text;
    TextView score1Text;
    TextView highScore1Text;

    SharedPreferences sharedPreferences;
    int score;
    int high1Score;
    ImageView imageView22;
    ImageView imageView23;
    ImageView imageView24;
    ImageView imageView25;
    ImageView imageView26;
    ImageView imageView27;
    ImageView imageView28;
    ImageView imageView29;
    ImageView imageView30;
    ImageView imageView31;
    ImageView imageView32;
    ImageView imageView33;
    ImageView imageView34;
    ImageView imageView35;
    ImageView imageView36;
    ImageView imageView37;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;
    Button button16;
    Button button17;
    Button button18;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_mode);
        sharedPreferences=this.getSharedPreferences("com.example.catchtherunner", Context.MODE_PRIVATE);
        time1Text=findViewById(R.id.time1Text);
        score1Text=findViewById(R.id.score1Text);
        highScore1Text=findViewById(R.id.highScore1Text);
        score=0;
        high1Score= sharedPreferences.getInt("high1",0);
        highScore1Text.setText("High Score: "+high1Score);

        imageView22=findViewById(R.id.imageView22);
        imageView23=findViewById(R.id.imageView23);
        imageView24=findViewById(R.id.imageView24);
        imageView25=findViewById(R.id.imageView25);
        imageView26=findViewById(R.id.imageView26);
        imageView27=findViewById(R.id.imageView27);
        imageView28=findViewById(R.id.imageView28);
        imageView29=findViewById(R.id.imageView29);
        imageView30=findViewById(R.id.imageView30);
        imageView31=findViewById(R.id.imageView31);
        imageView32=findViewById(R.id.imageView32);
        imageView33=findViewById(R.id.imageView33);
        imageView34=findViewById(R.id.imageView34);
        imageView35=findViewById(R.id.imageView35);
        imageView36=findViewById(R.id.imageView36);
        imageView37=findViewById(R.id.imageView37);

        imageArray=new ImageView[]{imageView22,imageView23,imageView24,imageView25,imageView26,imageView27,imageView28,imageView29,imageView30,imageView31,imageView32,imageView33,imageView34,imageView35,imageView36,imageView37 };
        hideImages();
        button16=findViewById(R.id.button16);
        button16.setVisibility(View.INVISIBLE);
        button17=findViewById(R.id.button17);
        button17.setVisibility(View.INVISIBLE);
        button18=findViewById(R.id.button18);
        button18.setVisibility(View.INVISIBLE);

        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long l) {
                time1Text.setText("Time : "+l/1000);
            }

            @Override
            public void onFinish() {
                button16.setVisibility(View.VISIBLE);
                button17.setVisibility(View.VISIBLE);
                button18.setVisibility(View.VISIBLE);
                time1Text.setText("Time Finish!");
                handler.removeCallbacks(runnable);
                for(ImageView image:imageArray)
                    image.setVisibility(View.INVISIBLE);
                if(high1Score<score){
                    high1Score=score;
                }
                sharedPreferences.edit().putInt("high1",high1Score).apply();


            }
        }.start();




    }
    public void increaseScore(View view){
        score++;

        score1Text.setText("Score : "+score);


    }
    public void hideImages(){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                for(ImageView image:imageArray)
                    image.setVisibility(View.INVISIBLE);
                Random random=new Random();
                int i =random.nextInt(16);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,350);
            }

        };

        handler.post(runnable);}


    public void tryButton(View view){
        Intent intent=getIntent();
        finish();
        startActivity(intent);
        score=0;

    }
    public void setButton(View view){
        Intent intent=new Intent(HardMode.this,Difficulty.class);
        finish();
        startActivity(intent);

    }
    public void homeButton(View view){
        Intent intent=new Intent(HardMode.this,MainActivity.class);
        finish();
        startActivity(intent);

    }
}