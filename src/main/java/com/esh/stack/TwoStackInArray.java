package com.esh.stack;

public class TwoStackInArray {
	int[] arr = new int[10];
	int top1 =-1;
	int top2=10;
	
	public void push1(int element) throws Exception{
		if(top1+1 == top2){
			throw new Exception("MAX size reached");
		}
		arr[++top1]=element;
	}
	public void push2(int element) throws Exception{
		if(top2-1 == top1){
			throw new Exception("MAX size reached");
		}
		arr[--top2]=element;
	}
	
	public int pop1() throws Exception{
		if(top1 ==-1){
			throw new Exception("Stack 1 is empty");
		}
		return arr[top1--];
	}
	
	public int pop2() throws Exception{
		if(top2 ==10){
			throw new Exception("Stack 2 is empty");
		}
		return arr[top2++];
	}
	
	public void display1(){
		System.out.println("Stack1 elements");
		for(int i=0;i<=top1; i++){
			System.out.print(arr[i] + ", ");
		}
	}

	public void display2(){
		System.out.println("\nStack2 elements");
		for(int i=9;i>=top2; i--){
			System.out.print(arr[i] + ", ");
		}
	}
	
	public static void main(String[] args) throws Exception {
		TwoStackInArray twoStack = new TwoStackInArray();
		twoStack.push1(1);
		twoStack.push2(1);
		twoStack.push1(2);
		twoStack.push2(2);
		twoStack.push1(3);
		twoStack.push2(3);
		twoStack.push1(4);
		twoStack.push2(4);
		twoStack.push1(5);
		twoStack.push2(5);
		twoStack.display1();
		twoStack.display2();
	}

}
