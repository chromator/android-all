package com.me.taskplanner.ui.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class TaskDB extends SQLiteOpenHelper {

	public static String TASKS_DB = "Tasks_db";
	public static int DB_VERSION = 1;

	public static String FIELD_TASK_ID = "task_id";
	public static String FIELD_TASK_DESC = "task_description";
	public static String FIELD_NOTES = "notes";
	/**
	 * Important-Urgent indicator, 0 : Imp and Urgent, 1 : Imp but not urgent, 2
	 * : Urgent but not important, 3 : Not imp not urgent
	 */
	public static String FIELD_IU_INDICATOR = "iu_indicator";
	public static String FIELD_TARGET_DATE = "target_date";
	public static String FIELD_RECURRING_FLAG = "recurring_flag";
	public static String FIELD_RECURRING_TYPE = "recurring_type";
	private static String CREATE_TASKS_TABLE = "create table " + TASKS_DB + " ( " + FIELD_TASK_ID
			+ "INTEGER PRIMARY KEY, " + FIELD_TASK_DESC + " TEXT, " + FIELD_NOTES + " TEXT, " + FIELD_IU_INDICATOR
			+ " INTEGER, " + FIELD_TARGET_DATE + " INTEGER, " + FIELD_RECURRING_FLAG + " INTEGER, "
			+ FIELD_RECURRING_TYPE + " INTEGER )";
	private static String DROP_TASKS_TABLE = "drop table " + TASKS_DB;

	public TaskDB(Context context, String name, CursorFactory factory, int version) {
		super(context, name, null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TASKS_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

	}

}
