package com.example.asynctaskloading;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class AsyncTaskLoading extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_async_task_loading);

		Button button = (Button)findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v)
			{
				AsyncTaskExample asyncTask = new AsyncTaskExample(AsyncTaskLoading.this);
				asyncTask.execute("test");
			}
		});
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.async_task_loading, menu);
		return true;
	}

}
