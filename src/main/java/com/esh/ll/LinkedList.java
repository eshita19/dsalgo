package com.esh.ll;

public interface LinkedList {
	public void insertEnd(int elem);
	public void insertStart(int elem);
	public void insertAt(int elem, int index);
	public  void deleteFirst();
	public  void deleteLast();
	public  void deleteAtIndex(int index);
	public  void deleteEntireLL();
	public  boolean isElementPresent(int element) ;
	public  void display();
}
