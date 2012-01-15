package com.novoda.appinaday;

import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
	}

	@Override
	protected void onResume() {
		super.onResume();
		String keyword = getIntent().getStringExtra("keyword");
		
		IntentFilter filter = new IntentFilter(SearchService.END_SEARCH_ACTION);
		registerReceiver(serchCompletedReceiver, filter);
		
		Intent i = new Intent(SearchService.SEARCH_ACTION);
		i.putExtra("keyword", keyword);
		startService(i);
	}
	
	protected void onPause() {
		unregisterReceiver(serchCompletedReceiver);
		super.onPause();
	}

	private void update() {
		Uri uri = Uri.parse("content://com.novoda.appinaday/results");
		Cursor c = getContentResolver().query(uri, null, null, null, null);
		setListAdapter(new SimpleCursorAdapter(this,
				R.layout.search_result_item, c, FROM, TO));
	}

	private BroadcastReceiver serchCompletedReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context paramContext, Intent paramIntent) {
			update();
		}
	};

}