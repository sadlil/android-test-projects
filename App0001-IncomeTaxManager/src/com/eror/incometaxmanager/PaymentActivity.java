package com.eror.incometaxmanager;

import com.eror.incometaxcalculator.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class PaymentActivity extends Activity 
{

	Button btnLogin, btnTaxOfc;
	ImageButton btnQcash, btnBkash, btnMaster, btnVisa;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.payment_layout);
		
		btnLogin = (Button) findViewById(R.id.btnLogin);
		btnTaxOfc = (Button) findViewById(R.id.btnFindOffice);
		
		btnQcash = (ImageButton) findViewById(R.id.btnQcash);
		btnBkash = (ImageButton) findViewById(R.id.btnBikash);
		btnMaster = (ImageButton) findViewById(R.id.btnMastercard);
		btnVisa = (ImageButton) findViewById(R.id.btnVisa);
		
		btnTaxOfc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				Intent i = new Intent(PaymentActivity.this, MapActivity.class);
				startActivity(i);
				
				
			}
		});
		
		btnQcash.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				referToLink("http://www.nbrepayment.org");
			}
		});
		
		btnBkash.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				referToLink("http://www.nbrepayment.org");
			}
		});
		
		btnMaster.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				referToLink("http://www.nbrepayment.org");
			}
		});
		
		btnVisa.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				referToLink("http://www.nbrepayment.org");
			}
		});
		
		btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				referToLink("http://www.nbrepayment.org/login.jsp");
				
			}
		});
		
	}
	
	
	public void referToLink(String uRL)
	{
		Intent intent = new Intent(PaymentActivity.this, WebviewActivity.class);
		intent.putExtra("gotoURL", uRL);
		Log.d("refer", "Intent Set");
		
		startActivity(intent);
	}

}
