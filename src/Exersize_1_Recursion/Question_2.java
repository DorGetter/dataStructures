package Exersize_1_Recursion;

public class Question_2 {
	
	
	public static int PowerOfTwo(int n) {
		
		if (n==0)
			return 1;
		return PowerOfTwo(n-1)+PowerOfTwo(n-1);	
	}
	
	public static void main(String[] args) {
		int n=4;
		System.out.println(PowerOfTwo(n));
	}
}
