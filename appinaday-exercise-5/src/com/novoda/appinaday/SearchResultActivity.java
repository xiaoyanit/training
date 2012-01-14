package com.novoda.appinaday;

import java.util.Arrays;
import java.util.List;

import android.app.ListActivity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class SearchResultActivity extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_result_activity);

		List<String> values = Arrays.asList("item 1", "item 2", "item 3");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.search_result_item, R.id.title, values);
		setListAdapter(adapter);

		Uri uri = Uri.parse("content://com.novoda.appinaday/results");
		getContentResolver().query(uri, null, null, null, null);
	}

}