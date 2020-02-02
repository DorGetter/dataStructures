package Exersize_6_Stack;

public class question_1 {
	public static class Stack{

		char[] stack;
		int i=0;

		public Stack() {
		}
		public Stack(int size) {
			stack=new char[size];
		}

		public void Push(char a) {
			stack[i++]+=a;
		}
		public void POP() {
			i--;
		}
		public void print() {
			for (int i = 0; i < stack.length; i++) {
				System.out.println(stack[i]);
			}
		}
		public char Peek() {
			return stack[i-1];

		}


	}

	public static boolean Sograim(String a) {

		Stack A=new Stack (a.length());
		A.print();System.out.println();
		
		int j=0;
		for (int i = 0; i < a.length()-1; i++) {
			if (a.charAt(i)== '<'|| a.charAt(i)== '{' || a.charAt(i)== '[' || a.charAt(i)== '(')		
			{
				A.Push(a.charAt(i));
			}
			
			else if (a.charAt(i)== '}'|| a.charAt(i)== ')' || a.charAt(i)== '>' || a.charAt(i)== ']') 
			{
				
				if (a.charAt(i)=='}') {
					if (A.Peek()=='{') 
					{
						A.POP();
					}
					else {
						return false;}
					}
				
				if (a.charAt(i)==')') {
					if (A.Peek()=='(') {A.POP();}
					else return false;}
				
				
				if (a.charAt(i)=='>') {
					if (A.Peek()=='<') {A.POP();}
					else return false;}
				
				if (a.charAt(i)==']') {
					if (A.Peek()=='[') {A.POP();}
					else return false;}
			}
			A.print();
			
		}



		A.print();

		return true; 
	}


	public static void main(String[] args) {
		String a = "{[]}(";
		System.out.println(Sograim(a));
	}
}
