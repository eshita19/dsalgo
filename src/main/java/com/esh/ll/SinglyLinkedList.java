package com.esh.ll;

class SNode {
	int elem;
	SNode next;

	SNode(int elem) {
		this.elem = elem;
	}
}

public class SinglyLinkedList {
	static SNode head = null;

	public static void insertEnd(int elem) {
		if (null == head) { // Empty list
			head = new SNode(elem);
		} else {
			SNode prevElem = head;
			for (; prevElem.next != null; prevElem = prevElem.next)
				;
			prevElem.next = new SNode(elem);

		}
	}

	public static void insertStart(int elem) {
		SNode node = new SNode(elem);
		node.next = head;
		head = node;
	}

	public static void insertAt(int elem, int index) {
		SNode node = new SNode(elem);
		SNode temp = head;
		if (null == head && index != 0) { // Empty linked list & new elem index
											// > 0
			throw new IllegalStateException("Index > 0, head null");
		}
		if (null == head && index == 0) { // Empty linked list & new elem index
											// =0
			head = node;
		} else { // Non empty linked list
			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
				if (null == temp) {// index >linked list size
					throw new IllegalStateException("Index > linked list size");
				}
			}
			temp.next = node;
		}
	}

	public static void deleteFirst() {
		if(null == head){
			throw new IllegalStateException("Linked list empty, how can we delete element?!");
		}
		head = head.next;
	}

	public static void deleteLast() {
		if(null == head){
			throw new IllegalStateException("Linked list empty, how can we delete element?!");
		}
		SNode temp = head;
		SNode prev  =  temp;
		while(temp.next !=null){
			prev = temp;
			temp = temp.next;
		}
		prev.next = null;
	}

	public static void deleteAtIndex(int index) {
		if(null == head){
			throw new IllegalStateException("Linked list empty, how can we delete element?!");
		}
		if(index ==0){
			deleteFirst();
		}else{
			SNode prev = head, temp = head;
			int i=0;
			while(temp != null){
				if(i==index){
					break;
				}
				prev =temp;
				temp = temp.next;
				i++;
			}
			prev.next = prev.next.next;
		}

	}
	
	public static void deleteEntireLL(){
		head = null;
	}

	public static boolean isElementPresent(int element) {
		boolean isElementPresent = false;
		if (head != null) {
			SNode temp = head;
			while (temp != null) {
				if (temp.elem == element) {
					isElementPresent = true;
					break;
				}
				temp = temp.next;
			}
		}
		return isElementPresent;
	}

	public static void display() {
		if (null == head) {
			System.out.println("No elements present");
		} else {
			SNode temp = head;
			while (temp != null) {
				System.out.print(temp.elem + " -> ");
				temp = temp.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// Add element to linked list
		System.out.println("Element 4 present? : " + isElementPresent(4));
		insertStart(-2);
		insertEnd(1);
		insertEnd(2);
		deleteAtIndex(1);
		display();
		deleteLast();
		display();
	}
}
