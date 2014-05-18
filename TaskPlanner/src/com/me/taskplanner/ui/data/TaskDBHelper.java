package com.me.taskplanner.ui.data;

import android.content.Context;

public class TaskDBHelper {

	private TaskDB mTasksDb;
	private Context mContext;

	public TaskDBHelper(Context context) {
		mContext = context;
		mTasksDb = new TaskDB(context, TaskDB.TASKS_DB, null, TaskDB.DB_VERSION);
	}

	public void openDatabase() {

	}

	public void saveTask() {

	}
}
