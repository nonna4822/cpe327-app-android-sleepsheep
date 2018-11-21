package com.example.elesr.sleepsheep;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class pushSheepGame extends AppCompatActivity {

    //intent message
    public static final String EXTRA_MESSAGE =
            "com.example.android.sleepsheep.extra.MESSAGE";
    //timeout to go sleep & handler
    public static final long GOTOSLEEP_TIMEOUT = 3000;
    private Handler goSleepHandler = new Handler();

    //set current time
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
    String currentDateTimeString = sdf.format(date);


    public void resetSleepTimer(View view){
        goSleepHandler.removeCallbacks(goToSleep);
        goSleepHandler.postDelayed(goToSleep, GOTOSLEEP_TIMEOUT);
    }

    public Runnable goToSleep = new Runnable() {
        @Override
        public void run() {
            lunchShowAwakingTime();
        }
    };

    public void lunchShowAwakingTime(){
        //intent
        String message = currentDateTimeString;
        Intent intent = new Intent(this, showAwakingTime.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_sheep_game);
    }

    @Override
    protected void onStart() {
        super.onStart();
        resetSleepTimer(null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        goSleepHandler.removeCallbacks(goToSleep);
    }

    @Override
    protected void onResume() {
        super.onResume();
        goSleepHandler.removeCallbacks(goToSleep);
    }

}
