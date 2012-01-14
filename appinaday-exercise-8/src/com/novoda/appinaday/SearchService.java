package com.novoda.appinaday;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

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
		
		callGoogleSearch(keyword);
		
		Intent broadcastIntent = new Intent(END_SEARCH_ACTION);
		sendBroadcast(broadcastIntent);
	}

	private void callGoogleSearch(String keyword) {
		try {
			String url = "http://ajax.googleapis.com/ajax/services"
					+ "/search/web?v=1.0&rsz=8&q=" + keyword;
			HttpClient client = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url);
			HttpResponse response = client.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				Log.v("SearchService", EntityUtils.toString(entity));
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
