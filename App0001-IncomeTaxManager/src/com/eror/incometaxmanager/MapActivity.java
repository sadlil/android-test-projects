package com.eror.incometaxmanager;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.eror.incometaxcalculator.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends Activity 
{
	private GoogleMap map;
	double ulat, ulong, oflat, oflong;
	String Text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_layout);
		
		LocationManager locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		LocationListener locListener = new LocationListener() {
			
			@Override
			public void onLocationChanged(Location location) {
				// TODO Auto-generated method stub
				ulat = location.getLatitude();
				ulong = location.getLongitude();
				
				
				Text = "My current location is :" + "Latitud ="
						+ location.getLatitude() + "Longitude ="
						+ location.getLongitude();
				Toast.makeText(getApplicationContext(), Text, Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "GPS Disabled", Toast.LENGTH_SHORT).show();
				
			}

			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "GPS Enabled", Toast.LENGTH_SHORT).show();

			}

			@Override
			public void onStatusChanged(String provider, int status,
					Bundle extras) {
				// TODO Auto-generated method stub
				
			}
			
		};
		locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locListener);
		
		
		oflat = ulat + 0.000035;
		oflong = ulong + 0.000035;
		
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.maps)).getMap();
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		map.addMarker(new MarkerOptions().position(new LatLng(ulat, ulong)).title("Your Position"));
		//Toast.makeText(getApplicationContext(), Text, Toast.LENGTH_SHORT).show();
		map.addMarker(new MarkerOptions().position(new LatLng(oflat, oflong)).title("Tax Office"));	
		
	}
}