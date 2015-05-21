
package my.gui.calculator;

public class subCalculator extends Calculator
{

	int G;
	
	public subCalculator()
	{
		// TODO Auto-generated constructor stub
		 A=0;
		 B=0;
		 C='+';
	}


	public subCalculator(int X, int Y, char Z,int J) 
	{
		super(X, Y, Z);
		G=J;
		// TODO Auto-generated constructor stub
	}
	
	int getG()
	{
		return G;
	}

	void setG(int T)
	{
		G=T;
	}

	int calc()
	{
		int CAL=0;
		
		if (C=='+')
    	    CAL=A+B;
    	else if (C=='-')
  	      CAL=A-B;
    	else if (C=='*')
    	      CAL=A*B;
    	else if (C=='/')
  	      CAL=A/B;
    		
		return CAL*G;
	}

}
