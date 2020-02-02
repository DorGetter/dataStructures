package Exersize_5_SortAndMergeSort;

public class question_4 {
	
	public static boolean IsSumOfTwoElementEQtoA(int [] arr, int a ) {
		
		int i=0,j=arr.length-1;
		while (i!=j) {
			if (arr[i]+arr[j]==a) {
				return true;
			}
			if (arr[i]+arr[j]<a) {
				i++;
			}
			if (arr[i]+arr[j]>a) {
				j--;
			}
		}
		return false;
	}
public static void main(String[] args) {
	int[] arr= {-5,-4,-3,2,3,4,5,6,7};
	int a =14 ; 
	System.out.println(IsSumOfTwoElementEQtoA(arr, a));
}
	

}
