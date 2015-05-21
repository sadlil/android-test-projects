package com.eror.dataconverter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	
	Spinner spn1, spn2;
	TextView txt;
	Button bt;
	EditText txtfld;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		spn1 = (Spinner) findViewById(R.id.spinner1);
		spn2 = (Spinner) findViewById(R.id.spinner2);
		txt = (TextView) findViewById(R.id.textView2);
		bt = (Button) findViewById(R.id.button1);
		txtfld = (EditText) findViewById(R.id.editText1);
		
		
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				String s = txtfld.getText().toString();
				int sponev = spn1.getSelectedItemPosition();				
				int sptwov = spn2.getSelectedItemPosition();
				
				String ret = "";
				
				int basebase = 0;
				if(sponev == 0)
					basebase = 2;
				else if(sponev == 1)
					basebase = 10;
				else if(sponev == 2)
					basebase = 8;
				else if(sponev == 3)
					basebase = 16;
				
				long res = Long.parseLong(s, basebase);
				
				//Toast.makeText(getApplicationContext(), sponev+"\n"+res, Toast.LENGTH_SHORT).show();
				
				if(sptwov == 0)
					ret = Long.toBinaryString(res);
				else if(sptwov == 1)
					ret = Long.toString(res);
				else if(sptwov == 2)
					ret = Long.toOctalString(res);
				else if(sptwov == 3)
					ret = Long.toHexString(res);
				
				txt.setText(ret);				
				
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
