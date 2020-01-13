package com.esh.ll;

class DNode {
	int elem;
	DNode prev;
	DNode next;

	DNode(int elem) {
		this.elem = elem;
	}
}

public class DoublyLinkedList implements LinkedList {
	DNode head;

	public void insertEnd(int elem) {
		DNode node = new DNode(elem);
		if (null == head) {
			head = node;
		} else {
			DNode temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
			node.prev = temp;
		}
	}

	public void insertStart(int elem) {
		DNode node = new DNode(elem);
		if (null == head) {
			head = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}

	}

	public void insertAt(int elem, int index) {
		if (null == head && index != 0) {
			throw new IllegalStateException("Index is greater than the number of elements");
		}
		if (index == 0) {
			insertStart(elem);
		} else {
			DNode dnode = new DNode(elem);
			DNode temp = head;
			int i = 0;
			while (temp.next != null && i != index) {
				temp = temp.next;
				i++;
			}
			if (i == index) {
				temp.prev.next = dnode;
				dnode.prev = temp.prev;
				dnode.next = temp;
				temp.prev = dnode;
			} else {
				throw new IllegalStateException("Index is greater than the number of elements");
			}

		}
	}

	public void deleteFirst() {
		if(null == head){
			throw new IllegalStateException("No elements to delete..");
		}
		if(head.next != null){
			head.next.prev = null;
		}
		head = head.next;
	}

	public void deleteLast() {
		if(null == head){
			throw new IllegalStateException("No elements to delete..");
		}
		if(null == head.next ){
			deleteFirst();
		}
		DNode temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.prev.next = null;
	}

	public void deleteAtIndex(int index) {

	}

	public void deleteEntireLL() {
	}

	public boolean isElementPresent(int element) {
		// TODO Auto-generated method stub
		return false;
	}

	public void display() {
		if (null == head) {
			System.out.println("No elements present");
		} else {
			DNode temp = head;
			while (temp != null) {
				System.out.print(temp.elem + " <-> ");
				temp = temp.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertStart(1);
		list.insertEnd(2);
		list.insertAt(0, 0);
		list.insertAt(3, 2);
		list.display();
		list.deleteLast();
		list.display();
	}

}
