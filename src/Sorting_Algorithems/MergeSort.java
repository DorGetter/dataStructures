package Sorting_Algorithems;

public class MergeSort {

	/*
	 * General Idea(Merge Sort):
	 * 1.saving the Mid index in the array.
	 * 2.declare two new arrays:
	 * Array1: in Mid size ,Array2: in size of the remain (length-Mid).
	 *  
	 */



	public static void MergeSort(int [] arr) {
		if (arr.length==1) {
			return;
		}
		int Length = arr.length; 
		mergeSort(arr, Length);
	} 

	private static void mergeSort(int[] arr, int Length) {
		// stop condition if the array reached to size 1  // 
		if (Length ==  1) {
			return;	}
		// for dividing the array to two array we need to declare the mid of the array.  
		int mid = Length / 2;
		// construct the two array for the first divide operation:
		// the LHS array in size middle
		int[] Left  = new int[mid];
		// the RHS array in size of the total length-the size of the RHS array. 
		int[] Right = new int[Length - mid];
		//copy the original array to the RHS and the LHS new arrays: 
		for (int i = 0; i < mid; i++) {
			Left[i] = arr[i];
		}
		for (int i = mid; i < Length; i++) {
			Right[i - mid] = arr[i];
		}
		// after coping return the two sub array the RHS and the LHS back for more splits. 
		mergeSort(Left , mid);
		mergeSort(Right, Length - mid);
		//sending the arrays to the merge function for sort and merge. 
		//sending the original arr ,arrLeft, arrRight, the length of arrLeft, the length of arrRight 
		merge(arr, Left, Right, mid, Length  - mid);
	}

	private static void merge( int[] arr, int[] Left, int[] Right, int left, int right) {

		int i = 0, j = 0, k = 0;

		//working on two arrays while the size of array L/R is higher then the running i (i or j doesnt reach to the full length of either 
		//-arrays keep looping. 

		while (i < left && j < right) {
			// i,j running together checking either arrLeft element smaller the arrRight element
			if (Left[i] <= Right[j]) {
				//if it does let the Original arr element in the next location to be the arrLeft elemnt that have been 
				//confront with element of arrRight. 
				arr[k++] = Left[i++];
				// **** very important ****
				//1. incrementing the index in the Original Arr.
				//2. incrementing the index of arrLeft. 
			}
			// if the element of arrRight is smaller then 
			else{
				arr[k++] = Right[j++];
				// **** very important ****
				//1. incrementing the index in the Original Arr.
				//2. incrementing the index of arrLeft. 
			}
		}
		// if arrRight was smaller the arrLeft: 
		// keep inserting the elements until arrLeft reach to his length. 
		while (i < left) {
			arr[k++] = Left[i++];
		}
		// if arrLeft was smaller the arrRigth: 
		// keep inserting the elements until arrRight reach to his length. 
		while (j < right) {
			arr[k++] = Right[j++];
		}
	}
	public static void main(String[] args) {
		int [] arr = { 1,2,3,4,9,7,6};
		MergeSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
	}

}
