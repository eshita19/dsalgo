package com.esh.array;

public class ArrayRotation {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int n =2;
		shiftElements(arr.clone(), n);
		juggleElements(arr.clone(), n);
		for(int i=0;i< arr.length; i++){
			System.out.print(arr[i] + "\t");
		}
		
	}
	
	private static void shiftElements(int[] arr, int n){
		int length = arr.length;
		while(n != 0){
			int temp = arr[0];
			for(int i=1; i<length; i++){
				arr[i-1] = arr[i];
			}
			arr[length-1] = temp;
			n--;
		}
	}
	
	private static void juggleElements(int [] arr, int n){
		
	}
}
