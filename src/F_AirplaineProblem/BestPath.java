package F_AirplaineProblem;

import java.text.DecimalFormat;
import java.util.ArrayList;

import F_AirplaineProblem.Node;;

public class BestPath {

	Node[][]mat; 
	int teta;
	ArrayList<String> paths = new ArrayList<String>();

	public BestPath(Node[][]mat, int teta) {
		this.mat=mat; 
		this.teta=teta; 
	}


	public int getNumOfCheapestPaths() {

		Node [][] matt = this.mat.clone();
		matPrint(matt);
		matt[matt.length-1][0].setMinP1(0);
		matt[matt.length-1][0].setCounterP1(0);


		for (int i = 1; i < matt[0].length; i++) {
			matt[matt.length-1][i].setMinP1(matt[matt.length-1][i-1].getX()+matt[matt.length-1][i-1].getMinP1());  
			matt[matt.length-1][i].setCounterP1(1);  
		}
		matPrint(matt);


		for (int i =matt.length-2; i >= 0 ; i--) {
			matt[i][0].setMinP1(matt[i+1][0].getY()+matt[i+1][0].getMinP1());
			matt[i][0].setCounterP1(1);

		}
		matPrint(matt);
		for (int i = matt.length-2; i >= 0; i--) 
		{
			for (int j = 1; j < matt[0].length; j++) 
			{

				if(matt[i][j-1].getMinP1()+matt[i][j-1].getX() < matt[i+1][j].getMinP1()+matt[i+1][j].getY())
				{
					matt[i][j].setMinP1(matt[i][j-1].getMinP1()+matt[i][j-1].getX());
					matt[i][j].setCounterP1((matt[i][j-1].getCounterP1()));
				}


				else if(matt[i][j-1].getMinP1()+matt[i][j-1].getX() > matt[i+1][j].getMinP1()+matt[i+1][j].getY())
				{
					matt[i][j].setMinP1(matt[i+1][j].getMinP1()+matt[i+1][j].getY());
					matt[i][j].setCounterP1((matt[i+1][j].getCounterP1()));
				}
				else 
				{
					matt[i][j].setMinP1(matt[i+1][j].getMinP1()+matt[i+1][j].getY());
					matt[i][j].setCounterP1((matt[i+1][j].getCounterP1()+matt[i][j-1].getCounterP1()));
				}
			}
			matPrint(matt);
		}


		return matt[0][matt[0].length-1].getCounterP1();

	}

