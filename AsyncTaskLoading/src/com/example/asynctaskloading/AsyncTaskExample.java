package com.example.asynctaskloading;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class AsyncTaskExample extends AsyncTask<String, String, String>
{

	private ProgressDialog dialog;

	private final Context context;


	public AsyncTaskExample(Context context)
	{
		this.context = context;
	}


	@Override
	protected void onPreExecute()
	{
		super.onPreExecute();
		dialog = ProgressDialog.show(context, "Loading", "Loading animation");
	}


	@Override
	protected String doInBackground(String... arg0)
	{
		try
		{
			Thread.currentThread().sleep(5000);
		}
		catch ( InterruptedException e )
		{
			e.printStackTrace();
		}
		return "test";
	}


	@Override
	protected void onPostExecute(String result)
	{
		super.onPostExecute(result);
		System.out.println("Result is " + result);
		dialog.cancel();
	}
}
