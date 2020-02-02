package Exersize_7_Queue;
import java.util.Stack;
import Exersize_7_Queue.Queue;
public class question_4 {

	public static boolean palindrom(String str) {
		
		Queue q= new Queue(str.length());
		Queue s= new Queue(str.length());
		if (str.length()==1) return true;
		if (str.length()%2==0) {
			
			for (int i = 0; i < str.length()/2; i++) {
				q.Add(str.charAt(i));
			}
			for (int i = str.length()-1; i < str.length()/2-1; i--) {
				s.Add(str.charAt(i));
			}
			
		}
		else if (str.length()%2!=0) {
			

			for (int i = 0; i <= str.length()/2; i++) {
				q.Add(str.charAt(i));
			}
			for (int i = str.length()-1; i <= str.length()/2; i--) {
				s.Add(str.charAt(i));
			}
			
		}
		for (int c = 0; c < str.length()/2+1; c++) {
			if (s.Isempty()) {
				return true;
			}
			else
				s.POP();q.POP();
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		String pol = "abaa";
		System.out.println(palindrom(pol));
	}
	
	
}
