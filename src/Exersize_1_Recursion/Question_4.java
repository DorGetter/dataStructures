package Exersize_1_Recursion;

public class Question_4 {

	public static String ReverseStr(String word) {
	
	if(word.length() == 1)
		return word;
	char a= word.charAt(word.length()-1);
	return a+ReverseStr(word.substring(0,word.length()-1));
		
	}
	
	public static void main(String[] args) {
		String a = "abcde";
		System.out.println(ReverseStr(a));
	}
	
}
