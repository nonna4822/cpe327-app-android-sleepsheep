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
    //setting format
    SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy HH:mm:ss");

    //intent message
    public static final String EXTRA_MESSAGE =
            "com.example.android.sleepsheep.extra.MESSAGE";
    //timeout to go sleep & handler
    public static final long GOTOSLEEP_TIMEOUT = 3000;
    private Handler goSleepHandler = new Handler();

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
        //create new intent
        Intent intent = new Intent(this, showAwakingTime.class);

        //get actual sleeping time
        Date date = new Date();
        String currentTimeSleep = sdf.format(date);

        //put "actual sleeping time" into intent
        intent.putExtra("currentTimeSleep", currentTimeSleep);

        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_sheep_game);

//        test global variable//
        TextView textView = findViewById(R.id.textView_showUserTime);
        Date temp = ((MyApplication)this.getApplication()).getAwakingTimeUser();
        textView.setText(sdf.format(temp));
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
