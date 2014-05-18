package com.me.taskplanner.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;

import com.me.taskplanner.R;

public class HomeActivity extends Activity {
	private String TAG = "HomeActivity";
	private TaskAdapter listAdapter;
	private ExpandableListView expListView;
	private List<String> listDataHeader;
	private HashMap<String, List<String>> listDataChild;
	private Button addTaskButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		// get the listview
		expListView = (ExpandableListView) findViewById(R.id.lvExp);
		addTaskButton = (Button) findViewById(R.id.btn_add);

		addTaskButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomeActivity.this, AddTaskActivity.class);
				startActivity(intent);
			}
		});

		// preparing list data
		prepareListData();

		listAdapter = new TaskAdapter(this, listDataHeader, listDataChild);

		// setting list adapter
		expListView.setAdapter(listAdapter);

		expListView.expandGroup(0);

		// Listview Group click listener
		expListView.setOnGroupClickListener(new OnGroupClickListener() {

			@Override
			public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
				Log.d(TAG, "Group Clicked " + listDataHeader.get(groupPosition));
				return false;
			}
		});

		// Listview Group expanded listener
		expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

			@Override
			public void onGroupExpand(int groupPosition) {
				Log.d(TAG, listDataHeader.get(groupPosition) + " Expanded");

				expListView.setSelectedGroup(groupPosition);
			}
		});

		// Listview Group collasped listener
		expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

			@Override
			public void onGroupCollapse(int groupPosition) {
				Log.d(TAG, listDataHeader.get(groupPosition) + " Collapsed");

				// if(Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
				// @SuppressLint
				// expListView.smoothScrollToPositionFromTop(0, 0, 2000);
				// }
			}
		});

		// Listview on child click listener
		expListView.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
				Log.d(TAG,
						listDataHeader.get(groupPosition) + " : "
								+ listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
				return false;
			}
		});
	}

	/*
	 * Preparing the list data
	 */
	private void prepareListData() {
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		// Adding child data
		listDataHeader.add("Do it now, its important!");
		listDataHeader.add("Planned");
		listDataHeader.add("Do it quickly! It won't take time :)");
		listDataHeader.add("Do it later, not a problem.");

		// Adding child data
		List<String> impUrgTask = new ArrayList<String>();
		impUrgTask.add("Car servicing");
		impUrgTask.add("Bill payment");

		List<String> imptask = new ArrayList<String>();
		imptask.add("Project work");
		imptask.add("Home painting");

		List<String> urgentTask = new ArrayList<String>();
		urgentTask.add("Buy home grossary");

		List<String> notSoImpTask = new ArrayList<String>();
		notSoImpTask.add("Painting for home");

		listDataChild.put(listDataHeader.get(0), impUrgTask); // Header, Child
																// data
		listDataChild.put(listDataHeader.get(1), imptask);
		listDataChild.put(listDataHeader.get(2), urgentTask);
		listDataChild.put(listDataHeader.get(3), notSoImpTask);
	}
}
