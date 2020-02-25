package ana.maze;

/*
 * Implementation of the linked list data structure.
 */

class MyLinkedList {
	private Node head;
	private Node tail;
	
	MyLinkedList() {
		this.head = null;
	}
	
	void insertLast(MyCoordinates a) {
		if (head == null) {
			head = new Node(a);
			tail = head;
			head.previous = null;
		} else {
			tail.next = new Node(a);
			tail.next.previous = tail;
			tail = tail.next;
			tail.next = null;
		}	
	}
	
	void deleteLast() {
		if (tail == head) {
			head = null;
		} else {
		tail.previous.next = null;
		tail = tail.previous;	
		}
	}

	void printList() {
		Node temp = head;
		while ( temp!= null) {
			System.out.println(temp.getCoordinates().getRow() + " " + temp.getCoordinates().getColumn());
			temp = temp.next;
		}
	}
	
	MyCoordinates getHead() {
		if (head == null)
			return null;
		else 
		return head.a;
	}
	MyCoordinates getTail() {
		return tail.a;
	}
	//Only MyLinkedList can see this 
	private class Node {
		private MyCoordinates a;
		private Node next;
		private Node previous;
		
		Node(MyCoordinates a) {
			this.a = a;
		}
		MyCoordinates getCoordinates() {
			return a;
		}
	}
} // end MyLinkedList