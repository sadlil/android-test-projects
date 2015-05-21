package com.eror.projectfour;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends Activity {

	
	private Button mPickDate;
	private static TextView dateDisplayTextView;
	private int mYear;
	private int mMonth;
	private int mDay;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        dateDisplayTextView = (TextView) findViewById(R.id.txtDateView);
        mPickDate = (Button) findViewById(R.id.btnPickDate);
        
        mPickDate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				DialogFragment newFragment = new DatePickerFragment();
				newFragment.show(getFragmentManager(), "datePicker");			
				
			}
		});
    }

    
    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener
    {
    	@Override
    	public Dialog onCreateDialog(Bundle savedInstanceState)
    	{
    		final Calendar c = Calendar.getInstance();
    		int year = c.get(Calendar.YEAR);
    		int month = c.get(Calendar.MONTH);
    		int day = c.get(Calendar.DAY_OF_MONTH);
    		
    		return new DatePickerDialog(getActivity(), this, year, month, day);
    	}
    	
   		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
		{
			
			dateDisplayTextView.setText(dayOfMonth + "-" + (monthOfYear+1) + "-" + year);
		}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
