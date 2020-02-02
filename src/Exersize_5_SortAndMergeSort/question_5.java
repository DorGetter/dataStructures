package Exersize_5_SortAndMergeSort;

public class question_5 {

	public static int [] MergingTwoArrays(int [] a, int  [] b) {
		int [] c =new int [b.length];
		
		
		int i=0, j=0;
		
		
		while (i!=a.length) {
			int temp= a[i];
			boolean flag=true;
			flag= BinarySearch(b,temp,0,b.length);
			if (flag==true) {
				c[j++]=a[i];
			}
			i++;
		}
		return c;
	
		}

	private static boolean BinarySearch(int[] arr, int temp,int start, int end) {
		// TODO Auto-generated method stub
		int mid=(start+end)/2;
		
		
		if (arr[mid]==temp) {
			return true;
		}
		if (start==mid || end ==mid) {
			return false;
		}
		else if (arr[mid]<temp) {
			return BinarySearch(arr, temp, mid,end);
		}
		else if (arr[mid]>temp) {
			return BinarySearch(arr, temp, start, mid);
		}
		
		return false;
	}
	
	
	
	
	public static void main(String[] args) {
		int [] a= {1,2,3,4,5,6};
		int [] b= {4,5,6,7,8,9};
		b=MergingTwoArrays(a, b);
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]+"\t");
		}
	}
	
	
	
}
