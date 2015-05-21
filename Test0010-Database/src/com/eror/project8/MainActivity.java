package com.eror.project8;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText nameEditText, emailEditText, contactEditText;
	Button saveButton, showAllButton; 
	
	String name, email, contact;
	
	DatabaseAdapter dbadapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        contactEditText = (EditText) findViewById(R.id.phoneEditText);
        
        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				name = nameEditText.getText().toString();
				email = emailEditText.getText().toString();
				contact = contactEditText.getText().toString();
				
				dbadapter = new DatabaseAdapter(getApplicationContext());
				dbadapter.open();
				long returnValu = dbadapter.insertContact(name, email, contact);
				dbadapter.close();
				//nameEditText.setText(Long.toString(returnValu));
				Toast.makeText(getApplicationContext(), "Data Saved Successful", Toast.LENGTH_LONG).show();
				
			}
		});
        
        showAllButton = (Button) findViewById(R.id.buttonShowData);
        showAllButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, ShowAllContacts.class);
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
