package com.eror.incometaxmanager;


import com.eror.incometaxcalculator.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;

public class ContactActivity extends Activity 
{
	ImageButton btnCall, btnEmail;
	String phoneNumber = "+8801556463544";
	String emailText;
	String emailTo[] = {"sadlil.rhythm@gmail.com"};
	String emailCC[] = {"sadlil.rhythm@yahoo.com"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_layout);
		
		btnCall = (ImageButton) findViewById(R.id.imageButtonCall);
		btnEmail = (ImageButton) findViewById(R.id.imageButtonEmail);
		
		btnCall.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				String uriString = "tel:"+phoneNumber;
				Intent intent = new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse(uriString));
				startActivity(intent);
				
			}
		});
		
		
		btnEmail.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				AlertDialog.Builder builder = new AlertDialog.Builder(ContactActivity.this);
				builder.setIcon(R.drawable.ic_launcher);
				builder.setTitle("Please Enter Your Message");
				builder.setMessage("Type Here");
				
				final EditText input = new EditText(ContactActivity.this);
				builder.setView(input);
				
				builder.setPositiveButton("Send", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						emailText = input.getText().toString();
						
						Intent intent = new Intent(Intent.ACTION_SEND);
						
						intent.putExtra(Intent.EXTRA_EMAIL, emailTo);
						intent.putExtra(Intent.EXTRA_CC, emailCC);
						intent.putExtra(Intent.EXTRA_SUBJECT, "Send From Android Apps ");
						intent.setType("plain/text");
						
						intent.putExtra(Intent.EXTRA_TEXT, emailText);
						startActivity(Intent.createChooser(intent, "Send Your Email With"));
						
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
	

}
