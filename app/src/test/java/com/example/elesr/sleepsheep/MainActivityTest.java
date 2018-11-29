package com.example.elesr.sleepsheep;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class MainActivityTest {

    private static int year;
    private static int month;
    private static int day;
    private static int hourOfDay;
    private static int minute;
    private static Date date = new Date();
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/M/yyyy HH:mm");

    private static void setYear(int year) {
        if(year < 0){
            MainActivityTest.year = 0;
        }else{
            MainActivityTest.year = year;
        }

    }

    private static void setMonth(int month) {
        if(month < 0)
            MainActivityTest.month = 0;
        else
            MainActivityTest.month = month;
    }

    private static void setDay(int day) {
        if(day < 0)
            MainActivityTest.day = 0;
        else
            MainActivityTest.day = day;
    }

    private static void setHourOfDay(int hourOfDay) {
        if(hourOfDay < 0)
            MainActivityTest.hourOfDay = 0;
        else
            MainActivityTest.hourOfDay = hourOfDay;
    }

    private static void setMinute(int minute) {
        if(minute < 0)
            MainActivityTest.minute = 0;
        else
            MainActivityTest.minute = minute;
    }
    @Before
    public void setUp(){
        year = 0;
        month = 0;
        day = 0;
        hourOfDay = 0;
        minute = 0;
    }

    @Test
    public void setTimeWithBirthday(){
        setYear(1997-1900);
        setMonth(8);
        setDay(12);
        setHourOfDay(18);
        setMinute(23);
        MainActivity.setTime(date , year , month , day , hourOfDay , minute);
        assertEquals("12/9/1997 23:18",sdf.format(date));
    }

    @Test
    public void setTimeWithMinusInt(){
        setYear(-1997-1900);
        setMonth(-8);
        setDay(-12);
        setHourOfDay(-18);
        setMinute(-23);
        MainActivity.setTime(date , year , month , day , hourOfDay , minute);
        assertEquals("31/12/1899 00:00",sdf.format(date));
    }
}
