package Exersize_8_LinkedLists;

public class question_1 {
	
	public static class Node {
		public Node next;
		public int data;
		public Node pre; 
			
		public void Node() {}
		
		
	}
	
	public static class Linked_List {

		Node head;
		int size=0;

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

	
	
	
	public static void main(String[] args) {
		Linked_List list= new Linked_List();

		list.printList();
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(2);
		System.out.println();
		list.printList();
	}
}
