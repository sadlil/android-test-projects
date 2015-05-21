package com.eror.incometaxmanager;

import com.eror.incometaxcalculator.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class AdvantageActivity extends Activity 
{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.advantage_layout);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


}
