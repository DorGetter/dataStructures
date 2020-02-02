package Exersize_3_SortSearch;

public class question_4 {

	public static boolean BinarySearch(int []arr , int a, int start,int mid, int end) {
		
		//stop statements

		if (start==end||start==mid)
			return false;
		if (a==arr[mid])
			return true;
		
		
		if (a<arr[mid]) {
			end = mid;	mid =(start+end)/2;
			return BinarySearch(arr, a, start, mid, end);
		}
		if (a>arr[mid]) {
			start=mid; mid= (start+end)/2;
			return BinarySearch(arr, a, start, mid, end);
		}
		
		return false;
		
	}
	public static boolean IsSumEqZero(int [] arr) {
		int start=0;
		int mid= (arr.length+1)/2;
		int end= arr.length;
		for (int i = 0; i < arr.length; i++) {
			
			if(BinarySearch(arr,arr[i]*(-1),start,mid,end)==true) {
				return true;
			}
			
		}
		return false;
		
	}
	
	public static void main (String [] args ) {
		int [] arr= {-12,-11,-2,0,1,2,5,6};
		//System.out.println(BinarySearch(arr, 2, 0, 4, 8));
		System.out.println(IsSumEqZero(arr));
	}
}
