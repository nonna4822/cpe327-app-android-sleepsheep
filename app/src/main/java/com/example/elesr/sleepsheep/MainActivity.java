package com.example.elesr.sleepsheep;

import android.app.Application;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static int year;
    private static int month;
    private static int day;
    private static int hourOfDay;
    private static int minute;
    private Date dateUser;

    public static void setYear(int year) {
        MainActivity.year = year;
    }

    public static void setMonth(int month) {
        MainActivity.month = month;
    }

    public static void setDay(int day) {
        MainActivity.day = day;
    }

    public static void setHourOfDay(int hourOfDay) {
        MainActivity.hourOfDay = hourOfDay;
    }

    public static void setMinute(int minute) {
        MainActivity.minute = minute;
    }


    //if you didn't set this format , sleepSheep will be not respon

    public void setTime(){
        year = year - 1900;
        dateUser.setDate(day);
        dateUser.setMonth(month);
        dateUser.setYear(year);
        dateUser.setMinutes(minute);
        dateUser.setHours(hourOfDay);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateUser = new Date();
    }

    public void launchPushSheepGame(View view) {
        //set
        ((MyApplication)this.getApplication()).setAwakingTimeUser(dateUser);

        setTime();
        Intent intent = new Intent(this, pushSheepGame.class);
        startActivity(intent);
    }

    public void lunchReport(View view) {
        Intent intent = new Intent(this , ViewReport.class);
        startActivity(intent);
    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
            setHourOfDay(hourOfDay);
            setMinute(minute);
        }
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {
        String text;

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            setYear(year);
            setMonth(month);
            setDay(day);
        }

    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

}



