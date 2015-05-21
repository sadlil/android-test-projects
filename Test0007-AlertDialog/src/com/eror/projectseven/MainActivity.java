package com.eror.projectseven;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button alertButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        alertButton = (Button) findViewById(R.id.warnningButton);
        alertButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showAlert();
				
			}
		});
    }

    public void showAlert()
    {
    	ContextThemeWrapper wraper = new ContextThemeWrapper(this, android.R.style.Theme_Holo);
    	AlertDialog.Builder builder = new AlertDialog.Builder(wraper);
    	builder.setMessage("Unfortunatly the process has Stopped");
    	builder.setPositiveButton("OK", null);
    	builder.setNegativeButton("Report",
    			new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) 
					{
						
						
					}
				});
    	builder.create().show();
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
