package com.xor.eror;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ApplyActivity extends Activity {

	Button btnapl, btncnf;
	
	
	public void init()
	{
		btnapl = (Button) findViewById(R.id.btnaplapl);
		btncnf = (Button) findViewById(R.id.btnaplcnf);
		
		btnapl.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				
				AlertDialog.Builder builder = new AlertDialog.Builder(ApplyActivity.this);
				builder.setIcon(R.drawable.ic_launcher);
				builder.setTitle("SIM Card Information");
				builder.setMessage("You need to have a Teletalk SIM Card Install and sufficient Balance in It.");
				
				builder.setPositiveButton("Yes I Have", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
						Intent intent = new Intent(ApplyActivity.this, ApplyFormActivity.class);
						startActivity(intent);
						
					}
				});
				
				builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
						
					}
				});
				
				builder.create().show();
			
				
				
			}
			
		});
		
		
		
		btncnf.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				
				AlertDialog.Builder builder = new AlertDialog.Builder(ApplyActivity.this);
				builder.setIcon(R.drawable.ic_launcher);
				builder.setTitle("PIN Confirmation");
				builder.setMessage("You need to have the PIN number given.");
				
				builder.setPositiveButton("Yes I Have", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
						Intent intent = new Intent(ApplyActivity.this, ConfirmApplyActivity.class);
						startActivity(intent);
						
					}
				});
				
				builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
						
					}
				});
				
				builder.create().show();
			
				
				
			}
			
		});
		
		
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_apply);
		
		init();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.apply, menu);
		return true;
	}

}
