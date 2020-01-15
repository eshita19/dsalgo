package com.esh.cq;

public class CircularQueue {
	Integer[] queue;
	int front =0;
	int rear = -1;
	final int size;
	
	public CircularQueue(int  size) {
		queue = new Integer[size];
		this.size = size;
		for(int i= 0;i<size; i++){
			queue[i] = null;
		}
	}
	
	public void insert(int element){
		if(isQueueFull()){
			throw new IllegalStateException("Queue is full");
		}
		if(front == -1){
			front = 0;
		}
		rear = (rear+1)%size;
		queue[rear] = element;
	}
	
	public int pop(){
		if(isQueueEmpty()){
			throw new IllegalStateException("Queue is empty");
		}
		int element = queue[front];
		front = (front+1)%size;
		return element;
	}

	
	public boolean isQueueEmpty(){
		return front == -1;
	}
	
	public void display(){
		int i;
		for(i=front; i!=rear; i = (i+1)%size){
			System.out.print(queue[i] + "<-");
		}
		System.out.print(queue[i]+ "<-");
	}
	
	public boolean isQueueFull(){
		boolean isQueueFull = true;
		for(Integer elem: queue){
			if(null == elem){
				isQueueFull = false;
				break;
			}
		}
		return isQueueFull;
	}
	
	public static void main(String[] args) {
		CircularQueue c = new CircularQueue(4);
		c.insert(1);
		c.insert(2);
		c.pop();
		c.display();
	}
}
