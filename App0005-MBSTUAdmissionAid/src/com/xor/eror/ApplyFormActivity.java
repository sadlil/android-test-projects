package com.xor.eror;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;


public class ApplyFormActivity extends Activity{
	
	Spinner spUnit,spQuota,spHscBoard,spSscBoard;
	EditText etHscRoll,etHscYear,etSscRoll,etSscYear;
	Button btnApply;
	
	String hscRoll,hscBoard,hscYear,sscRoll,sscBoard,sscYear,quotaSelected,unitSelected;
	String sms=null;
	
	String unit[]={"A","B","C","D"};
	String quota[]={"None","FFQ","TQ"};
	String board[]={"COM","BAR","CHI","SYL","DHA","DIN","JES","RAJ","MAD","VOC","DIB","DIC","HBM","OTH"};
	
	String finalSMS;
	
	int unitPos,quotaPos,hscBoardPos,sscBoardPos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_apply_form);
		
		spQuota=(Spinner) findViewById(R.id.spQuta);
		spUnit=(Spinner) findViewById(R.id.spUnit);
		spHscBoard=(Spinner) findViewById(R.id.spHscBoard);
		spSscBoard=(Spinner) findViewById(R.id.spSscBoard);
		
		etHscRoll=(EditText) findViewById(R.id.etHscRoll);
		
		etHscYear=(EditText) findViewById(R.id.etHscYear);
		etSscRoll=(EditText) findViewById(R.id.etSscRoll);
		
		etSscYear=(EditText) findViewById(R.id.etSscYear);
		
		btnApply=(Button) findViewById(R.id.btnApply);
		
		
		chooseUnit();
		chooseQuota();
		chooseHscBoard();
		chooseSscBoard();
		
		
		btnApply.setOnClickListener(new View.OnClickListener() {
			
			public void sendSMS(String str)
			{
				
				finalSMS = str;
			      try {
			    	  
			    	    AlertDialog.Builder builder = new AlertDialog.Builder(ApplyFormActivity.this);
						builder.setIcon(R.drawable.success);
						builder.setTitle("Apply Information");
						builder.setMessage("Check Your SMS again and press send with Teletalk SIM. You will then recive a SMS contain Your PIN Number. Write it down and Go To Confirm Registration..");
						
						builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								  Intent smsIntent = new Intent(Intent.ACTION_VIEW);
							      smsIntent.setData(Uri.parse("smsto:"));
							      smsIntent.setType("vnd.android-dir/mms-sms");

							      smsIntent.putExtra("address"  , new String ("16222"));
							      smsIntent.putExtra("sms_body"  , finalSMS);
								
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
			         Toast.makeText(ApplyFormActivity.this, 
			         "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
			      }
			}
			
			@Override
			public void onClick(View v) {
				
				hscRoll=etHscRoll.getText().toString();
				hscYear=etHscYear.getText().toString();
				sscRoll=etSscRoll.getText().toString();
				sscYear=etSscYear.getText().toString();
				
				hscBoard=board[hscBoardPos];
				sscBoard=board[sscBoardPos];
				unitSelected=unit[unitPos];
				quotaSelected=quota[quotaPos];
				
				if(hscRoll.length()==0 || hscRoll.length()>6)
				{
					etHscRoll.setHint("Set Correct Roll!!!");
					
					//Toast.makeText(getApplicationContext(), "HSCRoll", Toast.LENGTH_LONG).show();
				}
				if(sscRoll.length()==0 || sscRoll.length()>6)
				{
					etSscRoll.setHint("Set Correct Roll!!!");
					//Toast.makeText(getApplicationContext(), "SSCRoll", Toast.LENGTH_LONG).show();
				}
				
				
				else
				{
				if(quotaPos==0)
				{
					sms="MBSTU "+hscBoard+" "+hscRoll+" "+hscYear+" "+sscBoard+" "+sscRoll+" "+sscYear+" "+unitSelected;
				}
				else
				{
					sms="MBSTU "+hscBoard+" "+hscRoll+" "+hscYear+" "+sscBoard+" "+sscRoll+" "+sscYear+" "+unitSelected+" "+quotaSelected;
				}
					sendSMS(sms);
					//Toast.makeText(getApplicationContext(), "Check Your SMS Again and Press send with Teletalk SIM Selected", Toast.LENGTH_LONG).show();
				}
				
				
				
				//Toast.makeText(getApplicationContext(),sms, Toast.LENGTH_LONG).show();
				
				
			}
		});
		
	}
	
	public void chooseUnit() {
		
		ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,unit);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spUnit.setAdapter(adapter1);
		spUnit.setOnItemSelectedListener(new unitOnClickListener());
	
	}

	public class unitOnClickListener implements OnItemSelectedListener
		{

		@Override
		public void onItemSelected(AdapterView<?> parent, View v, int pos,long id) {

			unitPos=pos;
		}


	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
	
	private void chooseQuota()
	{
		ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,quota);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spQuota.setAdapter(adapter2);
		spQuota.setOnItemSelectedListener(new QuotaClickListener());
		
	}
	public class QuotaClickListener implements OnItemSelectedListener
	{
		@Override
		public void onItemSelected(AdapterView<?> parent, View v, int pos,long id) {

			quotaPos=pos;
		}


	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
		
	}
	
	private void chooseHscBoard()
	{
		ArrayAdapter<String> adapter3=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,board);
		adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spHscBoard.setAdapter(adapter3);
		spHscBoard.setOnItemSelectedListener(new HscBoardClickListener());
		
	}
	public class HscBoardClickListener implements OnItemSelectedListener
	{
		@Override
		public void onItemSelected(AdapterView<?> parent, View v, int pos,long id) {
			
			hscBoardPos=pos;
		}


	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
		
	}
	
	
	private void chooseSscBoard()
	{
		ArrayAdapter<String> adapter4=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,board);
		adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spSscBoard.setAdapter(adapter4);
		spSscBoard.setOnItemSelectedListener(new SscBoardClickListener());
		
	}
	public class SscBoardClickListener implements OnItemSelectedListener
	{
		@Override
		public void onItemSelected(AdapterView<?> parent, View v, int pos,long id) {
			
			sscBoardPos=pos;
		}


	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
		
	}

}