package com.example.chiachen.servicepractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
	View view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		view = findViewById(R.id.Test);
		view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Log.e(MainActivity.class.getSimpleName(), "Test");
			}
		});
	}
}
