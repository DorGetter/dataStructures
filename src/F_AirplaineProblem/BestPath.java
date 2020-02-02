package F_AirplaineProblem;

import java.text.DecimalFormat;
import java.util.ArrayList;

import F_AirplaineProblem.Node;;

public class BestPath {

	Node[][]mat; 
	Node[][]Clone;
	int teta;
	int numOfPaths =0;
	ArrayList<String> paths = new  ArrayList<String>(numOfPaths);
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

		this.numOfPaths= matt[0][matt[0].length-1].getCounterP1();
		return matt[0][matt[0].length-1].getCounterP1();

	}

	public int getNumOfOptimalPaths() {

		Clone = this.mat.clone();
		matPrint(Clone);

		Clone[Clone.length-1][0].setMinP1(0);
		Clone[Clone.length-1][0].setCounterP1(0);

		//init row
		for (int i = 1; i < Clone[0].length; i++) {
			Clone[Clone.length-1][i].setMinP1(Clone[Clone.length-1][i-1].getX()+Clone[Clone.length-1][i-1].getMinP1());    
			Clone[Clone.length-1][i].CounterturnP1=0;
			Clone[Clone.length-1][i].lastTurnP1=0;
			Clone[Clone.length-1][i].setCounterP1(1);  
		}	matPrint(Clone);
		//init col
		for (int i =Clone.length-2; i >= 0 ; i--) {
			Clone[i][0].setMinP1(Clone[i+1][0].getY()+Clone[i+1][0].getMinP1());
			Clone[i][0].CounterturnP1=0;
			Clone[i][0].lastTurnP1=1;
			Clone[i][0].setCounterP1(1);

		}	matPrint(Clone);



		//go over the matrix:
		for (int i = Clone.length-2; i >= 0; i--) 
		{
			for (int j = 1; j < Clone[0].length; j++) 
			{			

				//if its best to come from left : (by value)
				if(Clone[i][j-1].getMinP1()+Clone[i][j-1].getX() < Clone[i+1][j].getMinP1()+Clone[i+1][j].getY())
				{
					Clone[i][j].setMinP1(Clone[i][j-1].getMinP1()+Clone[i][j-1].getX()); //set new value to me.
					Clone[i][j].setCounterP1(Clone[i][j-1].getCounterP1());

					//update last turn + counter// 
					if(Clone[i][j-1].getLastTurnP1()==1) {
						//need to take a turn to advance to me : 
						//update counter of the turns && set lest turn to 0
						Clone[i][j].CounterturnP1=Clone[i][j-1].getCounterturnP1()+1;
						Clone[i][j].setLastTurnP1(0);

					}
					else 
					{
						//Don't need to take a turn to advance to me : 
						//update counter of the turns && set lest turn to 0
						Clone[i][j].CounterturnP1=Clone[i][j-1].getCounterturnP1();
						Clone[i][j].setLastTurnP1(0);
					}

				}

				//if its best to come from bottom : (by value)
				else if(Clone[i][j-1].getMinP1()+Clone[i][j-1].getX() > Clone[i+1][j].getMinP1()+Clone[i+1][j].getY())
				{
					Clone[i][j].setMinP1(Clone[i+1][j].getMinP1()+Clone[i+1][j].getY());
					Clone[i][j].setCounterP1(Clone[i+1][j].getCounterP1());

					//need to take a turn to advance to me : 
					//update counter of the turns && set lest turn to 1
					if(Clone[i+1][j].getLastTurnP1()==0) {
						Clone[i][j].CounterturnP1=Clone[i+1][j].getCounterturnP1()+1;
						Clone[i][j].setLastTurnP1(1);
					}
					else 
					{
						//Don't need to take a turn to advance to me : 
						//update counter of the turns && set lest turn to 1
						Clone[i][j].CounterturnP1=Clone[i+1][j].getCounterturnP1();
						Clone[i][j].setLastTurnP1(1);
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
					if(Clone[i][j-1].getLastTurnP1()==1 && Clone[i+1][j].getLastTurnP1()==0) {

						Clone[i][j].setMinP1(Clone[i][j-1].getMinP1()+Clone[i][j-1].getX()); //set value

						Clone[i][j].CounterturnP1=Clone[i][j-1].getCounterturnP1()+1; //update turn Counter

						//took from x -->
						Clone[i][j].setLastTurnP1(0);

						Clone[i][j].setCounterP1((Clone[i+1][j].getCounterP1()));

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

					else if(Clone[i][j-1].getLastTurnP1()==0 && Clone[i+1][j].getLastTurnP1()==1) {


						//CHECK IF -- less cheap (by steps) to come from the left :
						if(Clone[i][j-1].getCounterturnP1() < Clone[i+1][j].getCounterturnP1())
						{
							Clone[i][j].setMinP1(Clone[i][j-1].getMinP1()+Clone[i][j-1].getX());
							Clone[i][j].CounterturnP1=Clone[i][j-1].getCounterturnP1();

							//took from x -->
							Clone[i][j].setLastTurnP1(0);

							Clone[i][j].setCounterP1(Clone[i][j-1].getCounterP1());

						}
						else
						{
							Clone[i][j].setMinP1(Clone[i+1][j].getMinP1()+Clone[i+1][j].getY());
							Clone[i][j].CounterturnP1=Clone[i+1][j].getCounterturnP1();
							// 				^
							//took from y 	|
							Clone[i][j].setLastTurnP1(1);
							Clone[i][j].setCounterP1((Clone[i+1][j].getCounterP1()));

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
						if(Clone[i][j-1].getLastTurnP1()==1 && Clone[i+1][j].getLastTurnP1()==1) {

							Clone[i][j].setMinP1(Clone[i+1][j].getMinP1()+Clone[i+1][j].getY());
							Clone[i][j].CounterturnP1=Clone[i+1][j].getCounterturnP1();
							//took from x -->
							Clone[i][j].setLastTurnP1(1);
							Clone[i][j].setCounterP1((Clone[i+1][j].getCounterP1()));
						}

						else if(Clone[i][j-1].getLastTurnP1()==0 && Clone[i+1][j].getLastTurnP1()==0) {

							Clone[i][j].setMinP1(Clone[i][j-1].getMinP1()+Clone[i][j-1].getX());
							Clone[i][j].CounterturnP1=Clone[i][j-1].getCounterturnP1();
							//took from x -->
							Clone[i][j].setLastTurnP1(0);
							Clone[i][j].setCounterP1((Clone[i][j-1].getCounterP1()));
						}
					}

				}
			}
			matPrint(Clone);
		}
		matPrint(Clone);

		return Clone[0][Clone[0].length-1].getCounterP1();
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

		getNumOfCheapestPaths();
		paths = new ArrayList<String>(); 
		buildPathsCheap(new String(), 0, mat[0].length-1,paths);
		return paths; 
	}

	public void buildPathsCheap(String path, int i , int j ,ArrayList<String> paths)  {

		if (i<mat.length-1 && j>0) {
			double a  = mat[i+1][j].getMinP1();
			double a2 = mat[i+1][j].y; 
			double b  = mat[i][j-1].MinP1;
			double b2 = mat[i][j-1].x ;
			double c = mat[i][j].getMinP1();

			if (a+a2 == b+b2){   //a==b 
				buildPathsCheap("1"+path, i+1, j, paths); 
				buildPathsCheap("0" + new String(path), i, j-1, paths) ;
			}
			else if (c-b2 == b) {   
				buildPathsCheap("0"+path, i, j-1, paths);
			}
			else if(c-a2 == a)   {
				buildPathsCheap("1"+path, i+1, j, paths);
			}

		}

		else if (i==mat.length-1 && j==0)  { 
			paths.add(path);  
		}
		else if (i==mat.length-1) {
			String t = new String() ;

			for  (int k=j-1; k >=0 ;k--){ 
				t = t +  "0"   ;
				paths.add(t + path);  

			}
			return;
		}
		else if (j==0) {
			String t = new String();
			for  (int k=i; k <= 0; k++) {
				t = t +  "1";
				paths.add(t + path);

			}
			return;
		}
		return;
	}


	public ArrayList<String> getAllOptimalPaths() {

		getNumOfOptimalPaths();
		paths = new ArrayList<String>(); 
		buildPathsOptimal(new String(), 0, mat[0].length-1,paths);
		return paths; 
	}

	public void buildPathsOptimal(String path, int i , int j ,ArrayList<String> paths)  {

		if (i<mat.length-1 && j>0) {
			double a  = mat[i+1][j].getMinP1();
			double a2 = mat[i+1][j].y; 
			double b  = mat[i][j-1].MinP1;
			double b2 = mat[i][j-1].x ;
			double c = mat[i][j].getMinP1();
			double num = mat[i][j].getCounterP1();
			if (a+a2 == b+b2 && num > 1){   //a==b 
				buildPathsOptimal("1"+path, i+1, j, paths); 
				buildPathsOptimal("0" + new String(path), i, j-1, paths) ;
			}
			else if (c-b2 == b) {   
				buildPathsOptimal("0"+path, i, j-1, paths);
			}
			else if(c-a2 == a)   {
				buildPathsOptimal("1"+path, i+1, j, paths);
			}

		}

		else if (i==mat.length-1 && j==0)  { 
			paths.add(path);  
		}
		else if (i==mat.length-1) {
			String t = new String() ;

			for  (int k=j-1; k >=0 ;k--){ 
				t = t +  "0"   ;
				paths.add(t + path);  

			}
			return;
		}
		else if (j==0) {
			String t = new String();
			for  (int k=i; k <= 0; k++) {
				t = t +  "1";
				paths.add(t + path);

			}
			return;
		}
		return;
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

				System.out.print("P1: "+m[i][j].getMinP1()+", C1: "+m[i][j].getCounterturnP1()+" LT: "+m[i][j].getLastTurnP1()+" Tnum:"+m[i][j].getCounterturnP1()+"count"+m[i][j].getCounterP1()+"\t\t\t");
			}
			System.out.println("\n");
		}
	}
}