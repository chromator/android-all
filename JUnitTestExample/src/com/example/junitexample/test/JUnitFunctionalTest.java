package com.example.junitexample.test;

import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;

import com.example.junitexample.JUnitExample;
import com.example.junitexample.SecondActivity;

public class JUnitFunctionalTest extends ActivityInstrumentationTestCase2<JUnitExample>
{
	JUnitExample activity;


	public JUnitFunctionalTest()
	{
		super(JUnitExample.class);
	}


	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		setActivityInitialTouchMode(false);
		activity = getActivity();
	}


	public void testStartSecondActivity() throws Exception
	{

		// add monitor to check for the second activity
		ActivityMonitor monitor = getInstrumentation().addMonitor(SecondActivity.class.getName(), null, false);

		// find button and click it
		Button view = (Button)activity.findViewById(com.example.junitexample.R.id.button1);
		TouchUtils.clickView(this, view);

		// To click on a click, e.g. in a listview
		// listView.getChildAt(0);

		// Wait 2 seconds for the start of the activity
		SecondActivity startedActivity = (SecondActivity)monitor.waitForActivityWithTimeout(2000);
		assertNotNull(startedActivity);

		// Search for the textView
		TextView textView = (TextView)startedActivity.findViewById(com.example.junitexample.R.id.textview1);

		// check that the TextView is on the screen
		ViewAsserts.assertOnScreen(startedActivity.getWindow().getDecorView(), textView);
		// Validate the text on the TextView
		assertEquals("Text incorrect", "Hello world!", textView.getText().toString());

		// Press back and click again
		this.sendKeys(KeyEvent.KEYCODE_BACK);
		TouchUtils.clickView(this, view);

	}
}
