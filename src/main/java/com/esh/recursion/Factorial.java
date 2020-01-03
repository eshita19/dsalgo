package com.esh.recursion;

/**
 * 1. Factorial can be found for only positive integer.
 * 2. Denoted by n!
 * 3. Factorial is the product of all integers from 1 to n.
 */
public class Factorial {

	static int factorial(int num) {
		if (num == 0) {
			return 1;
		}
		return num * factorial(num - 1);
	}

	public static void main(String[] args) {
		int num = Integer.valueOf(args[0]);
		if (num < 0) {
			throw new IllegalArgumentException("Factorial can be computed only for positive numbers");
		}
		System.out.println("Factorial of number is: " + factorial(num));
	}
}
