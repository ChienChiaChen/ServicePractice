package com.example.chiachen.servicepractice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by chiachen on 2017/8/14.
 */

public class SensorService extends Service {
    public int counter = 0;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        Log.e("JASON_CHIEN", "\nonStartCommand");
        startTimer();
        return Service.START_STICKY; //
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("JASON_CHIEN", "\nonDestroy");

        // Service Never die
        // Intent broadcastIntent = new Intent("ActivityRecognition.RestartSensor");
        // sendBroadcast(broadcastIntent);
        // stoptimertask();
    }

    private Timer timer;
    private TimerTask timerTask;
    long oldTime = 0;

    public void startTimer() {
        timer = new Timer();//set a new Timer
        initializeTimerTask(); //initialize the TimerTask's job
        timer.schedule(timerTask, 1000, 1000); //schedule the timer, to wake up every 1 second
    }

    /**
     * it sets the timer to print the counter every x seconds
     */
    public void initializeTimerTask() {
        timerTask = new TimerTask() {
            public void run() {
                Log.e("JASON_CHIEN", "in timer ++++  " + (counter++));
            }
        };
    }

    /**
     * When it's no need
     */
    public void stoptimertask() {
        if (timer != null) { //stop the timer, if it's not already null
            timer.cancel();
            timer = null;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
