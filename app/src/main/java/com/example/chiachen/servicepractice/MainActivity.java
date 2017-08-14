package com.example.chiachen.servicepractice;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
	Intent mServiceIntent;
	private SensorService mSensorService;
	View view;
	Context ctx;
	public Context getCtx() {
		return ctx;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ctx = this;
		mSensorService = new SensorService(getCtx());
		mServiceIntent = new Intent(getCtx(), mSensorService.getClass());
		if (!isMyServiceRunning(mSensorService.getClass())) {
			startService(mServiceIntent);
		}
		
		view = findViewById(R.id.Test);
		view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Log.e(MainActivity.class.getSimpleName(), "Test");
			}
		});
	}
	
	private boolean isMyServiceRunning(Class<?> serviceClass) {
		ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
		for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
			if (serviceClass.getName().equals(service.service.getClassName())) {
				Log.i ("isMyServiceRunning?", true+"");
				return true;
			}
		}
		Log.i ("isMyServiceRunning?", false+"");
		return false;
	}
	
	@Override
	protected void onDestroy() {
		// stopService(mServiceIntent);
		Log.i("MAINACT", "onDestroy!");
		super.onDestroy();
	}
}
