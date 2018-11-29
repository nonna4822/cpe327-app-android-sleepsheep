package com.example.elesr.sleepsheep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class showAwakingTime extends AppCompatActivity {
    public int sleepCycle = 5400000;
    public DateTimeUtils timeDiffOpera = new DateTimeUtils();
    public DateTimeUtils timeDiffDura = new DateTimeUtils();
    public Calendar offerTimeAwa = GregorianCalendar.getInstance();

    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/M/yyyy HH:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_awaking_time);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Date timeSleepUser = new Date();
        Date timeUserInput = ((MyApplication)this.getApplication()).getAwakingTimeUser();

        //get actual sleeping time
        Intent intent = getIntent();
        String currentTimeSleep = intent.getStringExtra("currentTimeSleep");


        //Set full Sleep Cycle
        offerTimeAwa.setTime(timeSleepUser);
        offerTimeAwa.add(GregorianCalendar.MILLISECOND,sleepCycle*5);

        //find diff
        timeDiffOpera.setDifference(offerTimeAwa.getTime(),timeUserInput);

        while(timeDiffOpera.getSecondsDuration() < 0){
            //delete 1 cycle
            offerTimeAwa.add(GregorianCalendar.MILLISECOND, -sleepCycle);
            //find diff from "User input" and "new offer"
            timeDiffOpera.setDifference(offerTimeAwa.getTime(),timeUserInput);
        }

        //find duration
        timeDiffDura.setDifference(timeSleepUser, offerTimeAwa.getTime());

        //show actual sleeping time
        TextView tv_timeSleep = findViewById(R.id.textView_show_timpSleep);
        tv_timeSleep.setText(currentTimeSleep);

        //show actual user want to awaking time
        TextView tv_userInput = findViewById(R.id.textView_show_userInputTime);
        String dateTemp = sdf.format(((MyApplication)this.getApplication()).getAwakingTimeUser());
        tv_userInput.setText(dateTemp);

        //show actual awaking time
        TextView tv_awaTime = findViewById(R.id.textView_show_awaTime);
        String dateTemp2 = sdf.format(offerTimeAwa.getTime());
        tv_awaTime.setText(dateTemp2);

        //show time Duration
        TextView tv_duration = findViewById(R.id.textView_show_duration);
        tv_duration.setText(timeDiffDura.getTimeDuration());

    }
}
