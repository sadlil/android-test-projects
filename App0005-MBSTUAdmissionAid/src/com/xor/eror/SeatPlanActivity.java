package com.xor.eror;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.xor.util.ConnectionDetector;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import android.graphics.Bitmap;

public class SeatPlanActivity extends Activity {

	ImageButton btn;
	ProgressDialog _dialog ; 
	WebView webView;
	
	String unit, roll;
	public String url;
	public String myString;
	
	public void init()
	{
		btn = (ImageButton) findViewById(R.id.btnseeseat);
		webView = (WebView) findViewById(R.id.webView);
		
		
		btn.setOnClickListener(new OnClickListener() {
			
			@SuppressWarnings("deprecation")
			public void showAlertDialog(Context context, String title, String message, Boolean status) {
		        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
		 
		        // Setting Dialog Title
		        alertDialog.setTitle(title);
		 
		        // Setting Dialog Message
		        alertDialog.setMessage(message);
		         
		        // Setting alert dialog icon
		        alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);
		 
		        // Setting OK Button
		        	alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
		                public void onClick(DialogInterface dialog, int which) {
		                	
		                	
		                }
		        	});
		 
		        // Showing Alert Message
		        alertDialog.show();
		    }
			
			public void okconnectedtoInternet()
			{
				AlertDialog.Builder builder = new AlertDialog.Builder(SeatPlanActivity.this);
				builder.setIcon(R.drawable.ic_launcher);
				builder.setTitle("Please Enter Unit and Roll Number");
				
				Context context = SeatPlanActivity.this;
				LinearLayout layout = new LinearLayout(context);
				layout.setOrientation(LinearLayout.VERTICAL);

				/*final EditText titleBox = new EditText(context);
				titleBox.setHint("Unit");
				layout.addView(titleBox);
				*/
				final Spinner unnt = new Spinner(context);
				String[] items = new String[] {"Unit - A", "Unit - B", "Unit - C", "Unit - D"};
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(SeatPlanActivity.this, android.R.layout.simple_spinner_dropdown_item, items);
				unnt.setAdapter(adapter);
				layout.addView(unnt);

				final EditText descriptionBox = new EditText(context);
				descriptionBox.setHint("Roll Number");
				layout.addView(descriptionBox);

				builder.setView(layout);
				
				builder.setPositiveButton("Check", new DialogInterface.OnClickListener() {
					
					public void connectInternetandchk(String u, String r)
					{
						url = "http://admission.brothers-jewellers.com/seat.php?roll=" +r+"&unit="+u;
						
						
						NetworkTask nettask = new NetworkTask();
						nettask.execute(url);
					}
					
					
					class HttpRetriver 
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
					
					
					
					class NetworkTask extends AsyncTask<String, Integer, String>
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
								
								webView.setWebViewClient(new WebViewClient()
								{
									
								       /*@Override
									       public void onPageStarted(WebView view, String url, Bitmap favicon) {
									        _dialog =ProgressDialog.show(SeatPlanActivity.this, "", "Please wait...");
									        super.onPageStarted(view, url, favicon);
									       }
								*/
								       @Override
									       public void onPageFinished(WebView view, String url) {
									        super.onPageFinished(view, url);
									        _dialog.dismiss();
									       }

								       @Override
									       public void onReceivedError(WebView view, int errorCode,
									         String description, String failingUrl) {
									        super.onReceivedError(view, errorCode, description, failingUrl);
									        try{
									         _dialog.dismiss();
									        }catch (Exception e) {
									        }
								       }
								});
								webView.loadUrl(url);
							}	
						}
					}
					
					
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
							int a = unnt.getSelectedItemPosition();
							
							//Toast.makeText(getApplicationContext(), unit, Toast.LENGTH_LONG).show();
							if(a==0)
								unit = "A";
							else if(a==1)
								unit = "B";
							else if(a==2)
								unit = "C";
							else if(a==3)
								unit = "D";
							
							roll = descriptionBox.getText().toString();
							
							connectInternetandchk(unit, roll);
							_dialog =ProgressDialog.show(SeatPlanActivity.this, "", "Please wait...");
					}
				});
				
				builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
					}
				});
				
				builder.create().show();
				
				
			}		
			
			@Override
			public void onClick(View v) {
				
				ConnectionDetector con = new ConnectionDetector(getApplicationContext());
				if( con.isConnectedtoInternet() == false)
				{
					showAlertDialog(SeatPlanActivity.this, "No Internet Connection",
                            "You don't have internet connection. Please Connect to Internet first.", false);
				}
				else
				{
					okconnectedtoInternet();
				}
			}
		});
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seatplan);
		
		AdView adView = (AdView) this.findViewById(R.id.adView);
        
        // Request for Ads
        AdRequest adRequest = new AdRequest.Builder()
        
        // Add a test device to show Test Ads
         .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        
        // Load ads into Banner Ads
        adView.loadAd(adRequest);
		
		init();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.seat_plan, menu);
		return true;
	}

}
