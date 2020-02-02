package F_AirplaineProblem;

public class mainRun {
	public static void main(String[] args) {

		
		Node [][] mat = new Node [4][4];
		
		Node one = new Node(2,Double.MAX_VALUE);		Node one2 = new Node(3,Double.MAX_VALUE);		Node one3 = new Node(5,Double.MAX_VALUE);		Node one4 = new Node(Double.MAX_VALUE,Double.MAX_VALUE);
		Node one5 = new Node(4,10);						Node one6 = new Node(3,1);			Node one7 = new Node(1,4);		Node one8 = new Node(Double.MAX_VALUE,8);
		Node one9 = new Node(2,5);						Node one10 = new Node(5,11);		Node one11 = new Node(3,1);		Node one12 = new Node(Double.MAX_VALUE,2);
		Node one13 = new Node(1,3);						Node one14 = new Node(8,4);			Node one15 = new Node(3,8);		Node one16 = new Node(Double.MAX_VALUE,4);
		
		mat[0][0] = one;
		mat[0][1] = one2;
		mat[0][2] = one3;
		mat[0][3] = one4;
		mat[1][0] = one5;
		mat[1][1] = one6;
		mat[1][2] = one7;
		mat[1][3] = one8;
		mat[2][0] = one9;
		mat[2][1] = one10;
		mat[2][2] = one11;
		mat[2][3] = one12;
		mat[3][0] = one13;
		mat[3][1] = one14;
		mat[3][2] = one15;
		mat[3][3] = one16;
		
	int teta =3;
	BestPath BS = new BestPath(mat,teta);
	
	
	//System.out.println(BS.getNumOfCheapestPaths());
	
System.out.println("ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
	
	//System.out.println(BS.printNumOfTurns());
//	System.out.println(BS.getNumOfOptimalPaths());
	System.out.println(BS.getAllCheapestPaths());
	}
	
	
	
}
