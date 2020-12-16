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

public class MediumMode extends AppCompatActivity {
    TextView time2Text;
    TextView score2Text;
    TextView high2ScoreText;
    int score;
    int high2Score;
    SharedPreferences sharedPreferences;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    ImageView imageView13;
    ImageView imageView14;
    ImageView imageView15;
    ImageView imageView16;
    ImageView imageView17;
    ImageView imageView18;
    ImageView imageView20;
    ImageView imageView21;
    ImageView imageView19;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;
    Button button10;
    Button button11;
    Button button12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium_mode);
        high2ScoreText=findViewById(R.id.highScore2Text);
        sharedPreferences=this.getSharedPreferences("com.example.catchtherunner", Context.MODE_PRIVATE);
        score=0;
        high2Score= sharedPreferences.getInt("high2",0);
        high2ScoreText.setText("High Score: "+high2Score);
        time2Text=findViewById(R.id.time2Text);
        score2Text=findViewById(R.id.score2Text);
        imageView10=findViewById(R.id.imageView10);
        imageView11=findViewById(R.id.imageView11);
        imageView12=findViewById(R.id.imageView12);
        imageView13=findViewById(R.id.imageView13);
        imageView14=findViewById(R.id.imageView14);
        imageView15=findViewById(R.id.imageView15);
        imageView16=findViewById(R.id.imageView16);
        imageView17=findViewById(R.id.imageView17);
        imageView18=findViewById(R.id.imageView18);
        imageView19=findViewById(R.id.imageView19);
        imageView20=findViewById(R.id.imageView20);
        imageView21=findViewById(R.id.imageView21);

        imageArray=new ImageView[]{imageView10,imageView11,imageView12,imageView13,imageView14,imageView15,imageView16,imageView17,imageView18,imageView19
        ,imageView20,imageView21};
        hideImages();
        button10=findViewById(R.id.button10);
        button10.setVisibility(View.INVISIBLE);
        button11=findViewById(R.id.button11);
        button11.setVisibility(View.INVISIBLE);
        button12=findViewById(R.id.button12);
        button12.setVisibility(View.INVISIBLE);

        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long l) {
                time2Text.setText("Time : "+l/1000);
            }

            @Override
            public void onFinish() {
                button10.setVisibility(View.VISIBLE);
                button11.setVisibility(View.VISIBLE);
                button12.setVisibility(View.VISIBLE);
                time2Text.setText("Time Finish!");
                handler.removeCallbacks(runnable);
                for(ImageView image:imageArray)
                    image.setVisibility(View.INVISIBLE);
                if(high2Score<score){
                    high2Score=score;
                }
                sharedPreferences.edit().putInt("high2",high2Score).apply();


            }
        }.start();



    }
    public void increaseScore(View view){
        score++;

        score2Text.setText("Score : "+score);


    }
    public void hideImages(){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                for(ImageView image:imageArray)
                    image.setVisibility(View.INVISIBLE);
                Random random=new Random();
                int i =random.nextInt(12);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,400);
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
        Intent intent=new Intent(MediumMode.this,Difficulty.class);
        finish();
        startActivity(intent);

    }
    public void homeButton(View view){
        Intent intent=new Intent(MediumMode.this,MainActivity.class);
        finish();
        startActivity(intent);

    }
}