	public int getNumOfOptimalPaths() {

		Node [][] matt = this.mat.clone();
		matPrint(matt);

		matt[matt.length-1][0].setMinP1(0);
		matt[matt.length-1][0].setCounterP1(0);


		for (int i = 1; i < matt[0].length; i++) {
			matt[matt.length-1][i].setMinP1(matt[matt.length-1][i-1].getX()+matt[matt.length-1][i-1].getMinP1());    
			matt[matt.length-1][i].CounterturnP1=0;
			matt[matt.length-1][i].lastTurnP1=0;
			matt[matt.length-1][i].setCounterP1(1);  
		}	matPrint(matt);

		for (int i =matt.length-2; i >= 0 ; i--) {
			matt[i][0].setMinP1(matt[i+1][0].getY()+matt[i+1][0].getMinP1());
			matt[i][0].CounterturnP1=0;
			matt[i][0].lastTurnP1=1;
			matt[i][0].setCounterP1(1);

		}	matPrint(matt);




		for (int i = matt.length-2; i >= 0; i--) 
		{
			for (int j = 1; j < matt[0].length; j++) 
			{			





				//if its best to come from left : (by value)
				if(matt[i][j-1].getMinP1()+matt[i][j-1].getX() < matt[i+1][j].getMinP1()+matt[i+1][j].getY())
				{
					matt[i][j].setMinP1(matt[i][j-1].getMinP1()+matt[i][j-1].getX()); //set new value to me.
					matt[i][j].setCounterP1((matt[i][j-1].getCounterP1()));

					//update last turn + counter// 
					if(matt[i][j-1].getLastTurnP1()==1) {
						//need to take a turn to advance to me : 
						//update counter of the turns && set lest turn to 0
						matt[i][j].CounterturnP1=matt[i][j-1].getCounterturnP1()+1;
						matt[i][j].setLastTurnP1(0);

					}
					else 
					{
						//Don't need to take a turn to advance to me : 
						//update counter of the turns && set lest turn to 0
						matt[i][j].CounterturnP1=matt[i][j-1].getCounterturnP1();
						matt[i][j].setLastTurnP1(0);
					}

				}





				//if its best to come from bottom : (by value)
				else if(matt[i][j-1].getMinP1()+matt[i][j-1].getX() > matt[i+1][j].getMinP1()+matt[i+1][j].getY())
				{
					matt[i][j].setMinP1(matt[i+1][j].getMinP1()+matt[i+1][j].getY());
					matt[i][j].setCounterP1((matt[i+1][j].getCounterP1()));

					//need to take a turn to advance to me : 
					//update counter of the turns && set lest turn to 1
					if(matt[i+1][j].getLastTurnP1()==0) {
						matt[i][j].CounterturnP1=matt[i+1][j].getCounterturnP1()+1;
						matt[i][j].setLastTurnP1(1);
					}
					else 
					{
						//Don't need to take a turn to advance to me : 
						//update counter of the turns && set lest turn to 1
						matt[i][j].CounterturnP1=matt[i+1][j].getCounterturnP1();
						matt[i][j].setLastTurnP1(1);
					}

				}






				//left and bottom are equal by value of path :
				else 
				{

					//				Turning But Equal
					//come from x,y equal --> now both turns to me 
					//turn	.------>   (me)
					//		^		    ^
					//		|	    	|
					//		|  -------...
					if(matt[i][j-1].getLastTurnP1()==1 && matt[i+1][j].getLastTurnP1()==0) {

						matt[i][j].setMinP1(matt[i][j-1].getMinP1()+matt[i][j-1].getX()); //set value

						matt[i][j].CounterturnP1=matt[i][j-1].getCounterturnP1()+1; //update turn Counter

						//took from x -->
						matt[i][j].setLastTurnP1(0);
						matt[i][j].setCounterP1((matt[i+1][j].getCounterP1()+matt[i][j-1].getCounterP1()));

					}

					// 						Equal 
					//come from x,y equal --> no need to take a turns to me: 
					//turn	.......------> (me)
					//						^
					//						|
					//						.				
					//						.	
					//						.
					//						.

					else if(matt[i][j-1].getLastTurnP1()==0 && matt[i+1][j].getLastTurnP1()==1) {


						//CHECK IF -- less cheap (by steps) to come from the left :
						if(matt[i][j-1].getCounterturnP1() < matt[i+1][j].getCounterturnP1())
						{
							matt[i][j].setMinP1(matt[i][j-1].getMinP1()+matt[i][j-1].getX());
							matt[i][j].CounterturnP1=matt[i][j-1].getCounterturnP1();

							//took from x -->
							matt[i][j].setLastTurnP1(0);

							matt[i][j].setCounterP1(matt[i][j-1].getCounterP1());

						}
						else
						{
							matt[i][j].setMinP1(matt[i+1][j].getMinP1()+matt[i+1][j].getY());
							matt[i][j].CounterturnP1=matt[i+1][j].getCounterturnP1();
							// 				^
							//took from y 	|
							matt[i][j].setLastTurnP1(1);
							matt[i][j].setCounterP1((matt[i+1][j].getCounterP1()));

						}


					}



					//	`					NOT EQUAL 
					//				ONLY ONE PATH IS NEED TO DO TURN: FIND WHO:
					// 		?---->   (ME)

					//		 		  ^
					//				  |?	
					//VALUE IS EQUAL TO ME CHECKING WHO IS CHEAPEST BY TURNS:
					//who took a turn to get to me? 
					else 
					{
						//IF FROM LEFT THERE WAS A TURN:
						if(matt[i][j-1].getLastTurnP1()==1 && matt[i+1][j].getLastTurnP1()==1) {

							matt[i][j].setMinP1(matt[i+1][j].getMinP1()+matt[i+1][j].getY());
							matt[i][j].CounterturnP1=matt[i+1][j].getCounterturnP1();
							//took from x -->
							matt[i][j].setLastTurnP1(1);
							matt[i][j].setCounterP1((matt[i+1][j].getCounterP1()));
						}



						else if(matt[i][j-1].getLastTurnP1()==0 && matt[i+1][j].getLastTurnP1()==0) {



							matt[i][j].setMinP1(matt[i][j-1].getMinP1()+matt[i][j-1].getX());
							matt[i][j].CounterturnP1=matt[i][j-1].getCounterturnP1();
							//took from x -->
							matt[i][j].setLastTurnP1(0);
							matt[i][j].setCounterP1((matt[i][j-1].getCounterP1()));
						}
					}

				}
			}
			matPrint(matt);
		}
		matPrint(matt);

		return matt[0][matt[0].length-1].getCounterturnP1();
	}

