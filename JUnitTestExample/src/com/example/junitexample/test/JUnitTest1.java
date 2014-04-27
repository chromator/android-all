package com.example.junitexample.test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;

import com.example.junitexample.JUnitExample;

public class JUnitTest1 extends ActivityUnitTestCase<JUnitExample>
{
	private int buttonId;
	private JUnitExample activity;


	public JUnitTest1()
	{
		super(JUnitExample.class);
	}


	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		Intent intent = new Intent(getInstrumentation().getTargetContext(), JUnitExample.class);
		startActivity(intent, null, null);
		activity = getActivity();
	}


	@SmallTest
	public void testLayout()
	{
		buttonId = com.example.junitexample.R.id.button1;
		assertNotNull(activity.findViewById(buttonId));
		Button view = (Button)activity.findViewById(buttonId);
		assertEquals("Incorrect label of the button", "Button", view.getText());
	}


	@SmallTest
	public void testIntentTriggerViaOnClick()
	{
		buttonId = com.example.junitexample.R.id.button1;
		Button view = (Button)activity.findViewById(buttonId);
		assertNotNull("Button not allowed to be null", view);

		// You would call the method directly via
		getActivity().onClick(view);

		// TouchUtils cannot be used, only allowed in
		// InstrumentationTestCase or ActivityInstrumentationTestCase2

		// check the intent which was started
		Intent triggeredIntent = getStartedActivityIntent();
		assertNotNull("Intent was null", triggeredIntent);
		String data = triggeredIntent.getExtras().getString("URL");

		assertEquals("Incorrect data passed via the intent", "http://www.vogella.com", data);
	}


	@Override
	protected void tearDown() throws Exception
	{

		super.tearDown();
	}
}
