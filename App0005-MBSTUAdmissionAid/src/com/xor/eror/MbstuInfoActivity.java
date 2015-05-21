package com.xor.eror;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class MbstuInfoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mbstu_info);
		
		WebView lWebView = (WebView)findViewById(R.id.mbstuinfoview);
        lWebView.loadUrl("file:///android_res/raw/mbstuinfo.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mbstu_info, menu);
		return true;
	}

}
