package com.example.elesr.sleepsheep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ViewReport extends AppCompatActivity {
    TextView tv_1;
    TextView tv_2;
    TextView tv_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_report);
        tv_1 = findViewById(R.id.textView);
        tv_2 = findViewById(R.id.textView2);
        tv_3 = findViewById(R.id.textView3);
    }

    static int[] dayDurationInSecond = {16200000, 21600000, 10800000, 21600000, 5400000, 27000000, 21600000};

    public  void onStart(){
        super.onStart();

        int min = getMin(dayDurationInSecond);
        int max = getMax(dayDurationInSecond);
        int avg = getAvg(dayDurationInSecond);

        for( int i = 0 ; i < dayDurationInSecond.length ; i++){
            Log.d("Day Duration",getDuration(dayDurationInSecond[i]));
        }

        // printing minimum and maximum numbers
        Log.d("Min/Max/avg","Minimum time duration in second : " + min);
        Log.d("Min/Max/avg","Maximun time duration in second : " + max);
        Log.d("Min/Max/avg","Avg time duration in second : " + avg);

        // printing minimum and maximum numbers
        Log.d("Min/Max/avg","Minimum time duration in date format : " + getDuration(min));
        Log.d("Min/Max/avg","Maximun time duration in date format : " + getDuration(max));
        Log.d("Min/Max/avg","Avg time time duration in date format : " + getDuration(avg));

        //set
        tv_1.setText(getDuration(min));
        tv_2.setText(getDuration(max));
        tv_3.setText(getDuration(avg));

    }

    public String getDuration(long second){

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        //translate to another unit
        long elapsedDays = second / daysInMilli;
        second = second % daysInMilli;

        long elapsedHours = second / hoursInMilli;
        second = second % hoursInMilli;

        long elapsedMinutes = second / minutesInMilli;
        second = second % minutesInMilli;

        long elapsedSeconds = second / secondsInMilli;

        return String.valueOf(elapsedHours) + " hours ," +
                        String.valueOf(elapsedMinutes) + " minutes ," +
                        String.valueOf(elapsedSeconds) +" seconds,";
    }

    // Method for getting the maximum value
    public static int getMax(int[] inputArray){
        int maxValue = inputArray[0];
        for(int i=1;i < inputArray.length;i++){
            if(inputArray[i] > maxValue){
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }

    // Method for getting the minimum value
    public static int getMin(int[] inputArray){
        int minValue = inputArray[0];
        for(int i=1;i<inputArray.length;i++){
            if(inputArray[i] < minValue){
                minValue = inputArray[i];
            }
        }
        return minValue;
    }

    // Method for getting the minimum value
    public static int getAvg(int[] inputArray){
        int sum = 0;
        for(int i=1;i<inputArray.length;i++){
            sum = sum + inputArray[i];
        }
        return sum / inputArray.length;
    }
}
