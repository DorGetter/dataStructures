package Sorting_Algorithems;

public class Selection_Sort {
	public class Node { 
		
	Node parent, right , left; 
	int data, key; 
	boolean flag=false ; 
	public Node(int data) {this.data=data;}	
	}
	Node head ;
	public void insert ( int data) {
		if (head == null ) {
			head = new Node(data); 
			head=null ;
		}
		else 
			Insert(data, head );
	}
	private Node Insert(int data, Node head2) {
		if ( head == null ) { 
			return head2; 
		}
		else if ( head2.data<data ) { 
			head2.right = Insert(data, head2.right);
		}
		else if ( head2.data>data) {
			head2.left=Insert(data, head2.left);
		}
		else	
			return head2;
		
		return head2;
	}
}
