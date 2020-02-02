package F_AirplaineProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Node {

	
	double x,y; //default x,y.
	int CounterturnP1; //num of turns
	int CounterturnP2; //num of turns
	int lastTurnP1=0;	//last turn memo
	int lastTurnP2=0;   //last turn memo
	
	int counterP1;		//path counter
	int counterP2; 		//path counter
	double  MinP1;		//value till point
	double  MinP2; 		//value till point
	
	ArrayList<String> PathsString1 = new ArrayList<String>();
	//Queue<String> queue1=new LinkedList<String>();
	//Queue<String> queue2=new LinkedList<String>();
//	public Node(double x, double y, int turnP1, int turnP2, int counterP1, int counterP2, double minP1, double minP2) {
//		this.x = x;
//		this.y = y;
//		this.CounterturnP1 = turnP1;
//		this.CounterturnP2 = turnP2;
//		this.counterP1 = counterP1;
//		this.counterP2 = counterP2;
//		MinP1 = minP1;
//		MinP2 = minP2;
//	}
	
	public Node(double x, double y) {
		this.x = x;
		this.y = y;
		this.PathsString1.add("-->");
	}
	
	
	
	
	
	
	public int getCounterturnP1() {
		return CounterturnP1;
	}
	public void setCounterturnP1(int counterturnP1) {
		CounterturnP1 = counterturnP1;
	}
	public int getCounterturnP2() {
		return CounterturnP2;
	}
	public void setCounterturnP2(int counterturnP2) {
		CounterturnP2 = counterturnP2;
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

	public int getCounterP1() {
		return counterP1;
	}
	public void setCounterP1(int counterP1) {
		this.counterP1 = counterP1;
	}
	public int getCounterP2() {
		return counterP2;
	}
	public void setCounterP2(int counterP2) {
		this.counterP2 = counterP2;
	}
	public double getMinP1() {
		return MinP1;
	}
	public void setMinP1(double minP1) {
		MinP1 = minP1;
	}
	public double getMinP2() {
		return MinP2;
	}
	public void setMinP2(double minP2) {
		MinP2 = minP2;
	}
//	public Queue<String> getQueue1() {
//		return queue1;
//	}
//	public void setQueue1(Queue<String> queue1) {
//		this.queue1 = queue1;
//	}
//	public Queue<String> getQueue2() {
//		return queue2;
//	}
//	public void setQueue2(Queue<String> queue2) {
//		this.queue2 = queue2;
//	}	
		
	public String toString() {
		return ""+"("+this.x+","+this.y+")"+"  : MinP1 ("+this.MinP1+" ) : CounterP1 ("+this.counterP1+" ) .";
	}
	public ArrayList<String> getPathsString1() {
		return PathsString1;
	}
	public void setPathsString1(ArrayList<String> pathsString1) {
		PathsString1 = pathsString1;
	}
	public void AddToPathString(String valueToAdd) {
		for (int i = 1; i < this.PathsString1.size(); i++) {
			String t = PathsString1.get(i);
			PathsString1.set(i,t+PathsString1 ); 
		}
	}
	public String getAllPaths() {
		String path ="";
		for (int i = 1; i < this.PathsString1.size(); i++) {
			path += PathsString1.get(i);
		}
		return path;
	}
	
	
	
	public int getLastTurnP1() {
		return lastTurnP1;
	}
	public void setLastTurnP1(int lastTurnP1) {
		this.lastTurnP1 = lastTurnP1;
	}
	public int getLastTurnP2() {
		return lastTurnP2;
	}
	public void setLastTurnP2(int lastTurnP2) {
		this.lastTurnP2 = lastTurnP2;
	}

	}
	
	

