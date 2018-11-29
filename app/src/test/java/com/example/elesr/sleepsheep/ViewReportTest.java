package com.example.elesr.sleepsheep;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class ViewReportTest {

    private int[] dayDurationInSecond = {16200000, 21600000, 10800000, 21600000, 5400000, 27000000, 21600000};

    @Test
    public void min(){
        assertEquals(5400000, ViewReport.getMin(dayDurationInSecond));
    }

    @Test
    public void max(){
        assertEquals(27000000, ViewReport.getMax(dayDurationInSecond));
    }

    @Test
    public void avg(){
        assertEquals(15428571, ViewReport.getAvg(dayDurationInSecond));
    }
}
