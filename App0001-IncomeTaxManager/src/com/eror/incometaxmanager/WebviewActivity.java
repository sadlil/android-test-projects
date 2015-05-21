package com.eror.incometaxmanager;

import java.io.IOException;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.eror.incometaxcalculator.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebviewActivity extends Activity 
{
	
	WebView webView;
	String uRL, url, myString;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview_layout);
		
		Intent intent = getIntent();
		uRL = intent.getExtras().get("gotoURL").toString();
		webView = (WebView) findViewById(R.id.webView);
		
		//Toast.makeText(getApplicationContext(), "String Recived " + uRL, Toast.LENGTH_LONG).show();
		
		ConnectivityManager mgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = mgr.getActiveNetworkInfo();
		
		
		if(netInfo != null)
		{
			NetworkTask nettask = new NetworkTask();
			nettask.execute(uRL);
		}
		else
		{
			Toast.makeText(getApplicationContext(), "No Internet Connection. Please Connect to Internet First.", Toast.LENGTH_LONG).show();
			intent = new Intent(getApplicationContext(), PaymentActivity.class);
			startActivity(intent);
		}
		
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
					Toast.makeText(getApplicationContext(), "Error Connecting Network", Toast.LENGTH_LONG).show();
					return null;
				}
				
				HttpEntity getResponseEntity = getResponse.getEntity();
				
				if(getResponseEntity != null)
					return EntityUtils.toString(getResponseEntity);
			}
			catch(IOException exc)
			{
				getRequest.abort();
				Toast.makeText(getApplicationContext(), "Error in Web Link", Toast.LENGTH_LONG).show();
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
				Log.i("urls", urls[i] + " " );
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
				
				webView.setWebViewClient(new WebViewClient());
				webView.loadUrl(uRL);
			}	
		}
	}
	
	
}
