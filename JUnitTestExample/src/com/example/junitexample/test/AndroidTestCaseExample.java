package com.example.junitexample.test;

import android.test.AndroidTestCase;

public class AndroidTestCaseExample extends AndroidTestCase
{

	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
	}


	@Override
	protected void tearDown() throws Exception
	{
		super.tearDown();
	}


	public void testApplicationCotext()
	{
		getContext();
	}
}
