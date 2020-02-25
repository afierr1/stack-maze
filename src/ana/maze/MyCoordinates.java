package ana.maze;

/*
 * This class will hold the coordinates that will be organized
 * in a stack data structure.
 */
class MyCoordinates {
	private char display;
	private int row;
	private int column;
	
	MyCoordinates() {
		//empty constructor
	}
	MyCoordinates(int row, int column) {
		this.row = row;
		this.column = column;
	}

	void setRow(int x) {
		this.row = x;	
	}
	void setColumn(int y) {
		this.column = y;
	}
	void setDisplay(char display) {
		this.display = display;
	}
	int getRow() {
		return this.row;
	}
	int getColumn() {
		return this.column;
	}
	char getDisplay() {
		return this.display;
	}	
	//checks if coordinates are out of bounds
	boolean isOutOfBound() {
		if (this.column > 19 || this.column < 0) {
			return true;
		} else if (this.row < 19 || this.row < 0) {
			return true;
		} else 
			return false;	
	}
	
} // end MyCoordinates


