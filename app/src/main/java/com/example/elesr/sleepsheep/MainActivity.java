package com.example.elesr.sleepsheep;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView showTime;
    private TimePicker timePicker1;
//    private Calendar


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showTime = findViewById(R.id.text_showTime);
    }

    public void launchPushSheepGame(View view) {
//        int hour = ;
        Intent intent = new Intent(this, pushSheepGame.class);
        startActivity(intent);
    }

}

