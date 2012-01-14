package com.novoda.appinaday;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

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
				
				InputStream content = entity.getContent();
		        InputStreamReader stream = new InputStreamReader(content);
				parse(stream);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	private void parse(InputStreamReader stream) throws IOException {
		JsonReader reader = new JsonReader(stream);
		reader.beginObject();
		reader.nextName();
		reader.beginObject();
		reader.nextName();
		reader.beginArray();
		JsonToken token = reader.peek();
		while (token != JsonToken.END_ARRAY
			    && token != JsonToken.END_DOCUMENT) {
		  if (token == JsonToken.BEGIN_OBJECT) {
		    reader.beginObject();
		  } else if (token == JsonToken.NAME) {
		    String name = reader.nextName();
		    if ("title".equals(name)) {
		      Log.v("AppInADay", reader.nextString());
		    } else {
		      reader.skipValue();
		    }
		  } else if (token == JsonToken.END_OBJECT) {
		    reader.endObject();
		  }
		  token = reader.peek();
		}
	}

}
