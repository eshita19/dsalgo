package com.esh.ll;

import java.lang.reflect.GenericArrayType;

/**
 * First in first out
 *
 */
public class Stack extends SinglyLinkedList{
	
	public void push(int elem){ // insertFirst
		insertStart(elem);
	}
	
	public void pop(){ //Delete first
		deleteFirst();
	}
	
	public int  peek(){
		return head.elem;
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.pop();
		stack.display();
	}
	
}
