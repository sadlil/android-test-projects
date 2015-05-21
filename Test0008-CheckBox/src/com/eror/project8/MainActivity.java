package com.eror.project8;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	Button iconBtn;
	EditText editTxtItem;
	CheckBox chkBox;
	RadioButton red;
	RadioButton bule;
	ToggleButton btnToggle;
	RatingBar ratingBar;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        iconBtn = (Button) findViewById(R.id.iconButton);
        iconBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this," Icon Button Pressed ", Toast.LENGTH_SHORT).show();	
			}
		});
        
        
        editTxtItem = (EditText) findViewById(R.id.editTextItem);
        editTxtItem.setOnKeyListener(new OnKeyListener() {
			
			public boolean onKey(View v, int keyCode, KeyEvent event) {
			
				String entered = editTxtItem.getText().toString();
				if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER))
						{
							Toast.makeText(MainActivity.this, "You Entered : "+entered, Toast.LENGTH_LONG).show();
							return true;
						}
				
				return false;
			}
		});
        
        
        
        chkBox = (CheckBox) findViewById(R.id.checkBox);
        chkBox.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(((CheckBox)v).isChecked())
					Toast.makeText(MainActivity.this, "CheckBox Checked", Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(MainActivity.this, "CheckBox Unchecked", Toast.LENGTH_SHORT).show();
				
			}
		});
        
        red = (RadioButton) findViewById(R.id.radioRed);
        bule = (RadioButton) findViewById(R.id.radioBlue);  
        final OnClickListener radioListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				RadioButton rb = (RadioButton) v;
				Toast.makeText(MainActivity.this,rb.getText() , Toast.LENGTH_SHORT).show();
				
			}
		};
        red.setOnClickListener(radioListener);
        bule.setOnClickListener(radioListener);
        
        btnToggle = (ToggleButton) findViewById(R.id.toggleButton);
        btnToggle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(btnToggle.isChecked())
					Toast.makeText(MainActivity.this, "Toggle Button is On" , Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(MainActivity.this, "Toggle Button is Off" , Toast.LENGTH_SHORT).show();
				
			}
		});
        
        
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
			
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
			
				Toast.makeText(MainActivity.this, "New Ratting is " + rating , Toast.LENGTH_SHORT).show();
				
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
