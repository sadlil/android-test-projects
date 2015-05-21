package com.eror.projectThree;

import java.util.Random;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button redButton;	
	TextView color_view;
	int color;
	int colorarr[]={Color.RED, Color.BLACK, Color.CYAN, Color.BLUE, Color.GREEN, Color.YELLOW};
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        color_view = (TextView) findViewById(R.id.colorRegion);
        redButton = (Button) findViewById(R.id.btnColor);
        color=1;
        
        redButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				color_view.setBackgroundColor(colorarr[color]);
				color++;
				color = color%5;
			}
		});
     
    }
    
    public void setRegionColor(int color)
    {
    	color_view.setBackgroundColor(color);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
