package Sorting_Algorithems;

public class Insertion_Sort {

	public static void InsertionSort( int [] arr ) {
	
		for (int i = 0; i < arr.length; i++) {
		int j= i; 
		double a =arr[i]; 
		
		while (j>0 && arr[j-1]>a) {
		arr[j]=arr[j-1];
		j=j-1;
			
		}
		arr[j]=(int) a;
		}
	}
	
	public static void main (String [] args) {
		
	int [] arr= {1,3,2,7,6,5,11};
	InsertionSort(arr);	
	
	for (int i = 0; i < arr.length; i++) {
		System.out.print(arr[i]+"\t");
	}	
		
	}
		
}