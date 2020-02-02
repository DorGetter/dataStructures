package Exersize_5_QuickSort;

import Exersize_5_QuickSort.question_3_1_interval.Node;

public class question_3_2_solution {

	
	
	public static double SetsSize(Node [] sets) {
		int i =0; int j=0; 
		int[] index = new int[sets.length] ;
		while (j!=sets.length-1)
		{
			//i include in j or j include in i//
			if ((sets[i].getX() <= sets[j].getY()) && (sets[j].getX() <= sets[i].getY()) ||
					((sets[j].getX() <= sets[i].getY()) && (sets[i].getX() <= sets[j].getY())))
			{
				j++;	
			}
		}
		
		
		
		
		return 0;
		
	}
	public static void main(String[] args) {
		Node a =new Node(0, 3); 
		Node b= new Node(1,2);
		
		Node c= new Node();
		c.x= 5;
		
		
		Node [] arr= {a,b};
		SetsSize(arr);
	}
	
	
	
}
