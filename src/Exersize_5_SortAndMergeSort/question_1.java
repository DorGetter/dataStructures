package Exersize_5_SortAndMergeSort;

public class question_1 {
	public static void MergingThreeArrays(int[] a, int[]b, int[] c) {
		
		int [] r1=new int[a.length+b.length];
				
		int [] d= Merge(a,b,r1);
		
		int [] e=new int[d.length+c.length];
		e= Merge(d,c,e);
		
		for (int i = 0; i < e.length; i++) {
			System.out.print(e[i]);
		}
	}

	private static int[] Merge(int[] a, int[] b, int[]r1) {
		int i=0,j=0,k=0;
		
		while (i<a.length && j<b.length) {
			if (a[i]==b[j]) {
				r1[k++]=a[i++];
				j++;
			}
			else if (a[i]<b[j]) {
				r1[k++]=a[i++];
			}
			else if (a[i]>b[j]) {
				r1[k++]=b[j++];
		
			}
		}	
		while (i<a.length&& k<r1.length) {
			r1[k++]=a[i++];
		}
		while(j<b.length&&k<r1.length) {
			r1[k++]=b[j++];
		}
		
		return r1;
	}
	
	
	public static void main(String[] args) {
		int []a = {1,2,3,4};
		int []b = {5,6,7};
		int []c = {8,9,10};
		MergingThreeArrays(a, b, c);
		
	}
}
