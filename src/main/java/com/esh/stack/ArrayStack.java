package com.esh.stack;

import java.util.ArrayList;

public class ArrayStack<T> {
	T arr[] = (T[])new Object[10];
	int top =-1;
	int MAX_SIZE =10;
	
	public void push(T element) throws Exception{
		if(top +1 == MAX_SIZE){
			throw new Exception("Max size reached");
		}
		arr[++top] = element;
	}
	
	public T pop() throws Exception{
		if(top == -1){
			throw new Exception("No elements in stack");
		}
		T elem = arr[top];
		arr[top] = null;
		top--;
		return elem;
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public void display() throws Exception{
		if(top == -1){
			throw new Exception("No elements in stack");
		}
		System.out.println("Elements in stack are");
		for(int i=0;i<=top; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) throws Exception {
		ArrayStack<Integer> stack = new ArrayStack<>();
		for(int i=0;i<10 ;i++){
			stack.push(i);
		}
		stack.pop();
		stack.display();
	}
	
}
