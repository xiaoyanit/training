package com.novoda.appinaday;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class SearchProvider extends ContentProvider {
	
	private static final String TAG = "SearchProvider";

	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
	  Log.v(TAG, "delete");
	  return 0;
	}
	@Override
	public String getType(Uri uri) {
	  Log.v(TAG, "type");
	  return null;
	}
	@Override
	public Uri insert(Uri uri, ContentValues values) {
	  Log.v(TAG, "insert");
	return null;
	}
	
	@Override
	  public boolean onCreate() {
	  Log.v(TAG, "onCreate");
	  return false;
	}
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
	    String[] selectionArgs, String sortOrder) {
	  Log.v(TAG, "query");
	  return null;
	}
	@Override
	public int update(Uri uri, ContentValues values, String selection,
	    String[] selectionArgs) {
	  Log.v(TAG, "update");
	  return 0;
	}

}
