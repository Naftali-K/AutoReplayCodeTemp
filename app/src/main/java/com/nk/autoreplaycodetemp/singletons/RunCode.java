package com.nk.autoreplaycodetemp.singletons;

import android.text.format.DateFormat;
import android.util.Log;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: naftalikomarovski
 * @Date: 2024/10/23
 */
public class RunCode {

    private static final String TAG = "Test_code";

    private Timer timer;
    private static final int INTERVAL = 1000;

    private static RunCode instance;
    private RunCode() {
        startCode();
    }
    public static RunCode getInstance() {
        if (instance == null) {
            instance = new RunCode();
        }

        return instance;
    }

    public void startCode() {
        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long millisecinds = System.currentTimeMillis();
                Date date = new Date(millisecinds);

                String hour = DateFormat.format("hh", date).toString();
                String minutes = DateFormat.format("mm", date).toString();
                String seconds = DateFormat.format("ss", date).toString();

                String time = hour + ":" + minutes + ":" + seconds;

                Log.d(TAG, "run: Now time: " + time);
            }
        }, 0, INTERVAL);

//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                long millisecinds = System.currentTimeMillis();
//                Date date = new Date(millisecinds);
//
//                String hour = DateFormat.format("hh", date).toString();
//                String minutes = DateFormat.format("mm", date).toString();
//                String seconds = DateFormat.format("ss", date).toString();
//
//                String time = hour + ":" + minutes + ":" + seconds;
//
//                Log.d(TAG, "run: Now time: " + time);
//            }
//        }, 0, INTERVAL);
    }

    public void stopCode() {
        if (timer == null) {
            return;
        }

        timer.cancel();
    }
}
