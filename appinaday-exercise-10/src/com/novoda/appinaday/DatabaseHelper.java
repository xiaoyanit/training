package com.novoda.appinaday;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "appinaday.db";
	private static final int DATABASE_VERSION = 1;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE results"
				+ " (_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT)");
		db.execSQL("INSERT INTO results (title) VALUES (\"title 1\")");
		db.execSQL("INSERT INTO results (title) VALUES (\"title 2\")");
		db.execSQL("INSERT INTO results (title) VALUES (\"title 3\")");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
