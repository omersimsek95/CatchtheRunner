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

public class EasyMode extends AppCompatActivity {

    TextView timeText;
    TextView scoreText ;
    TextView highScoreText;
    SharedPreferences sharedPreferences;
    int score;
    int highScore;
    ImageView imageView;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;
    Button button7;
    Button button8;
    Button button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_mode);
        highScoreText=findViewById(R.id.highScoreText);
        scoreText = findViewById(R.id.scoreText);
        timeText=findViewById(R.id.timeText);
        sharedPreferences=this.getSharedPreferences("com.example.catchtherunner",Context.MODE_PRIVATE);

        score=0;
        highScore= sharedPreferences.getInt("high",0);
        highScoreText.setText("High Score: "+highScore);


        imageView=findViewById(R.id.imageView);
        imageView1=findViewById(R.id.imageView1);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);
        imageView5=findViewById(R.id.imageView5);
        imageView6=findViewById(R.id.imageView6);
        imageView7=findViewById(R.id.imageView7);
        imageView8=findViewById(R.id.imageView8);
        imageArray=new ImageView[]{imageView,imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8, };
        hideImages();
        button7=findViewById(R.id.button7);
        button7.setVisibility(View.INVISIBLE);
        button8=findViewById(R.id.button8);
        button8.setVisibility(View.INVISIBLE);
        button9=findViewById(R.id.button9);
        button9.setVisibility(View.INVISIBLE);







        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long l) {
                timeText.setText("Time : "+l/1000);
            }

            @Override
            public void onFinish() {
                button7.setVisibility(View.VISIBLE);
                button8.setVisibility(View.VISIBLE);
                button9.setVisibility(View.VISIBLE);
                timeText.setText("Time Finish!");
                handler.removeCallbacks(runnable);
                for(ImageView image:imageArray)
                    image.setVisibility(View.INVISIBLE);
                if(highScore<score){
                    highScore=score;
                }
                sharedPreferences.edit().putInt("high",highScore).apply();

            }
        }.start();







    }
    public void increaseScore(View view){
        score++;

        scoreText.setText("Score : "+score);


    }
    public void hideImages(){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                for(ImageView image:imageArray)
                    image.setVisibility(View.INVISIBLE);
                Random random=new Random();
                int i =random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,500);
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
        Intent intent=new Intent(EasyMode.this,Difficulty.class);
            finish();
        startActivity(intent);



        }
        public void homeButton(View view){
        Intent intent=new Intent(EasyMode.this,MainActivity.class);
            finish();
        startActivity(intent);


        }


    }