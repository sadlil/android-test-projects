package com.xor.eror;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmApplyActivity extends Activity {

	Button btncnf;
	EditText txtpin, txtcontact;
	String sms;
	
	public void init()
	{
		txtpin = (EditText) findViewById(R.id.cnfapltxtpin);
		txtpin.setSelected(true);
		btncnf = (Button) findViewById(R.id.cnfaplbtn);
		txtcontact = (EditText) findViewById(R.id.cnfapltxt);
		
		
		btncnf.setOnClickListener(new View.OnClickListener() {
			
			public void sendSMS()
			{
				
			      try {
			    	  
			    	    AlertDialog.Builder builder = new AlertDialog.Builder(ConfirmApplyActivity.this);
						builder.setIcon(R.drawable.success);
						builder.setTitle("Confirm Information");
						builder.setMessage("Check Your PIN and Contact number again and press send with Teletalk SIM. You will then recive a SMS contain Your roll Number. Save It for future use.");
						
						builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								  Intent smsIntent = new Intent(Intent.ACTION_VIEW);
							      smsIntent.setData(Uri.parse("smsto:"));
							      smsIntent.setType("vnd.android-dir/mms-sms");

							      smsIntent.putExtra("address"  , new String ("16222"));
							      smsIntent.putExtra("sms_body"  , sms);
								
								startActivity(smsIntent);
								
							}
						});
						
						builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								
								
							}
						});
						
						builder.create().show();
					
			         
			      } 
			      catch (android.content.ActivityNotFoundException ex) {
			         Toast.makeText(ConfirmApplyActivity.this, 
			         "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
			      }
			}

			@Override
			public void onClick(View arg0) {
				
				String PIN, CNTCT;
				
				PIN = txtpin.getText().toString();
				CNTCT = txtcontact.getText().toString();
				
				if(PIN.length()>0 && CNTCT.length()>=11)
				{
					sms = "MBSTU YES " + PIN +" " + CNTCT;
					sendSMS();
				}
				else
				{
					txtpin.setText("");
					txtpin.setHint("Please Use Correct PIN Number");
					txtcontact.setText("");
					txtcontact.setHint("Please Use Correct Contact Number");
					Toast.makeText(getApplicationContext(), "Wrong Input. Please Try Again", Toast.LENGTH_SHORT).show();
				}
			}
	});
	
}
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm_apply);
		
		init();
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.confirm_apply, menu);
		return true;
	}

}
