package Exersize_11_MinHeap;

public class MinHeap {
	private int [] arr ;
	private int index=0; 
	public MinHeap(int size) {	
		arr =new int [size]; 
	}
	public void insert( int data ) {
		if (index==arr.length) {
			ReSize();
		}
		arr[index]=data; 
		heapifyUp();		
		index ++;
	}
	private void heapifyUp() {
		int tindex =index;
		int parent = (tindex-1)/2; 
		while (arr[tindex]<arr[parent] && parent>=0) {
			int temp = arr[tindex];
			arr[tindex]=arr[parent];
			arr[parent]=temp;
			tindex=parent;
			parent=(tindex-1)/2;
		}	
	}
	private void ReSize() {
		int[] temp= new int [arr.length*2];
		for (int i = 0; i < arr.length; i++) {
			temp[i]=arr[i];
		}
		arr=temp;
	}
	
	public void Pop () {
		int temp= arr[0];
		arr[0]=arr[index-1];
		index -- ; 
		heapifyDown();
		
	}
	private void heapifyDown() {
		int tindex= 0;
		while (tindex < index && tindex*2+1 < index && tindex*2+2 < index)
		if (arr[tindex*2+1]<arr[tindex*2+2]) {
			int temp = arr[tindex];
			arr[tindex]=arr[tindex*2+1];
			arr[tindex*2+1]=temp;
			tindex=tindex*2+1;
		}
		else if (arr[tindex*2+1]>arr[tindex*2+2]) {
			int temp = arr[tindex];
			arr[tindex]=arr[tindex*2+2];
			arr[tindex*2+2]=temp;
			tindex=tindex*2+2;
		}
		
	}
	public void print() {
		for (int i = 0; i < index; i++) {
			System.out.print(arr[i]+"\t");
		}
	}
	

	public static void main(String[] args) {
		MinHeap h= new MinHeap(4);
		h.insert(2);
		h.insert(3);
		h.insert(1);
		h.insert(8);
		h.insert(0);
		h.print();
		h.Pop();
		System.out.println();
		h.print();
		h.Pop();
		System.out.println();
		h.print();
		int key=10;
		int m=100;
		System.out.println(((((Math.sqrt(5)-1)/2)*key)%1)*m);
	}
}
