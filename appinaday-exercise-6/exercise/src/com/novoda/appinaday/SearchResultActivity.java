package com.novoda.appinaday;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

public class SearchResultActivity extends ListActivity {

	private static final String[] FROM = new String[] { "title" };
	private static final int[] TO = new int[] { R.id.title };
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_result_activity);

		Uri uri = Uri.parse("content://com.novoda.appinaday/results");
		
		Cursor c = getContentResolver().query(uri, null, null, null, null);
		setListAdapter(new SimpleCursorAdapter(this, R.layout.search_result_item, c, FROM, TO));
	}

}