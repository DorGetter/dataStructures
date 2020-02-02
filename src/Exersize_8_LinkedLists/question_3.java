package Exersize_8_LinkedLists;

public class question_3 {

	public static class Node<T>{
		public Object data;
		public Node next;
		public Node pre;
		public void Node () {}
	}
	
	public static class CirculeLL{
		Node head;
		Node tail;
		int size;
		
		
		public void add(int data) {
			
			if (head==null) {
				Node node = new Node();
				node.data=data;
				head=node;
				node.next=head;
				node.pre=head;
				tail=node;
				size++;
			}
			else {
				Node n=head;
				add(data,n);
			}
			
		}


		private Object add(int data, Node n) {
			
			if (n.next==head) {
				Node node = new Node();
				node.data=data;
				node.pre=n;
				n.next=node;
				node.next=head;
				head.pre=node;	tail=node; size ++;
			}
			else
				return add(data,n.next);
			return n;
			
		}
		
	}
	
	public static void main(String[] args) {
		CirculeLL l = new CirculeLL();
		
		l.add(2);
		l.add(3);
		
	}
	
}
