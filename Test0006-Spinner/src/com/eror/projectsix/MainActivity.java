package com.eror.projectsix;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	Spinner spin;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        spin = (Spinner) findViewById(R.id.spinnerSelectItem);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.months_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new MyOnSelectListener());
    }
    
    
    
    public class MyOnSelectListener implements OnItemSelectedListener
    {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
			
			Toast.makeText(parent.getContext(), "Selected Item is " + parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
		
			
		}
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
