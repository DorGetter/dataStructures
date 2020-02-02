package Exersize_5_QuickSort;

public class question_2 {
public static int[] SortatmosttwoElements(int [] arr) {
	
	int i = 0,j=0;
	int mid= arr.length/2;
	swap(arr, mid, arr[0]);
	while ( j!= arr.length-1) {
		
		if ( arr[i]==arr[j]) {	
			j++;}
		if ( arr[i]!=arr[j]) {
			swap(arr,i,j);
			i++;
		}
			
	}
	return arr;
}
public static int[] swap(int [] arr, int i ,int j) {
	int temp = arr[i]; 
	arr[i]=arr[j];
	arr[j]=temp;
	return arr;
}

public static void main(String[] args) {
	int[] arr= {1,1,6,1,1,6,6,6,1,6,1,6,6};
	SortatmosttwoElements(arr);
	for (int i = 0; i < arr.length; i++) {
		System.out.print(arr[i]+"\t");
	}
	
}
}
