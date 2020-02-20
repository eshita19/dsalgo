package com.esh.stack;

public class MinElemStack {
	ArrayStack stack = new ArrayStack();
	ArrayStack minStack = new ArrayStack();

	public void push(int element) throws Exception {
		if (stack.isEmpty()) {
			stack.push(element);
			minStack.push(element);
		} else {
			stack.push(element);
			int lastMinElem = (int) minStack.pop();
			minStack.push(lastMinElem);
			minStack.push(element < lastMinElem ? element : lastMinElem);
		}
	}
	
	public void pop() throws Exception{
		System.out.println("Min elem in stack: " + minStack.pop());
		System.out.println("Element removed:" + stack.pop());
	}
	
	public static void main(String[] args) throws Exception {
		MinElemStack stack = new MinElemStack();
		stack.push(1);
		stack.pop();
		stack.push(3);
		stack.push(10);
		stack.push(2);
		stack.push(23);
		stack.pop();
	}

}
