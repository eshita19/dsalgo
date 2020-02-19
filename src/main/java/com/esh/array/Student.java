package com.esh.array;

import java.util.TreeSet;

interface A{
	void display();
}

interface B{
	void display();
}
public class Student implements A,B {
	int rollNum;
	Student(int rollNum){
		this.rollNum = rollNum;
	}
	
	 public static void main(String[] args) 
	    { 
	        TreeSet<String> treeSet = new TreeSet<>(); 
	  
	        treeSet.add("a"); 
	        treeSet.add("Geek"); 
	  
	        for (String temp : treeSet) 
	            System.out.printf(temp + " "); 
	  
	        System.out.println("\n"); 
	    } 
	
	public static void swap(Student s1, Student s2){
		Student temp = s1;
		s1 = s2;
		s2=temp;
	}

	public void display() {
		System.out.println("Display method");
	}

}
