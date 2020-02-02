package Exersize_1_Recursion;

public class Question_3 {
public static int ReverseNum(int n, int a) {
	
	if( n == 0)
		return a;
	
	a=a*10;
	a=a+n%10;
	n = (n-(n%10))/10;
	return ReverseNum(n, a);
}
public static void main(String[] args) {
	int n=6213;
	int b=0;
	System.out.println(ReverseNum(n, b));
}

}
