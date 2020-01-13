package com.esh.ll;

//FIFO - First  in First out
public class Queue extends SinglyLinkedList{
	
	public int peek(){
		return head.elem;
	}
	
	public int poll(){
		int elem = head.elem;
		deleteFirst();
		return elem;
	}
	
	public void add(int elem){
		insertEnd(elem);
	}
	
	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.add(1);
		queue.add(2);
		queue.poll();
		queue.display();
	}
}
