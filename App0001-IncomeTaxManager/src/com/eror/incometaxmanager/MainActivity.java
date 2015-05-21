package com.eror.incometaxmanager;

import com.eror.incometaxcalculator.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button btnCalculate, btnPayment, btnAdvantage, btnContact, btnWallet, btnAbout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		btnCalculate = (Button) findViewById(R.id.btnmainCalculate);
		btnCalculate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(MainActivity.this, CalculateActivity.class);
				startActivity(i);
				
			}
		});
		
		
		
		
		btnPayment = (Button) findViewById(R.id.btnPayment);
		btnPayment.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(MainActivity.this, PaymentActivity.class);
				startActivity(i);
				
			}
		});
		
		
		btnAdvantage = (Button) findViewById(R.id.btnAdvantage);
		btnAdvantage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(MainActivity.this, AdvantageActivity.class);
				startActivity(i);
				
			}
		});
		
		btnContact = (Button) findViewById(R.id.btnContact);
		btnContact.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(MainActivity.this, ContactActivity.class);
				startActivity(i);
				
			}
		});
		
		btnWallet = (Button) findViewById(R.id.btnWallet);
		btnWallet.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(MainActivity.this, WalletActivity.class);
				startActivity(i);
				
			}
		});
		
		btnAbout = (Button) findViewById(R.id.btnAbout);
		btnAbout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(MainActivity.this, AboutActivity.class);
				startActivity(i);
				
			}
		});
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
