package com.core.fullstack.dataStructures;

public class LinkedListImpl {
	
	public static void main(String args[]) {
		LinkedList<String> list = new LinkedList<String>();
		list.
	}
	
	//insert delete 

}

class LinkedList<E> {
	Node<E> head;
	
	public LinkedList() {
	}
	
	public void add(E data) {
		if(head == null) {
			head = new Node(data, head);
			head.data = data;
		}
		
	}
	public void delete(int data) {
		
	}
	public LinkedList<E> get(int data) {
		return null;
	}
	


	private static class Node<E> {
		E data;
		Node<E> next;
		Node() {
			
		}
		Node(E element, Node<E> next) {
			data = element;
			this.next = next;
		}
	}

}
