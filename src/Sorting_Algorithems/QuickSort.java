package Sorting_Algorithems;

public class QuickSort {
 public static int [] swap (int arr[], int i , int j ) {
	 
	 int temp= arr[i]; 
	 arr[i]=arr[j]; 
	 arr[j]=temp; 
	 return arr;
 }
 public static int[]  QuickSort(int [] arr,int start , int finish)
 {
	 if (start>=finish) return arr; 
	 int pivot = (int) (Math.random()*(finish-start)+start);
	 //int pivot = (finish+start)/2;
		
	 int temp=arr[pivot];
	// Execute swap 
	 arr[pivot]=arr[finish];
	 arr[finish]=temp;
	 int j=start; int i=start;
	 
	 while ( i <= finish && j != finish ) {
		 
		 if( arr[i] < arr[finish] ) {
			 swap(arr,i,j);
			 i++; j++;
		 }
		 else 
			 j++;
	 }
	 swap(arr,i,finish );
	 QuickSort(arr,0,i-1);
	 QuickSort(arr,i+1, finish);
	 
	 return arr; 
 }
 
public static void main(String[] args) {
int [] arr= { 1,6,32,3,7,97,4};
int [] temp = QuickSort(arr, 0
		, arr.length-1);

for (int i = 0; i < temp.length; i++) {
	System.out.print(temp [i]+"\t" );
}
}	
}
