package com.novoda.appinaday;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SearchResultActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_result_activity);
		
		TextView keywordView = (TextView)findViewById(R.id.keyword);
		String keyword = getIntent().getStringExtra("keyword");
		keywordView.setText(keyword);
	}

}
