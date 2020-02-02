package Exersize_2_BinarySearch;
import java.util.*;
public class Question_2 {


	public static void main (String [] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Hello welcome to Guess Game");
		System.out.println("Do you want to play?\nif yes press 1\nif not press 0");
		String Enter = sc.nextLine();

		if (Enter=="0") 
			System.out.println("GOOD BYE");
		else
		{
			System.out.println("Hello!\nchoose number from 0 to 1000\nPress 1 when ready");
			String Q3 = sc.nextLine();
			if (Q3=="1") {
				System.out.println("is this is the number you thinking of?");
				getRandomIntegerBetweenRange();
				String isit= sc.nextLine();
				System.out.println("if yes enter 1\nif youre number is less then the number press 2\nif it is higher press 3");
				
			
			
			}
		}


	}

	public static void getRandomIntegerBetweenRange(){
		int x = (int)(Math.random()*((1000-0)+1))+0;
		System.out.println(x);
	}


}
