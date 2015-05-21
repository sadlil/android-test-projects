package com.xor.eror;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
 
public class SplashScreen extends Activity {
 
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 1500;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.WHITE);
        setContentView(R.layout.activity_splash);
        
        new Handler().postDelayed(new Runnable() {
 
            @Override
            public void run() {
                
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
 
}