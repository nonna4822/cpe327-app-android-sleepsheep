package com.example.elesr.sleepsheep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class showAwakingTime extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_awaking_time);
        Intent intent = getIntent();
        String message = intent.getStringExtra(pushSheepGame.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_showTime);
        textView.setText(message);
    }
}
