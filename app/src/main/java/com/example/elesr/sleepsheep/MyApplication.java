package com.example.elesr.sleepsheep;

import android.app.Application;

import java.util.Date;

public class MyApplication extends Application {

    private Date awakingTimeUser;

    public Date getAwakingTimeUser() {
        return awakingTimeUser;
    }

    public void setAwakingTimeUser(Date temp) {
        this.awakingTimeUser = temp;
    }
}
