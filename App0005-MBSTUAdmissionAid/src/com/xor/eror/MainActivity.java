package com.xor.eror;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	private ImageButton btnseatplan, btnresult, btnaddinfo, btndevs, btnmbstuinfo, btnapply;
	
	public void init()
	{
		btnseatplan = (ImageButton) findViewById(R.id.btnseatpln);
		btnseatplan.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(MainActivity.this, SeatPlanActivity.class);
				startActivity(i);
				
			}
		});
		
		
		btnresult = (ImageButton) findViewById(R.id.btnresult);
		btnresult.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(MainActivity.this, ResultActivity.class);
				startActivity(i);
				
			}
		});
		
		
		btnaddinfo = (ImageButton) findViewById(R.id.btnaddinfo);
		btnaddinfo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(MainActivity.this, AddInfo.class);
				startActivity(i);
				
			}
		});
		
		
		btndevs = (ImageButton) findViewById(R.id.btndeveloper);
		btndevs.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(MainActivity.this, Developerctivity.class);
				startActivity(i);
				
			}
		});
		
		
		
		btnmbstuinfo = (ImageButton) findViewById(R.id.btnmbstuinfo);
		btnmbstuinfo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(MainActivity.this, MbstuInfoActivity.class);
				startActivity(i);
				
			}
		});
		
		btnapply = (ImageButton) findViewById(R.id.btnapply);
		btnapply.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(MainActivity.this, ApplyActivity.class);
				startActivity(i);
				
			}
		});
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		init();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
