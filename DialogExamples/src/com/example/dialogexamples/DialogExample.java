package com.example.dialogexamples;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class DialogExample extends Activity
{

	private Button dialogList;
	private Button dialogOkCancelShow;
	private Button dialogLogin;
	private Button dialogActivityDialog;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog_example);

		// API 8
		dialogList = (Button)findViewById(R.id.button1);
		dialogList.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v)
			{
				AlertDialog.Builder builder = new AlertDialog.Builder(DialogExample.this);
				builder.setTitle(R.string.pick_color);
				builder.setItems(R.array.colors_array, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						// The 'which' argument contains the index position
						// of the selected item
					}
				});
				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});

		// API 8
		dialogOkCancelShow = (Button)findViewById(R.id.button2);
		dialogOkCancelShow.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v)
			{
				AlertDialog.Builder builder = new AlertDialog.Builder(DialogExample.this);
				builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);

				// Add the buttons
				builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int id)
					{
						// User clicked OK button
					}
				});
				builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int id)
					{
						// User cancelled the dialog
					}
				});
				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});

		// API 8
		dialogLogin = (Button)findViewById(R.id.button3);
		dialogLogin.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v)
			{
				AlertDialog.Builder builder = new AlertDialog.Builder(DialogExample.this);
				// Get the layout inflater
				LayoutInflater inflater = DialogExample.this.getLayoutInflater();

				// Inflate and set the layout for the dialog
				// Pass null as the parent view because its going in the dialog layout
				builder.setView(inflater.inflate(R.layout.dialog_signin, null))
				// Add action buttons
						.setPositiveButton(R.string.signin, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int id)
							{
								// sign in the user ...
							}
						}).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int id)
							{
								dialog.cancel();
							}
						});
				AlertDialog dialog = builder.create();
				dialog.show();

			}
		});

		// showing activity as dialog requires API 11
		// android:theme="@android:style/Theme.Holo.DialogWhenLarge" for large screen
		dialogActivityDialog = (Button)findViewById(R.id.button4);
		dialogActivityDialog.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(DialogExample.this, DialogActivity.class);
				startActivity(intent);
			}
		});
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dialog_example, menu);
		return true;
	}

}
