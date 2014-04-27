package com.test.splash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {
	private Thread mSplashThread;
	boolean active;
	int splashTime = 3000;
	Context mContext;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		mContext = this;
		active = true;
		mSplashThread = new Thread() {
			@Override
			public void run() {
				int waited = 0;

				while (active && waited < splashTime) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (active) {
						waited += 100;
					}
				}
				((Activity)mContext).finish();
				Intent intent = new Intent(mContext, MainActivity.class);
				mContext.startActivity(intent);
				
			}
		};

		mSplashThread.start();
	}
}