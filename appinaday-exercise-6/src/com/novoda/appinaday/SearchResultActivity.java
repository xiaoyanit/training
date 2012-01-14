package com.novoda.appinaday;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class SearchResultActivity extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_result_activity);

		Uri uri = Uri.parse("content://com.novoda.appinaday/results");
		Cursor c = getContentResolver().query(uri, null, null, null, null);
		List<String> values = new ArrayList<String>();
		while (c.moveToNext()) {
			values.add(c.getString(c.getColumnIndex("title")));
		}
		c.close();

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.search_result_item, R.id.title, values);
		setListAdapter(adapter);
	}

}