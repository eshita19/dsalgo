package com.esh.ll;

class CNode {
	int elem;
	CNode next;

	CNode(int elem) {
		this.elem = elem;
	}
}

public class CircularLinkedList implements LinkedList {
	private CNode head = null;

	public void insertEnd(int elem) {
		CNode node = new CNode(elem);
		// Empty list
		if (null == head) {
			head = node;
			node.next = head;
		}
		CNode temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}
		temp.next = node;
		node.next = head;
	}

	public void insertStart(int elem) {
		CNode node = new CNode(elem);
		// Empty list
		if (null == head) {
			head = node;
			node.next = head;
		}
		CNode temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}
		temp.next = node;
		node.next = head;
		head = node;

	}

	public void insertAt(int elem, int index) {
		CNode node = new CNode(elem);
		if (null == head && index == 0) {
			head = node;
			node.next = head;
		}
		int i = 0;
		CNode temp = head;
		CNode prev = temp;
		while (i != index && temp.next != head) {
			prev = temp;
			temp = temp.next;
			i++;
		}
		if (i == index) {
			prev.next = node;
			node.next = temp;
		} else if (i + 1 == index) {
			insertEnd(elem);
		} else {
			throw new IllegalStateException("Index is greater than the number of elements");
		}

	}

	public void deleteFirst() {
		if (null == head) {
			throw new IllegalStateException("Failed to delete, there are no elements in list!");
		}
		if (head.next == head) {
			head = null;
		} else {
			CNode temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			CNode newHead = head.next;
			temp.next = head.next;
			head = newHead;
		}

	}

	public void deleteLast() {
		if (null == head) {
			throw new IllegalStateException("Failed to delete, there are no elements in list!");
		}
		CNode prev = head, temp = head;
		while (temp.next != head) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = temp.next;
	}

	public void deleteAtIndex(int index) {
		if (null == head) {
			throw new IllegalStateException("Failed to delete, there are no elements in list!");
		}
		if (index == 0) {
			deleteFirst();
		} else {
			CNode prev = head, temp = head;
			int i = 0;
			while (temp.next != head && i != index) {
				prev = temp;
				temp = temp.next;
				i++;
			}
			if (i == index) {
				prev.next = temp.next;
			} else if (i + 1 == index) {
				deleteLast();
			} else {
				throw new IllegalStateException("Failed to delete, index is greater than number of elements");
			}
		}
	}

	public void deleteEntireLL() {
		CNode temp  = head;
		while(temp.next  != head){
			temp = temp.next;
		}
		head = null;
		temp.next = null;
	}

	public boolean isElementPresent(int element) {
		boolean isElementPresent = false;
		CNode temp  = head;
		while(temp.next != head){
			if(temp.elem == element){
				isElementPresent = true;
				break;
			}
			temp = temp.next;
		}
		return isElementPresent;
	}

	public void display() {
		if (head == null) {
			throw new IllegalStateException("Cannot display empty list");
		}
		CNode temp = head;
		do {
			System.out.print(temp.elem + "->");
			temp = temp.next;
		} while (temp != head);
		System.out.println();
	}

	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();
		list.insertAt(1, 0);
		list.insertStart(-1);
		list.insertEnd(2);
		System.out.println("list.isElementPresent 1: " + list.isElementPresent(1));
		list.insertAt(3, 3);
		list.insertEnd(4);
		list.deleteFirst();
		list.deleteLast();
		list.deleteLast();
		list.deleteAtIndex(0);
		list.display();
	}

}
