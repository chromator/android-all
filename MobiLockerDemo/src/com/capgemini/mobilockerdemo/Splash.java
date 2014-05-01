package com.capgemini.mobilockerdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Splash extends Activity {

	private Thread splashThread;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		splashThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// show splash screen for 5 seconds
				int count = 2;
				
				for (int i = 0; i < count; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				Splash.this.startActivity(new Intent(Splash.this, Login.class));
				Splash.this.finish();
			}
		});
		
		splashThread.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_splash, menu);
		return true;
	}

}
