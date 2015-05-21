package com.eror.test.admob;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		AdView adView = (AdView) this.findViewById(R.id.adView);
        
        // Request for Ads
        AdRequest adRequest = new AdRequest.Builder()
        
        // Add a test device to show Test Ads
         .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        
        // Load ads into Banner Ads
        adView.loadAd(adRequest);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
