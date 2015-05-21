package com.eror.incometaxmanager;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.eror.incometaxcalculator.R;
import com.google.android.gms.internal.bs;

public class CalculateActivity extends Activity
{
	Spinner spnGender, spnArea;
	EditText txtSalary, txtRent, txtBusns, txtInvest, txtPaied, txtDue;
	CheckBox chkDisable, chkGovtempll;
	Button btnDate, btnCalc;
	
	int gender, area, disabled, govtEm, age, salary, houseRent, busnsInv, invesment, payedTax, dueTax, TotalTax;
	static int agge;
	static String bdstring;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calculate_layout);
		
		txtSalary = (EditText) findViewById(R.id.editTextSalary);
		txtRent = (EditText) findViewById(R.id.editTextHouseRent);
		txtBusns = (EditText) findViewById(R.id.editTextBusinessIncome);
		txtInvest = (EditText) findViewById(R.id.editTextInvest);
		txtPaied = (EditText) findViewById(R.id.editTextTaxPayed);
		txtDue = (EditText) findViewById(R.id.editTextTaxDue);
		
		
		spnGender = (Spinner) findViewById(R.id.spinnerGender);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnGender.setAdapter(adapter);
        spnGender.setOnItemSelectedListener(new MyOnSelectListener(1));
		
        spnArea = (Spinner) findViewById(R.id.spinnerResidance);
        adapter = ArrayAdapter.createFromResource(this, R.array.residance, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnArea.setAdapter(adapter);
        spnArea.setOnItemSelectedListener(new MyOnSelectListener(2));
        
        btnDate = (Button) findViewById(R.id.buttonBDday);
        btnCalc = (Button) findViewById(R.id.buttonCacl);   
        
        
        btnDate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DialogFragment newFragment = new DatePickerFragment();
				newFragment.show(getFragmentManager(), "datePicker");		
				Toast.makeText(getApplicationContext(), "BirthDay Date Setted", Toast.LENGTH_SHORT).show();
				//btnDate.setText(bdstring);
			}
		});
        
        
        btnCalc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				salary = Integer.parseInt(txtSalary.getText().toString());
				houseRent = Integer.parseInt(txtRent.getText().toString());
				busnsInv = Integer.parseInt(txtBusns.getText().toString());
				invesment = Integer.parseInt(txtInvest.getText().toString());
				payedTax = Integer.parseInt(txtPaied.getText().toString());
				dueTax = Integer.parseInt(txtDue.getText().toString());
				
				int total = calcTax();
				
				
				AlertDialog.Builder builder = new AlertDialog.Builder(CalculateActivity.this);
				builder.setIcon(R.drawable.ic_launcher);
				builder.setTitle("Your Income Tax Report");
				builder.setMessage("You Have to Pay " + total + " taka in Your Income Tax");
				
				builder.setPositiveButton("Pay Now", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
						Intent intent = new Intent(CalculateActivity.this, PaymentActivity.class);
						startActivity(intent);
						
					}
				});
				
				builder.setNegativeButton("See Details", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
						
					}
				});
				
				builder.create().show();
				
				
			}
		});
        
        
        chkDisable = (CheckBox) findViewById(R.id.checkBoxDisable);
        chkGovtempll = (CheckBox) findViewById(R.id.checkBoxgovEmpl);
        
        chkDisable.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				
				if(isChecked == true)
					disabled=1;
				else
					disabled=0;
				
			}
		});
        
        
	}
	
	public class MyOnSelectListener implements OnItemSelectedListener
    {
		int spnIndicator=0;
		
		public MyOnSelectListener(int ind)
		{
			spnIndicator = ind;
		}
		
		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
			
			if(spnIndicator == 1)
				gender = pos+1;
			else if(spnIndicator == 2)
				area = pos+1;
			
			Log.d("Spinner Selection", " "+ pos);
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
		
			
		}
    	
    }
	
	
	
	
	public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener
    {
		int tdyear, olde;
		
    	@Override
    	public Dialog onCreateDialog(Bundle savedInstanceState)
    	{
    		final Calendar c = Calendar.getInstance();
    		int year = c.get(Calendar.YEAR);
    		int month = c.get(Calendar.MONTH);
    		int day = c.get(Calendar.DAY_OF_MONTH);
    		
    		tdyear=year;
    		
    		return new DatePickerDialog(getActivity(), this, year-20, month+1, day);
    	}
    	
   		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
		{
			olde = tdyear - year;
			agge=olde;
			
		}
    }

	public int calcTax()
	{
		int interest=0;
		
		int total_income = salary + houseRent + busnsInv;
		
		int min_balance = 220000;
		
		if(gender == 2 || agge >= 65)
			min_balance = 250000;
		else if(disabled == 1)
			min_balance = 300000;
		
		if(total_income <= min_balance)
			interest = 0;
		else if(total_income > min_balance && total_income <= min_balance+300000)
			interest = 10;
		else if(total_income > min_balance+300000 && total_income <= min_balance+700000)
			interest = 15;
		else if(total_income > min_balance+700000 && total_income <= min_balance+1000000)
			interest = 20;
		else if(total_income > min_balance+1000000)
			interest = 25;
		
		
		int inComeTax = (total_income/100)*interest;
		
		if(area == 1 && inComeTax < 3000)
			inComeTax = 3000;
		else if(area == 2 && inComeTax < 2000)
			inComeTax = 2000;
		else if(area == 3 && inComeTax < 1000)
			inComeTax = 1000;
			
		int mayInvest = (total_income/100)*30;
		int totalIn = Math.min(mayInvest, invesment);
		int dessn = (totalIn*30)/100;
		
		inComeTax = inComeTax - dessn;
		inComeTax = inComeTax + dueTax;
		inComeTax = inComeTax - payedTax;
		
		
		return inComeTax;
	}
	
}
