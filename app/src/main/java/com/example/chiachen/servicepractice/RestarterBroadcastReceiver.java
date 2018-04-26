package com.example.chiachen.servicepractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by jianjiacheng on 2017/8/14.
 */

public class RestarterBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("JASON_CHIEN", "Service Stops! Oooooooooooooppppssssss!!!!");
        context.startService(new Intent(context, SensorService.class));;
    }
}
