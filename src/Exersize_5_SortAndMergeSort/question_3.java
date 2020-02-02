package Exersize_5_SortAndMergeSort;

import Exersize_5_SortAndMergeSort.question_3_Node.Node;

public class question_3 {

	public static boolean Ismirror(Node [] points) {

		MergeSort(points, points.length);

		for (int i = 0; i < points.length; i++) {
			System.out.print(points[i].x+","+points[i].y+"\t");
		}
		int i=0,j=points.length-1;
		
		while (i!=j) {
			if (points[i].x == -points[j].x) {
				if (points[i].y==-(points[j].y)) {
					return true;
				}
			}
			else if ( points[i].x < -(points[j].x)) {
			i++;}
			else if (points[i].x >  -(points[j].x)) {
				j--;
			}
			
		}

		return false;

	}

	private static void MergeSort(Node[] points, int length) {

		if ( length == 1) {
			return;
		}
		int mid = length/2; 

		Node[] left =new Node[mid]; 
		Node[] right = new Node[length-mid]; 

		for (int i = 0; i < mid; i++) {
			left[i]=points[i];
		}
		for (int i = mid; i < length; i++) {
			right[i-mid]=points[i];
		}
		MergeSort(right, right.length);
		MergeSort(left, left.length);
		Merge(points, left, right,mid,length -mid);
	}

	private static void Merge(Node[] points, Node[] left, Node[] right, int Left, int Right) {
		int i=0,j=0,k=0;

		//working on two arrays while the size of array L/R is higher the running i (i or j doesnt reach to the full length of either 
		//-arrays keep looping. 

		while (i < Left && j < Right) {


			// i,j running together checking either arrLeft element smaller the arrRight element
			if (left[i].x <= right[j].x) {

				//if it does let the Original arr element in the next location to be the arrLeft elemnt that have been 
				//confront with element of arrRight. 

				points[k++] = left[i++];
				// **** very important ****
				//1. incrementing the index in the Original Arr.
				//2. incrementing the index of arrLeft. 
			}
			// if the element of arrRight is smaller then 
			else 
			{
				points[k++] = right[j++];
				// **** very important ****
				//1. incrementing the index in the Original Arr.
				//2. incrementing the index of arrLeft. 
			}

		}
		// if arrRight was smaller the arrLeft: 
		// keep inserting the elements until arrLeft reach to his length. 
		while (i < Left) {
			points[k++] = left[i++];
		}

		// if arrLeft was smaller the arrRigth: 
		// keep inserting the elements until arrRight reach to his length. 
		while (j < Right) {
			points[k++] = right[j++];
		}

	}

	public static class Node {

		public double x;
		public double y;

		public Node() {
		}

		public Node(double x, double y) {
			this.x=x; this.y=y;
		}
	}

	public static void main(String[] args) {

		Node a=new Node(2,2);
		Node b=new Node(1,3);
		Node c=new Node(3,4);
		Node d=new Node(-2,-2);
		Node e=new Node(4,6);
		Node [] points = {a,b,c,d,e};
		System.out.println(Ismirror(points));
	}
}
