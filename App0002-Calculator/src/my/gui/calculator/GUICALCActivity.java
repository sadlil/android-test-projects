package my.gui.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GUICALCActivity extends Activity {
	
	EditText A;
	TextView B,C;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
		A=(EditText)findViewById(R.id.txt1);
        B=(TextView)findViewById(R.id.lbl1);
        C=(TextView)findViewById(R.id.lbl2);
       
    }
    
    public void onClickC(View v)
    {
    	A.setText("");
    }
    
    public void onClick7(View v)
    {
    	String N;
    	
    	N=A.getText().toString();
    	N=N+"7";
    	A.setText(N);
    }
    
    public void onClick8(View v)
    {
    	String N;
    	
    	N=A.getText().toString();
    	N=N+"8";
    	A.setText(N);
    }
    
    public void onClick9(View v)
    {
    	String N;
    	
    	N=A.getText().toString();
    	N=N+"9";
    	A.setText(N);
    }
    
    public void onClick4(View v)
    {
    	String N;
    	
    	N=A.getText().toString();
    	N=N+"4";
    	A.setText(N);
    }
    
    public void onClick5(View v)
    {
    	String N;
    	
    	N=A.getText().toString();
    	N=N+"5";
    	A.setText(N);
    }
    
    public void onClick6(View v)
    {
    	String N;
    	
    	N=A.getText().toString();
    	N=N+"6";
    	A.setText(N);
    }
    
    public void onlCick1(View v)
    {
    	String N;
    	
    	N=A.getText().toString();
    	N=N+"1";
    	A.setText(N);
    }
    
    public void onClick2(View v)
    {
    	String N;
    	
    	N=A.getText().toString();
    	N=N+"2";
    	A.setText(N);
    }
    
    public void onClick3(View v)
    {
    	String N;
    	
    	N=A.getText().toString();
    	N=N+"3";
    	A.setText(N);
    }

    public void onClick0(View v)
    {
    	String N;
    	
    	N=A.getText().toString();
    	N=N+"0";
    	A.setText(N);
    }
    
    public void onClickD(View v)
    {
    	String N;
    	
    	N=A.getText().toString();
    	B.setText(N);
    	C.setText("/");
    	
    	A.setText("");
    }
    
    public void onClickMu(View v)
    {
    	String N;
    	
    	N=A.getText().toString();
    	B.setText(N);
    	C.setText("*");
    	
    	A.setText("");
    }
    
    public void onClickM(View v)
    {
    	String N;
    	
    	N=A.getText().toString();
    	B.setText(N);
    	C.setText("-");
    	
    	A.setText("");
    }
    
    public void onClickP(View v)
    {
    	String N;
    	
    	N=A.getText().toString();
    	B.setText(N);
    	C.setText("+");
    	
    	A.setText("");
    }
    
   
    public void onClickEquals(View v)
    {
        int X,Y,CAL=0;
        char Z;
    	
    	X=Integer.parseInt(A.getText().toString());
    	Y=Integer.parseInt(B.getText().toString());
    	Z=C.getText().charAt(0);
    	
    	
    	if (Z=='+')
    	    CAL=X+Y;
    	else if (Z=='-')
  	      CAL=X-Y;
    	else if (Z=='*')
    	      CAL=X*Y;
    	else if (Z=='/')
  	      CAL=X/Y;
  
    	 A.setText(""+CAL);
		 B.setText("");
		 C.setText("");
		 
    	//-------BY OBJECT AND PROPERTIES------
    	
    	/*Calculator calO=new Calculator();
    	
    	
    	calO.setA(X);
    	calO.setB(Y);
    	calO.setC(Z);
	
    	CAL=calO.calc();
		 
    	A.setText(""+CAL);
		B.setText("");
		C.setText("");
		 */
    	//--------BY METHOD OVERLOADING-------
		
    	/*CAL=calO.calc(X, Y, Z);*/
    	
    	
    	//----------by static method---------
    	/*
    	CAL=Calculator.calc2(X, Y, Z);
    	
    	 A.setText(""+CAL);
    	 B.setText("");
    	 C.setText("");
        */
    
	    //BY SUB CLASS
		/*
    	subCalculator calO=new subCalculator(X, Y, Z,2);
    	CAL=calO.calc();
    
		 A.setText(""+CAL);
		 B.setText("");
		 C.setText("");
    	*/
    	
    }
} 