package com.example.project11;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	
	Button btnSet, btnGet;
	EditText crntValue, setValue;
	SharedPreferences app_Preference;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		app_Preference = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		
		crntValue = (EditText) findViewById(R.id.getEditText);
		setValue = (EditText) findViewById(R.id.setEditText);
		
		btnSet = (Button) findViewById(R.id.btnSetValu);
		btnGet = (Button) findViewById(R.id.btnGetValu);		
		
		
		btnSet.setOnClickListener(new OnClickListener() {	
			
			@Override
			public void onClick(View v) {
				
				SharedPreferences.Editor editor = app_Preference.edit();
				editor.putString("myValue", setValue.getText().toString().trim());
				Log.d("Preferecne ", setValue.getText().toString().trim());
				
				editor.commit();
			}
		});
		
		btnGet.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String myValu = app_Preference.getString("myvalue", "");
				crntValue.setText(myValu);
				Log.d("Preference :", myValu);
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
