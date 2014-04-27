package com.example.junitexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class JUnitExample extends Activity implements OnClickListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_junit_example);

		Button button = (Button)findViewById(R.id.button1);
		button.setOnClickListener(this);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.junit_example, menu);
		return true;
	}


	@Override
	public void onClick(View v)
	{
		System.out.println("Clicked on something");
		Intent intent = new Intent(this, SecondActivity.class);
		intent.putExtra("URL", "http://www.vogella.com");
		startActivity(intent);
	}

}
