package com.nk.autoreplaycodetemp.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.text.format.DateFormat;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Date;

/**
 * @Author: naftalikomarovski
 * @Date: 2024/10/22
 */
public class MyScheduledService extends Service {

    private static final String TAG = "Test_code";

    private Handler handler = new Handler();
    private Runnable runnable;
//    private static final int INTERVAL = 30000;
    private static final int INTERVAL = 1000;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        startRepeatingTask();
    }

    private void startRepeatingTask() {
        runnable = new Runnable() {
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
        };

        handler.postDelayed(runnable, INTERVAL);
    }

    private void stopRepeatingTask() {
        handler.removeCallbacks(runnable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopRepeatingTask();
    }
}
