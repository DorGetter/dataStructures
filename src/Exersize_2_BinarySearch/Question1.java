package Exersize_2_BinarySearch;

public class Question1 {

	public static boolean BinarySearch(int [] arr, int a) {
		
		if (arr[0]==a)	
			return true;
		if (arr[arr.length-1]==a) 
			return true;
		else {
			int b=arr.length;
			for (int i = 0; i < b; i++) {
				if(a==arr[(b+1)/2])
					return true;
				
				if (a<arr[(b+1) /2]) {
					i=arr.length/2-1;
				}
				if (a>arr[(b+1) /2]) {
					b=arr.length/2;
					
				}
				
				else if
					(a==arr[i])
					return true;
			}
		
	} 
		return false;
}
	public static void main(String[] args) {
		int [] arr= {1,2,3,4,5};
		System.out.println(BinarySearch(arr, 3));
	}
}