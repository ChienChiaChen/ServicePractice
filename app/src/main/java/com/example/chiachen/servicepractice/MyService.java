package com.example.chiachen.servicepractice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by chiachen on 2017/8/14.
 */

public class MyService extends Service {
	
	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
