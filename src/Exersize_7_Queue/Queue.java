package Exersize_7_Queue;
import java.util.Stack;

import Exersize_6_Stack.*;


	public class Queue<T>{

		private Object [] Queue;

		private int front=0, rear=0, capacity=0;

		public Queue(int capacity){
			this.capacity=capacity;
			Queue = new Object[capacity];
		}

		public void Add(Object x ) {
			//if the Queue is still new:
			if (rear==front && front==0 && rear < capacity && front < capacity) {
				Queue[rear++]=x;
			}

			//if they overlapping 
			else if (rear%capacity==front || rear%capacity == front%capacity) {
				System.out.println("Queue is full");
				return;
			}
			//if they are not overlapping:
			else if ( rear%capacity != front%capacity ) {
				//still in first loop

				if (rear < capacity) {
					Queue[rear++]=x;
				}
				else if (rear >= capacity) {
					if (rear%capacity == front%capacity) {
						System.out.println("Queue is full");
						return ;
					}
					else
						Queue[rear%capacity]=x; rear++;
				}
			}

		}
		public Object POP() {
			Object reVal = null;
			if ( front%capacity==rear%capacity) {System.out.println("Queue is empty");}

			else {
				reVal=Queue[front%capacity]; 
				if (front%capacity+1<=rear%capacity) {
					front ++;
				}
			}
			return reVal;

		}
		public boolean Isempty() {
			if (front%capacity==rear%capacity)
				return true;
			
			return false;
		}
		public void Print() {
			System.out.print("Queue: Front <== [");
			if (rear%capacity > front%capacity) {
				for (int i = front%capacity; i < rear%capacity; i++) {
					System.out.print(Queue[i]+"\t");
				}
			}
			else if (rear%capacity <= front%capacity) {
				for (int i = front%capacity; i < Queue.length; i++) {
					System.out.print(Queue[i]+"\t");
				}
				for (int i = 0; i < rear%capacity; i++) {
					System.out.print(Queue[i]+"\t");
				}
			}
			else if (rear%capacity>front%capacity) {
				return;
			}	
			System.out.print("] <== Rear");
		}
		public boolean IsContain(Object val) {
			System.out.println("Item is contained: ");

			if (rear%capacity > front%capacity) {
				for (int i = front%capacity; i < rear%capacity; i++) {
					if (Queue[i]==val) return true;
				}
			}
			else if (rear%capacity <= front%capacity) {
				for (int i = front%capacity; i < Queue.length; i++) {
					if (Queue[i]==val) return true;
				}
				for (int i = 0; i < rear%capacity; i++) {
					if (Queue[i]==val) return true;
				}
			}
			else if (rear%capacity>front%capacity) {	
				return false;
			}	
			return false;
		}
		public Object RetreiveAtIndex(int i) {
			int temp= i+(front%capacity);
			
			if (rear%capacity-1<temp%capacity&& temp%capacity<front%capacity) {
				System.out.println("out of range");
				return false;
			}
			else
				return Queue[temp%capacity];
		}
	}