	public double getCheapestPrice() {


		Node [][] matt = this.mat.clone();
		matPrint(matt);
		matt[matt.length-1][0].setMinP1(0);

		for (int i = 1; i < matt[0].length; i++) {
			matt[matt.length-1][i].setMinP1(matt[matt.length-1][i-1].getX()+matt[matt.length-1][i-1].getMinP1());  
		}
		matPrint(matt);


		for (int i =matt.length-2; i >= 0 ; i--) {
			matt[i][0].setMinP1(matt[i+1][0].getY()+matt[i+1][0].getMinP1());

		}
		matPrint(matt);
		for (int i = matt.length-2; i >= 0; i--) 
		{
			for (int j = 1; j < matt[0].length; j++) 
			{

				if(matt[i][j-1].getMinP1()+matt[i][j-1].getX() < matt[i+1][j].getMinP1()+matt[i+1][j].getY())
				{
					matt[i][j].setMinP1(matt[i][j-1].getMinP1()+matt[i][j-1].getX());
				}


				else if(matt[i][j-1].getMinP1()+matt[i][j-1].getX() > matt[i+1][j].getMinP1()+matt[i+1][j].getY())
				{
					matt[i][j].setMinP1(matt[i+1][j].getMinP1()+matt[i+1][j].getY());
				}
				else 
				{
					matt[i][j].setMinP1(matt[i+1][j].getMinP1()+matt[i+1][j].getY());
				}
			}
			matPrint(matt);
		}
		return matt[0][matt[0].length-1].getMinP1();
	}


