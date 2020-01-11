package com.esh.array;

/**
 * int[row][col]
 * @author emathur
 */
public class TwoDArray {

	public static boolean search(int[][] arr, int num){
		boolean found = false;
		outer: for(int[] ar: arr){
			for(int elem: ar){
				if(elem == num){
					found = true;
					break outer;
				}
			}
		}
		return found;
	}
	
	public static String findIndex(int[][] arr, int num){
		String index = "00";
		int rowNum =0, colNum= 0 ;
		outer: for(int[] ar: arr){
			colNum= 0;
			for(int elem: ar){
				if(elem == num){
					index = rowNum + "" + colNum;
					break outer;
				}
				colNum++;
			}
			rowNum ++;
		}
		return index;
	}
	
	public static void main(String[] args) {
		int [] [] arr = {{1,2,3}, {4,5,6}};
		//Search for an element in array
		System.out.println("Is 5 present in array? " + search(arr, 5));
		//Find index of element in array
		System.out.println("Get index of 5: " + findIndex(arr, 5));
	}
}
