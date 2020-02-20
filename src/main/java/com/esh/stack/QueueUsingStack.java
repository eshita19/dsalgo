package com.esh.stack;

public class QueueUsingStack {
	ArrayStack baseStack = new ArrayStack();
	ArrayStack bkpStack = new ArrayStack();
	
	//Add elemeent at the bottom of stack
	public void enqueue(int element) throws Exception{
		//Add all elements to bkpstack;
		while(!baseStack.isEmpty()){
			bkpStack.push(baseStack.pop());
		}
		baseStack.push(element);
		
		while(!bkpStack.isEmpty()){
			baseStack.push(bkpStack.pop());
		}
	}
	
	public int dequeue() throws Exception{
		return (int)baseStack.pop();
	}
	
	public void display() throws Exception{
		baseStack.display();
	}
	
	public static void main(String[] args) throws Exception {
		int[] elements = {1,2,3,4,5};
		QueueUsingStack queue = new QueueUsingStack();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.dequeue();
		queue.display();
	}
}
