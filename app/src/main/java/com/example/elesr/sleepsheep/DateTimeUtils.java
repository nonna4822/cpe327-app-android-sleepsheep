package com.example.elesr.sleepsheep;

import android.util.Log;

import java.util.Date;

class DateTimeUtils {
    private String timeDuration;

    public long getSecondsDuration() {
        return secondsDuration;
    }

    public void setSecondsDuration(long secondsDuration) {
        this.secondsDuration = secondsDuration;
    }

    public long getMinutesDuration() {
        return minutesDuration;
    }

    public void setMinutesDuration(long minutesDuration) {
        this.minutesDuration = minutesDuration;
    }

    public long getHoursDuration() {
        return hoursDuration;
    }

    public void setHoursDuration(long hoursDuration) {
        this.hoursDuration = hoursDuration;
    }

    public long getDaysDuration() {
        return daysDuration;
    }

    public void setDaysDuration(long daysDuration) {
        this.daysDuration = daysDuration;
    }

    private long secondsDuration;
    private long minutesDuration;
    private long hoursDuration;
    private long daysDuration;

    String getTimeDuration() {
        return timeDuration;
    }

    private void setTimeDuration(String timeDuration) {
        this.timeDuration = timeDuration;
    }

    void setDifference(Date startDate, Date endDate) {

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        //diff milliseconds
        long different = endDate.getTime() - startDate.getTime();
        Log.d("MyApp",String.valueOf(different));

        //duration in different type
        setSecondsDuration(different / secondsInMilli);
        setMinutesDuration(different / minutesInMilli);
        setHoursDuration(different / hoursInMilli);
        setDaysDuration(different / daysInMilli);

        //translate to another unit
        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;

        //print to logcat

        Log.d("MyApp",
                        String.valueOf(elapsedHours) + " hours ," +
                        String.valueOf(elapsedMinutes) + " minutes ,"+
                        String.valueOf(elapsedSeconds) +" seconds,");

        this.setTimeDuration(
                String.valueOf(elapsedHours) + " hours ," +
                String.valueOf(elapsedMinutes) + " minutes ,"+
                String.valueOf(elapsedSeconds) +" seconds,");
    }
}