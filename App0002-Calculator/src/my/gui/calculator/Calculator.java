package my.gui.calculator;


public class Calculator 
{
   int A,B;
   char C;
	
	public Calculator()
	{
	     A=0;
		 B=0;
		 C='+';
		// TODO Auto-generated constructor stub
	}
	
	public Calculator(int X,int Y,char Z)
	{
	     A=X;
		 B=Y;
		 C=Z;
		// TODO Auto-generated constructor stub
	}
	
	int getA()
	{
		return A;
	}

	void setA(int T)
	{
		A=T;
	}

	int getB()
	{
		return B;
	}

	void setB(int T)
	{
		B=T;
	}

	char getC()
	{
		return C;
	}

	void setC(char Q)
	{
		C=Q;
	}
	
	
	int calc()                     //---------BY OBJECT AND PROPERTIES----------
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
    		
		return CAL;
	}
	/*
	int calc(int L,int M,char P)    //---------BY METHOD OVERLOADING-------------
	{
		int CAL=0;
		
		if (P=='+')
    	    CAL=L+M;
    	else if (P=='-')
  	      CAL=L-M;
    	else if (P=='*')
    	      CAL=L*M;
    	else if (P=='/')
  	      CAL=L/M;
    		
		return CAL;
	}
	
	static int calc2(int L,int M,char P) //---------BY STATIC METHOD------------------
	{
		int CAL=0;
		
		if (P=='+')
    	    CAL=L+M;
    	else if (P=='-')
  	      CAL=L-M;
    	else if (P=='*')
    	      CAL=L*M;
    	else if (P=='/')
  	      CAL=L/M;
    		
		return CAL;
	}
	*/
}