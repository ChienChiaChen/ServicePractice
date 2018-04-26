package com.example.chiachen.servicepractice;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Intent mServiceIntent;
    private SensorService mSensorService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSensorService = new SensorService();
        mServiceIntent = new Intent(MainActivity.this, mSensorService.getClass());

        findViewById(R.id.Test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("JASON_CHIEN", "On Click");
                if (isMyServiceRunning(SensorService.class)) {
                    ((TextView) findViewById(R.id.Test)).setText("Start");
                    stopService(mServiceIntent);
                } else {
                    ((TextView) findViewById(R.id.Test)).setText("Close");
                    startService(mServiceIntent);
                }
            }
        });
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        if (null == manager) {
            return false;
        }

        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                Log.e("JASON_CHIEN", "\n" + serviceClass.getSimpleName() + " is Running");
                return true;
            }
        }
        Log.e("JASON_CHIEN", "\n" + serviceClass.getSimpleName() + " is not exist");
        return false;
    }

    @Override
    protected void onDestroy() {
        Log.e("JASON_CHIEN", "\nonDestroy");
        super.onDestroy();
    }
}
