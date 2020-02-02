package Exersize_5_QuickSort;

public class question_4 {

	
	public static boolean isIndexPlusthreeEQtovalue(int [] arr) {
		int start= 0;
		int end= arr.length;
		int mid= arr.length/2;
	return HelpFunc(arr, start, mid, end);
	}

	private static boolean HelpFunc(int [] arr, int start, int mid, int end) {
		// TODO Auto-generated method stub
		
		//stop signs// 
		
		if (arr[mid]==mid+3) {
			return true;
		}			
		if (mid==start || mid== end) {
			return false; 
		}
		
		
		if (arr[mid] < mid+3) {
			start= mid;
			mid= (end+start)/2;
			return HelpFunc(arr, start, mid, end);
		}
		if (arr[mid] > mid+3) {
			end=mid; 
			mid= (start+end)/2;
			return HelpFunc(arr, start, mid, end);
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,6};
		System.out.println(isIndexPlusthreeEQtovalue(arr));
	}
}
