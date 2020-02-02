package Exersize_3_SortSearch;

public class question_6 {
	public static int[] swap(int [] arr, int i ,int j) {
		int temp = arr[i]; 
		arr[i]=arr[j];
		arr[j]=temp;
		return arr;
	}
	
	public static void SortEvenOdd(int [] arr) {
		int pivot = arr.length/2;
		int temp=arr[pivot];
		arr[pivot]=arr[arr.length-1];
		arr[arr.length-1]=temp;
		int j=0; int i=0;
		
		
		while( j != arr.length-1 ) {
			if ( arr[j]%2 != 0 )
				j++;
			
			else {
				arr =swap(arr, i, j);
				i++; j++;
			}
		}
	}
	public static void main(String[] args) {
		int [] arr= {1,2,3,4,15,17,66,34};
		
		
		SortEvenOdd(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
	}
}
