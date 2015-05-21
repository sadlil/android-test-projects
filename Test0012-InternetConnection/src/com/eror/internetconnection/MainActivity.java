package com.eror.internetconnection;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Entity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText urlfinder;
	Button btnOk;
	WebView viewWeb;
	
	public String url;
	public String myString;
	
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		urlfinder = (EditText) findViewById(R.id.editTextUrl);
		btnOk = (Button) findViewById(R.id.btnSubmit);
		viewWeb = (WebView) findViewById(R.id.webView);
		
		btnOk.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				/*String url = urlfinder.getText().toString();
				String ret = new HttpRetriver().retrive(url);
				
				if(ret != null)
				{
					Log.d("Response ", ret);
					viewWeb.loadUrl(url);
				}
				else
				{
					Toast.makeText(getApplicationContext(), "Error Loading URL", Toast.LENGTH_LONG).show();
				}
				*/
				
				NetworkTask nettask = new NetworkTask();
				nettask.execute(urlfinder.getText().toString());
				
				
			}
				
				
				
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	public class HttpRetriver 
	{
		private DefaultHttpClient client = new DefaultHttpClient();
		
		public String retrive(String url)
		{
			HttpGet getRequest = new HttpGet(url);
			
			try
			{
				HttpResponse getResponse = client.execute(getRequest);
				final int statuscode = getResponse.getStatusLine().getStatusCode();
				
				if(statuscode != HttpStatus.SC_OK)
				{
					Log.w(getClass().getSimpleName(), "EROR " + statuscode + " for URL " + url);
					return null;
				}
				
				HttpEntity getResponseEntity = getResponse.getEntity();
				
				if(getResponseEntity != null)
					return EntityUtils.toString(getResponseEntity);
			}
			catch(IOException exc)
			{
				getRequest.abort();
				Log.w(getClass().getSimpleName(), "Eroor for URl " + url, exc);
			}
			return null;
		}
	}
	
	
	
	public class NetworkTask extends AsyncTask<String, Integer, String>
	{		
		@Override
		protected String doInBackground(String... urls) {
			
			int count = urls.length;
			url = urls[0];
			
			for(int i=0; i<count; i++)
			{
				HttpRetriver retriver = new HttpRetriver();
				myString = retriver.retrive(urls[i]);
			}
			return myString;
		}

		@Override
		protected void onPostExecute(String result) {
			
			super.onPostExecute(result);
			if( result != null)
			{
				Log.i("Response", result);
				
				viewWeb.setWebViewClient(new WebViewClient());
				viewWeb.loadUrl(urlfinder.getText().toString());
			}	
		}
	}

}
