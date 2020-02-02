package Exersize_1_Recursion;

public class Sum {

	public static int Sum(int a, int b) {
		
		if(b ==0 )
			return a;
		
		if(b>0)
		return 1+ Sum(a,b-1);
		else
			return -1 + Sum(a,b+1);
	}
	
	
	


	public static int Sub(int a, int b) {
		
		if (b==0)
			return a; 
		
		if (b>0)
		 return -1+ Sub( a,b-1);
		else 
			return 1+ Sub(a,b+1);
	}
	
	public static void main(String[] args) {
		int a1=-5;
		int b2=2;
		System.out.println(Sub(a1,b2));
		int a=4;
		int b=-2;
		System.out.println(Sum (a,b));
	
	
	}
}

