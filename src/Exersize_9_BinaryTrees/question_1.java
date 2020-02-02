package Exersize_9_BinaryTrees;

public class question_1 {

	public static class Node<T>{

		public Node parent;
		public Node left;
		public Node right;
		public int data;
		public void Node() {}

	}
	public static class BinaryTree{

		public static Node root;
		private static int size=0;

		public void add(int data) {
			if (size==0) {
				Node node= new Node();
				node.data=data;
				root=node;
				size++;
			}
			else {
				Node r=root;
				Add(r,data);
			}
		}

		private  Object Add(Node r, int data) {

			if(data<r.data) {
				if (r.left==null) {
					Node node = new Node ();
					node.data=data;
					node.parent=r;
					r.left=node;
					size ++; 
				}
				else {
					return Add(r.left,data);
				}
			}
			else if (r.data<data) {
				if (r.right==null) {
					Node node = new Node ();
					node.data=data;
					node.parent=r;
					r.right=node;
					size ++; 
				}
				else {
					return Add(r.right,data);
				}

			}

			return data;
			// TODO Auto-generated method stub

		}

		public void InOrderPrint() {

			//left >> parent >> right 
			Node r= root; 
			InOrderPrint(r);



		}

		private void InOrderPrint(Node r) {

			if (r==null) {
				return;
			}
			InOrderPrint(r.left);
			System.out.println(r.data);
			InOrderPrint(r.right);
		}
		private void PreOrderPrint() {
			Node r = root;
			preOreder(r);
		}

		private void preOreder(Node r) {

			if (r==null) {
				return;
			}
			System.out.println(r.data);
			preOreder(r.left);
			preOreder(r.right);
		}

		public int Size1(Node r) {
			if (r==null) {
				return 0; 
			}
			return Size1(r.left)+Size1(r.right)+1; 	
		}
		public Node find (int data) {
			Node r=root;
			if (data==r.data) {
				return r;
			}
			else 
				return find(r,data);
		}
		static Node e;
		private Node find(Node r, int data) {
			
			if (r.data==data) {
				e= r;
			}
			else if (r.data<data) {
				find(r.right, data);
			}
			else if (r.data>data) {
				find(r.left,data);
			}
			return e;

		}
		public String isLeaf(int data) {
			Node r=root; 
			Node a;
			while (r!= null && r!=null) {
				if (r.data==data) {
					if ( r.right==null& r.left==null) {
						return "leaf";
					}
					else if(r.right!=null||r.right!=null) {
						return "inner vertex";
					}
				}
				else if(r.data<data) {
					r=r.right;
				}
				else if(r.data>data) {
					r=r.left;
				}
			}
			return "No such Vertex";
			
		}
	}
	public static void main(String[] args) {
		BinaryTree t = new BinaryTree();
		t.add(5);
		t.add(6);
		t.add(3);
		t.add(9);
		t.InOrderPrint();
		System.out.println();
		t.PreOrderPrint();
		System.out.println();
		System.out.println(t.Size1(t.root));
		System.out.println(t.find(3));
		System.out.println();
		System.out.println(t.isLeaf(9));
		System.out.println(t.isLeaf(3));
		System.out.println(t.isLeaf(6));
	}

}