	public int printNumOfTurns() {

		Node [][] matt = this.mat.clone();
		matPrint(matt);
		matt[matt.length-1][0].setMinP1(0);
		StringBuffer sb = new StringBuffer();

		for (int i = 1; i < matt[0].length; i++) {
			matt[matt.length-1][i].setMinP1(matt[matt.length-1][i-1].getX()+matt[matt.length-1][i-1].getMinP1());    
			matt[matt.length-1][i].CounterturnP1=0;
			matt[matt.length-1][i].lastTurnP1=0;
		}
		matPrint(matt);


		for (int i =matt.length-2; i >= 0 ; i--) {
			matt[i][0].setMinP1(matt[i+1][0].getY()+matt[i+1][0].getMinP1());
			matt[i][0].CounterturnP1=0;
			matt[i][0].lastTurnP1=1;
		}

		matPrint(matt);
		for (int i = matt.length-2; i >= 0; i--) 
		{
			for (int j = 1; j < matt[0].length; j++) 
			{			
				if(matt[i][j-1].getMinP1()+matt[i][j-1].getX() < matt[i+1][j].getMinP1()+matt[i+1][j].getY())
				{
					matt[i][j].setMinP1(matt[i][j-1].getMinP1()+matt[i][j-1].getX()); //set new value to me.
					//update last turn + counter// 
					if(matt[i][j-1].getLastTurnP1()==1) {
						//update counter +1
						matt[i][j].CounterturnP1=matt[i][j-1].getCounterturnP1()+1;
						matt[i][j].setLastTurnP1(0);
					}
					else 
					{
						matt[i][j].CounterturnP1=matt[i][j-1].getCounterturnP1();
						matt[i][j].setLastTurnP1(0);
					}
				}

				else if(matt[i][j-1].getMinP1()+matt[i][j-1].getX() > matt[i+1][j].getMinP1()+matt[i+1][j].getY())
				{
					matt[i][j].setMinP1(matt[i+1][j].getMinP1()+matt[i+1][j].getY());

					if(matt[i+1][j].getLastTurnP1()==0) {
						matt[i][j].CounterturnP1=matt[i+1][j].getCounterturnP1()+1;
						matt[i][j].setLastTurnP1(1);
					}
					else 
					{
						matt[i][j].CounterturnP1=matt[i+1][j].getCounterturnP1();
						matt[i][j].setLastTurnP1(1);
					}

				}

				else 
				{
					//come from x,y equal --> now turns to me 
					//turn	.------> (me)
					//		^		^
					//		|		|
					//		|-------.

					if(matt[i][j-1].getLastTurnP1()==1 && matt[i+1][j].getLastTurnP1()==0) {
						matt[i][j].setMinP1(matt[i][j-1].getMinP1()+matt[i][j-1].getX());
						matt[i][j].CounterturnP1=matt[i][j-1].getCounterturnP1()+1;
						int A=0;

						//took from x -->
						matt[i][j].setLastTurnP1(0);
					}


					//come from x,y equal --> now turns to me 
					//turn	.------> (me)
					//				^
					//				|
					//				.

					else if(matt[i][j-1].getLastTurnP1()==0 && matt[i+1][j].getLastTurnP1()==1) {

						matt[i][j].setMinP1(matt[i][j-1].getMinP1()+matt[i][j-1].getX());
						matt[i][j].CounterturnP1=matt[i][j-1].getCounterturnP1();


						//took from x -->
						matt[i][j].setLastTurnP1(0);

					}
					//who took a turn to get to me? 
					else 
					{
						if(matt[i][j-1].getLastTurnP1()==1) {

							matt[i][j].setMinP1(matt[i+1][j].getMinP1()+matt[i+1][j].getY());
							matt[i][j].CounterturnP1=matt[i+1][j].getCounterturnP1();
							//took from x -->
							matt[i][j].setLastTurnP1(1);
						}
						else 
						{

							matt[i][j].setMinP1(matt[i][j-1].getMinP1()+matt[i][j-1].getX());
							matt[i][j].CounterturnP1=matt[i][j-1].getCounterturnP1();
							//took from x -->
							matt[i][j].setLastTurnP1(0);
						}
					}

				}
			}
			matPrint(matt);
		}
		matPrint(matt);

		return matt[0][matt[0].length-1].getCounterturnP1();
	}

	public ArrayList<String> getAllCheapestPaths(){
		int t = getNumOfOptimalPaths();
		allPathsRec();
	}


	public void buildPaths(String path, int i , int j ,ArrayList<String> paths)  {

		if (i>0 && j>0) {
			double a = mat[i-1][j].MinP1+mat[i-1][j].y;  
			double b = mat[i][j-1].MinP1+mat[i][j-1].x ;
			if (a < b) {   
				buildPaths("1"+path, i-1, j, paths);
			}
			else if(a > b)   {
				buildPaths("0"+path, i, j-1, paths);
			}
			else {//a==b 
				buildPaths("1"+path, i-1, j, paths); 
				buildPaths("0" + new String(path), i, j-1, paths) 
			}
		}

		else if (i==0 && j==0)  { 
			paths.add(path);  
		}
		else if (i==0) {
			String t = new String() ;

			for  (int k=0; k< j-1 ;j++){ 
				t = t +  "0"   ;
				paths.add(t + path);  

			}

		}
		else if (j==0) {
			String t = new String();
			for  (int k=0; k <i-1; i++) {
				t = t +  "1";
				paths.add(t + path);
			}
		}

		return buildPaths;
	}


	public ArrayList<String> getAllOptimalPaths() {
		return null;

	}


	public int getNumOfCheapestPaths2() {
		return 0;}


	public int getNumOfOptimalPaths2() {
		return 0;}


	public double getCheapestPrice2() {
		return 0;}

	public int getNumOfTurns2() {
		return 0;}

	public ArrayList<String> getAllCheapestPaths2() {
		return null;}


	public ArrayList<String> getAllOptimalPaths2(){
		return null;}



	public void matPrint(Node [][] m) {
		System.out.println("MinP1");

		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {

				System.out.print("P1: "+m[i][j].getMinP1()+", C1: "+m[i][j].getCounterturnP1()+" LT: "+m[i][j].getLastTurnP1()+"Tnum:"+m[i][j].getCounterturnP1()+"\t\t\t\t");
			}
			System.out.println("\n");
		}
	}
}