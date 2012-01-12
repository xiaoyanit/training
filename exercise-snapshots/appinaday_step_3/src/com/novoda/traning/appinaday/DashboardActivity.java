package com.novoda.traning.appinaday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DashboardActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);
        
        final EditText editText = (EditText)findViewById(R.id.keyword);
        Button submit = (Button)findViewById(R.id.submitsearch);
        submit.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), 
						SearchResultActivity.class);
				i.putExtra("keyword", editText.getText().toString());
				startActivity(i);
			}
		});
    }
}