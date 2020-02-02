package Exersize_10_BinarySearchTrees;

import Exersize_9_BinaryTrees.question_1.Node;

public class question_1 {


	public static class Node<T>{

		public Object data;
		public Node parent; 
		public Node leftC;
		public Node rightC;

		public void Node() {

	}
	public static class BST{

		private Node root; 

		public void add(Object data) {
			Node r=root;
			if ( root == null ) {
				Node newnode= new Node( ); 
				newnode.data=data; 
				newnode.parent=root;
				root=newnode;
			}
			else 
				add(r,data);
		}

		private void add(Node r, Object data) {

			if((int)data<(int)r.data) {
				
				if (r.leftC==null) {
					Node node = new Node ();
					node.data=data;
					node.parent=r;
					r.leftC=node;

				}
				else {
					add(r.leftC,data);
				}
			}
			else if ((int)r.data<(int)data) {
				if (r.rightC==null) {
					Node node = new Node ();
					node.data=data;
					node.parent=r;
					r.rightC=node;

				}
				else {
					add(r.rightC,data);
				}

			}
		}
		
		public int numberofchilds(Object data) {

			Node r=root;
			while(r.data!=data) {
				if ((int)r.data < (int)data) {
					r=r.rightC;
				}
				else if ((int) r.data > (int) data) {
					r=r.leftC;
				}
			}
			int sons=0;
			
				
			sons=sum(r)-1;
			
			
			return sons;
		}

		private int sum(Node r) {
			
			if (r==null) {
				return 0; 
			}
			return sum(r.leftC)+sum(r.rightC)+1; 	
		
		}
	
		public int NumberOfLeaves() {
			Node r =root; 
			int leaves;
			leaves =countingleaves(r);
			
			return leaves; 
		}

		private int countingleaves(Node r) {
			if (r==null) {
				return 0;
			}
			if (r.leftC==null && r.rightC==null ) {
				return 1; 
			}
			return countingleaves(r.rightC)+countingleaves(r.leftC);
			
		}
	
		public int NumberOfVertexATleastOneSon() {
			Node r=root;
			int sum = CountingVertexOnePlus(r);
			return sum;
		}

		private int CountingVertexOnePlus(Node r) {
			
			if(r==null) {
				return 0;
			}
			else if (r.leftC==null && r.rightC==null) {
				return 0;
				
			}
			return CountingVertexOnePlus(r.leftC)+CountingVertexOnePlus(r.rightC)+1 ;
		}		
	
	}

	
	public static void main(String[] args) {
		BST T=new BST();
		T.add(2);
		T.add(3);
		T.add(4);
		T.add(1);
		T.add(8);
		T.add(5);
		T.add(0);
		T.add(10);
		System.out.println(T.numberofchilds(3));
		System.out.println();
		System.out.println(T.NumberOfLeaves());
		System.out.println();
		System.out.println(T.NumberOfVertexATleastOneSon());
	}
}}
