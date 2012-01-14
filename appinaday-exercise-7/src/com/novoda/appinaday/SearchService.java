package com.novoda.appinaday;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

public class SearchService extends IntentService {

	public static final String SEARCH_ACTION = "com.novoda.appinaday.Search";
	public static final String END_SEARCH_ACTION = "com.novoda.appinaday.EndSearch";
	
	public SearchService() {
		this("SearchService");
	}

	public SearchService(String name) {
		super(name);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		String keyword = intent.getStringExtra("keyword");
		if (TextUtils.isEmpty(keyword)) {
			return;
		}
		Log.v("SearchService", "Search for : " + keyword);
		Intent broadcastIntent = new Intent(END_SEARCH_ACTION);
		sendBroadcast(broadcastIntent);
	}

}
