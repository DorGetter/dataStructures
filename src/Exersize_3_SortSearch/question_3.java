package Exersize_3_SortSearch;
public class question_3{
public static boolean BinarySearch (int[] arr, int a) {

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
				b=(b+1)/2;
			}
			if (a>arr[(b+1) /2]) {
				i=(b+1)/2;
				
			}
			else if
				(a==arr[i])
				return true;
			if (b-i==1 ) {
				return false;
			}
		}
	

	return false;
	}
}
	public static int[] CommonNumbers(int[] a, int[] b, int[] c) {
		
			
		int[] arr =new int [a.length];
		
		int temp =0;
		for (int i = 0; i < a.length; i++) {
				if (BinarySearch(b,a[i])==true && BinarySearch(c, a[i])==true) {
					
					arr[temp]+=a[i];
					temp++;
				}
			}
		int []solution =new int [temp]; 
		for (int i = 0; i < solution.length; i++) {
			solution[i]=arr[i];
		}
		
		return solution;
	
	}
	
public static void main (String [] args) {
	
	int [] arr = {12,13,15,16,19,22,35,36,40};
	int [] arr2= {12,19,40};
	int [] arr3= {13,19,40};
	int [] solution =  CommonNumbers(arr, arr2, arr3);
	for (int i = 0; i < solution.length; i++) {
		System.out.print(solution[i]+"\t");
	}
}
}	
	

