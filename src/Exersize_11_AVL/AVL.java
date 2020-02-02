	package Exersize_11_AVL;
	
	public class AVL {
		/**
		 * Node class constructor;
		 * @author dorge
		 *
		 */
		public class Node{
			public int height=0;
			public Node parent,left,right; 
			public int data; 
			public Node (int data) {this.data=data;}
		}
	
		private Node root; 
		/**
		 * 
		 * @param data user input.
		 */
		public void insert (int data) {
			if (root==null ) {
				root= new Node(data);
			}
			else 
				root= insert(root,data); 
		}
		/**
		 *  
		 * @param r- Node pointer for traversal down the tree. 
		 * @param data to be inserted to the tree. 
		 * @return
		 */
		private Node insert(Node r, int data) {
	
			if (r == null) {
	
				return new Node (data);
			}
			if (r.data<data) {
				r.right= insert(r.right, data);
				r.right.parent = r;
			}
			else if (r.data>data) {
				r.left= insert (r.left,data);
				r.left.parent = r;
			}
			else 
				return r;
			
			r.height = Math.max(height(r.left), height(r.right))+1;
	
			int balance = balance(r); 
			if(Math.abs(balance) >=(2)) {
				if (balance>=2 &&  r.left!=null && data<r.left.data) {
					return rightRotate(r);
				}
				if (balance>=2 && data>r.left.data) {
					return leftRightRotate(r);
				}
				if(balance<=-2 && r.right!=null && data>r.right.data ) {
					return leftRotate(r);
				}
				if(balance<=-2 && r.right!=null &&data<r.right.data) {
					return rightLeftRotate(r);
				}
			}
			return r;
		}
	
		private Node rightLeftRotate(Node r) {
			r.right= leftRotate(r.right);
			rightRotate(r);
			return r;
		}
	
		private Node leftRightRotate(Node r) {
			r.left= leftRotate(r.left);
			rightRotate(r);
			return r;
		}
		private Node leftRotate(Node y) {
			Node x= y.right;
			Node T2=y.right.left;
			if (T2!=null) {
				T2.parent=y;
			}
			x.left=y;
			x.parent=y.parent;
			y.parent=x;
			y.right=T2;
			y.height= Math.max(height(y.right),height(y.left))+1;
			x.height= Math.max(height(x.right),height(x.left))+1;
			return x;
		}
		private Node rightRotate(Node y) {
			Node x= y.left;
			Node T2=y.left.right;
	
			if (T2!=null) {
				T2.parent=y;
			}
			x.right=y;
			x.parent=y.parent;
			y.parent=x;
	
			y.left=T2;
			y.height= Math.max(height(y.right),height(y.left))+1;
	
			x.height= Math.max(height(x.right),height(x.left))+1;
			return x;
		}
	
		private int balance(Node node) {
			if (node==null) {
				return -1;
			}
			return height(node.left)-height(node.right);
		}
	
		private int height(Node node) {
			if (node==null) {
				return -1;
			}
	
			return node.height;
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
			System.out.println((6-1)/2);
			AVL t= new AVL();
			t.insert(3);
			t.insert(2);
			t.insert(1);
			t.insert(4);
			t.insert(5);
			
			System.out.println(t.root.data);
			System.out.println("parent");
			t.inOrder(t.root);
	
		}
	
	
	}