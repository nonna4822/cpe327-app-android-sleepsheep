package com.example.elesr.sleepsheep;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import static org.junit.Assert.*;

/**
 * Example local unit duraDayObj, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
public class DateTimeUtilsTest {

    private DateTimeUtils duraDayObj;
    private Date dateStartTest;
    private Date dateStopTest;

    //for testing parameter
    SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/M/yyyy HH:mm:ss");

    @Before
    public void setUp(){
        String dateStartString = "25/05/2018 20:00:00";
        String dateStopString = "28/05/2018 20:00:00";

        try {
            dateStartTest = sdf.parse(dateStartString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            dateStopTest = sdf.parse(dateStopString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //for call method by object
        duraDayObj = new DateTimeUtils();
    }

    @Test
    public void findDurationInSeccond() {

        duraDayObj.setDifference(dateStartTest , dateStopTest);
        assertEquals(259200 ,duraDayObj.getSecondsDuration());
    }

    @Test
    public void findDurationInMinutes() {

        duraDayObj.setDifference(dateStartTest , dateStopTest);
        assertEquals(4320 ,duraDayObj.getMinutesDuration());
    }

    @Test
    public void findDurationInHour() {

        duraDayObj.setDifference(dateStartTest , dateStopTest);
        assertEquals(72 ,duraDayObj.getHoursDuration());
    }

    @Test
    public void findDurationInDay() {

        duraDayObj.setDifference(dateStartTest , dateStopTest);
        assertEquals(3 ,duraDayObj.getDaysDuration());
    }
}
