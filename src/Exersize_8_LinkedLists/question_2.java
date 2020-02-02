package Exersize_8_LinkedLists;

public class question_2 {
	
		public static class Node {
			public Node next;
			public int data;
			public Node pre; 
			public void Node() {}
			
		}
		
		public static class StackNode {

			Node head;
			Node tail;
			
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
			
			public void push(int data) {
				Node node =new Node(); 
				node.data=data;
				if(head==null) {
					head=node;
					tail=node;
					size++;
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
					tail=node;
					node.pre=n;
					size++;
				}
				else {
					return Add(data, n.next);}
				return n;
			
		}
			public int pop() {
				int temp =tail.data;
				tail=tail.pre;
				tail.next=null;
				return temp;
				
			}
			public boolean Isempty() {
				if (head==null) {
					return true;
				}
				else 
					return false;
			}
			
			 
			

		}

		
		
		
		public static void main(String[] args) {
			StackNode list= new StackNode();

			list.printList();
			list.push(1);
			list.push(3);
			list.push(4);
			list.push(2);
			System.out.println();
			list.printList();
			System.out.println();
			System.out.println(list.pop());
			System.out.println();
			list.printList();
		}
	}

