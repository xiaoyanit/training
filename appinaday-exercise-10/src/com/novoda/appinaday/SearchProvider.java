package com.novoda.appinaday;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class SearchProvider extends ContentProvider {

	private static final String TAG = "SearchProvider";
	private DatabaseHelper databaseHelper;

	@Override
	public int delete(Uri uri, String where, String[] selectionArgs) {
	  return databaseHelper.getWritableDatabase().delete("results", 
		where, selectionArgs);
	}

	@Override
	public String getType(Uri uri) {
		Log.v(TAG, "type");
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
	  long id = databaseHelper.getWritableDatabase().insert(
	    "results", null ,values);
	  return Uri.withAppendedPath(uri, "" + id);
	}

	@Override
	public boolean onCreate() {
		databaseHelper = new DatabaseHelper(getContext());
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		return databaseHelper.getReadableDatabase().query("results", 
			      projection, selection, selectionArgs, null, null, sortOrder);
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		Log.v(TAG, "update");
		return 0;
	}

}
