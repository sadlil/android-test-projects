package com.eror.iftarcounter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Formatter;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends Activity {
	
	int Stimehour[]= {0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0};
	int Stimemin[] = {0, 42, 42, 43, 43, 44, 44, 45, 45, 46, 46, 47, 48, 48, 49, 49, 50, 50, 51, 52, 52, 53, 54, 55, 55, 56, 57, 58, 58, 59, 59, 0 , 0};
	
	int Etimehour[] = {0, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 0, 0};
	int Etimemin[] = {0, 54, 54, 54, 54, 54, 54, 54, 54, 53, 53, 53, 53, 53, 53, 53, 52, 52, 52, 51, 51, 50, 50, 50, 49, 49, 48, 48, 47, 47, 46, 0 ,0};
	
	public int seconds = 59;
    public int minutes = 10;
    public int hours = 1;
    
    
    TextView one;
    TextView tv; 
    
    public void setInit()
    {
    	int date, hour, min, sec;
    	
    	one = (TextView) findViewById(R.id.textView1);
    	tv = (TextView) findViewById(R.id.textView2);
    	
    	Calendar c = Calendar.getInstance();
    	date = c.get(Calendar.DATE);
    	hour = c.get(Calendar.HOUR_OF_DAY);
    	min = c.get(Calendar.MINUTE);
    	sec = c.get(Calendar.SECOND);
    	
    	int crntshour = Stimehour[date]; int crntsmin = Stimemin[date];
    	int crntehour = Etimehour[date]; int crntemin = Etimemin[date];
    	
    	
    	int time = hour*3600 + min*60 + 60;
    	int seheri = crntshour*3600 + crntsmin*60;
    	int iftar = crntehour*3600 + crntemin*60;
    	
    	if(time >= seheri && time <= iftar)
    	{
    		one.setText("Next Iftar");
    		minutes = crntemin - min;
    		hours = crntehour - hour;
    		
    		if(minutes < 0)
    		{
    			hours--;
    			minutes = 60 + minutes;
    		}
    		
    		runTimer();
    		
    	}
    	else
    		{
    			one.setText("You can Eat anytime now");
    			tv.setText("   ");
    		}
    
    }
    
    public void runTimer()
    {
    	//Declare the timer
	    Timer t = new Timer();
	    //Set the schedule function and rate
	    t.scheduleAtFixedRate(new TimerTask() {

	        @Override
	        public void run() {
	            runOnUiThread(new Runnable() {

	                @Override
	                public void run() {
	                    
	                    Formatter frto = new Formatter();
	                    Formatter frtt = new Formatter();
	                    Formatter frttt = new Formatter();
	                    
	                    tv.setText(frto.format("%02d", hours).toString() + ":" + frtt.format("%02d", minutes).toString() + ":" + frttt.format("%02d", seconds).toString());
	                    seconds--;

	                    if(seconds == -1)
	                    {
	                    	seconds = 59;
	                    	minutes -= 1;

	                    }
	                    
	                    if(minutes == -1)
	                    {
	                        minutes = 59;
	                        hours = hours-1;
	                    }
	                }

	            });
	        }

	    }, 0, 1000);
    }
    
    

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		setInit();
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}	
	
}
