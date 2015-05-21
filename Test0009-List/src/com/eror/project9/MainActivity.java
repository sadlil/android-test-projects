package com.eror.project9;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        String name[] = new String[]{"A", "B", "C", "D", "E", "F"};
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, name));        
    }
    
    @Override
    protected void onListItemClick(ListView I, View v, int position, long id)
    {
    	super.onListItemClick(I, v, position, id);
    	String o = getListAdapter().getItem(position).toString();
    	
    	Toast.makeText(getApplicationContext(), "You Selected " + o, Toast.LENGTH_LONG).show();
    }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    		
    	getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
