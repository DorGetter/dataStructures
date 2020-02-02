package Exersize_8_LinkedLists;

import Exersize_8_LinkedLists.question_1.Node;

public class question_4 {
	public static class Linked_List {

		public Node head;
		private int size=0;

		public void printList() {
			if (head==null) System.out.println("list is empty");
			else {
				Node n = head; 
				while (n!=null) {
				System.out.print(n.data+"\t");
				n=n.next;
				}
			}
		}
		
		public void add(int data) {
			Node node =new Node(); 
			node.data=data;
			if(head==null) {
				head=node;
				node.pre=head;
			}
			else {
			Node n=head;
			Add(data,n);
			}
		}
		private Object Add(int data, Node n ) {
			
			if(n.next==null) {
				Node node=new Node();
				node.data=data;
				n.next=node;
				node.pre=n; 			
			}
			else if (data<n.data) {
				Node node = new Node();
				node.data=data;
				Node temp=n.pre;
				node.pre=temp; 
				node.next=n;
				n.pre=node;
				temp.next=node;	
			}
			else
				return Add(data, n.next);
			return n;
		}



	}

	public static class Node {
		public Node next;
		public int data;
		public Node pre; 
			
		public void Node() {}
	}

	public static Linked_List MergingTestGrades(Linked_List list1, Linked_List list2)	{
	Linked_List list3= new Linked_List();
	
	Node first=list1.head;
	Node second=list2.head;
	
	
	
	
	
	return null;
	
}

	
	
		
	
public static void main(String[] args) {
	Linked_List list1= new Linked_List();
	Linked_List list2= new Linked_List();
	
	list1.add(2);	list1.add(3);	list1.add(4);	list1.add(5);	list1.add(6);	list1.add(8);
	
	
	list2.add(2);	list2.add(4);	list2.add(5);	list2.add(6);	list2.add(7);	list2.add(9);
	list1.printList();
	System.out.println();
	list2.printList();
	
}

}
