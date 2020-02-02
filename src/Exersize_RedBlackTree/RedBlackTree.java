package Exersize_RedBlackTree;

import Exersize_11_AVL.AVL.Node;

public class RedBlackTree {
	class Node { 
		Node right, left, parent; 
		int data ; 
		boolean Red=true;
		int blackHeight=0;
		public Node(int data) {this.data=data;} 
	}
	Node root ;

	public void insert (int data ) {
		if ( root == null ) {
			root= new Node(data);
			root.Red=false;
			return;
		}
		Node r=root; 

		root= insert (r,data);
		root.Red = false;
	}
	private Node insert(Node r, int data) {

		if (r==null) {
			return new Node (data);
		}
		if( r.data < data ) {
			r.right= insert(r.right,data);
			r.right.parent=r;
		}	
		else if (r.data > data ) {
			r.left=insert(r.left,data); 
			r.left.parent=r;
		}
		else 	
			return r;

		int check = CheckUncle(r); 

		if(check == 2) {
			ColorFlip(r);
		}
		else if (check == 1) {
			if (IsLeftChild(r)) {
				if(CheckLeftRed(r)) {
					r=rightrotation(r);
				}
				else {

				}
			}

		}
		return r;
	}
	private Node rightrotation(Node father) {

		Node grand= father.parent; 
		Node T2= father.right;
		if(T2 != null) {
			T2.parent = grand;
		}

		father.parent = grand.parent;
		grand.parent = father;
		father.right = grand;
		grand.left = T2;
		father.Red = false;
		grand.Red = true;

		return father;
	}
	private boolean CheckLeftRed(Node father) {
		if (father.left != null) {
			if(father.left.Red)
				return true;
		}
		return false;
	}
	private void ColorFlip(Node father) {
		if (IsLeftChild(father)) {
			father.Red=false;
			father.parent.Red=true; 
			father.parent.right.Red=false;
		}
		else  {
			father.Red=false;
			father.parent.Red=true; 
			father.parent.left.Red=false;
		}

	}
	/**
	 *  0 - no father 
	 *  1 - uncle is black
	 *  2 - uncle is red
	 * @param father
	 * @return
	 */
	private int CheckUncle(Node father) {

		if (father.parent == null )
		{
			return 0;
		}

		if(IsLeftChild(father)) {
			if(father.parent.right == null) {
				return 1;
			}
			else if(father.parent.right.Red) {
				return 2;
			}
			else
				return 1;
		}
		else {
			if(father.parent.left == null) {
				return 1;
			}
			else if(father.parent.left.Red) {
				return 2;
			}
			else
				return 1;
		}

	}
	private boolean IsLeftChild(Node father) {

		if(father.parent.right == father)
			return false;

		return true;
	}
	void inOrder(Node node) { 
		if (node==null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data+"\t");
		inOrder(node.right);
	} 


	public static void main(String[] args) {
		RedBlackTree t= new RedBlackTree();
		t.insert(3);
		t.insert(2);
		t.insert(1);
		t.inOrder(t.root);

	}
}
