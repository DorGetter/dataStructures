package Exersize_3_SortSearch;

public class question_5 {

	public static void IsRepsHalfOfN(int []arr ,int N) {
		int reps= arr.length/2;
		int value = 0 ; 
		int temp=1;
		for (int i = 0; i < arr.length-1; i++) {
			int j = i+1; 
			if (arr[i]==arr[j]) {
				temp++;
			}
			if (arr[i]!=arr[j]) {
				if (temp != reps) {
					temp =1;}
				else {
					value =arr[i];
					System.out.println(value);	
				}
		}
		}
		
	}	
	public static void main(String[] args) {
		int [] arr= {1,1,1,2,2,3};
		IsRepsHalfOfN(arr, arr.length);
	}
	}

