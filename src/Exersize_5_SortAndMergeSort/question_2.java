package Exersize_5_SortAndMergeSort;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class question_2 {
	public static boolean isvalueEQtoIndex(int[] arr) {

		int start=0,mid=arr.length/2,end=arr.length;

		mid = (end+start)/2;

		boolean flag = recursiveSearch(arr,start,mid,end); 

		return flag;
	}

	private static boolean recursiveSearch(int[] arr, int start, int mid, int end) {
		if (arr[mid]==mid) {
			return true; 
		}
		if (start==mid) {
			return false;
		}
		if (arr[mid]<mid) {
			return recursiveSearch(arr, mid, (start+end)/2, end);
		}
		if(arr[mid]>mid) {
			return recursiveSearch(arr, start,(start+mid)/2, mid);
		}
		return false;
	}
	public static void main(String[] args) {
		int[] arr= { -1,0,1,2,4};
		System.out.println(isvalueEQtoIndex(arr));
	}
}
