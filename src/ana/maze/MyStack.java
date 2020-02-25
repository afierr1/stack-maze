package ana.maze;

class MyStack extends MyLinkedList{
	
	void push(MyCoordinates a) {
		insertLast(a);
	}
	void pop() {
		deleteLast();
	}
	MyCoordinates top() {
		return getTail();
	}
	
	boolean isEmpty() {
		if (getHead() == null)
			return true;
		else 
			return false;
	}
} // end stack class
/*
 * This class will hold the coordinates that will be organized
 * in a stack data structure.
 */
