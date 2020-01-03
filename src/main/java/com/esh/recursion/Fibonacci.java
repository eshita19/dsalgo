package com.esh.recursion;

/**
 * Definition: 
 * 1. Series of numbers where  each number is sum of last two numbers.
 * 2. The first two numbers by default are 0 and 1.
 * 3. example : 0,1,1,2,3,5
 */
public class Fibonacci {
	static void fibonacciSeries(int[] fib, int index){
		if(index==fib.length){
			return;
		}
		fib[index] = fib[index-1] + fib[index-2];
		fibonacciSeries(fib, index+1);
		
	}
	
	static int fibonacciSum(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fibonacciSum(n - 1) + fibonacciSum(n - 2) +1 ;
	}
	
	static int getAtIndex(int index){
		if(index ==0){
			return 0;
		}
		if(index == 1){
			return 1;
		}
		
		return getAtIndex(index-1) + getAtIndex(index-2);
	}
	
	public static void main(String[] args) {
		int size = 10;
		int[] fib = new int[size];
		fib[0] =  0;
		fib[1] =  1;
		fibonacciSeries(fib, 2);
		for(int num:fib){
			System.out.println(num);
		}
		System.out.println("Sum of 4 fibonacci numbers: " + fibonacciSum(4));
		System.out.println("The number at 6th index: " + getAtIndex(6));
	}
}
