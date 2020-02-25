package ana.maze;

class NavigateMaze {
	private char[][] maze;
	MyStack stack;
	boolean hasEscaped = false;
	
	NavigateMaze(char[][] maze) {
		this.maze = maze;	
		stack = new MyStack();
	}
boolean hasescaped() {
	return hasEscaped;
}
	boolean isWall (MyCoordinates a) {
		
		if (a.getDisplay() == '1') {
			return false;
		} else
			return true;
	}
	void startNavigation(MyCoordinates coord) {
		if (this.maze[coord.getRow()][coord.getColumn()] == 'E') {
			System.out.println("You typed the exit!");
			return;
		}
		
		stack.push(coord);
		this.maze[coord.getRow()][coord.getColumn()] = 'S';
		
		while(!stack.isEmpty()) {
			

			MyCoordinates currentPos = stack.top();
			
			if (this.maze[currentPos.getRow()][currentPos.getColumn()] == 'E') {
				hasEscaped = true;
				break;
			}
			
			stack.pop();
			if (this.maze[currentPos.getRow()][currentPos.getColumn()] != 'S')
				this.maze[currentPos.getRow()][currentPos.getColumn()] = '+';

			if(currentPos.getColumn() > 0) {   //check north
				if(maze[currentPos.getRow()][currentPos.getColumn()-1] == '0'|| maze[currentPos.getRow()][currentPos.getColumn()-1] == 'E') {
					stack.push(new MyCoordinates(currentPos.getRow(),currentPos.getColumn()-1));			
				}
			}
			if(currentPos.getRow() > 0) {   //check west
				if(maze[currentPos.getRow()-1][currentPos.getColumn()] == '0' || maze[currentPos.getRow()-1][currentPos.getColumn()] == 'E') {
					stack.push(new MyCoordinates(currentPos.getRow()-1,currentPos.getColumn()));					
				}
			}
			if(currentPos.getRow() <= 18) {   //check east
				if(maze[currentPos.getRow()+1][currentPos.getColumn()] == '0' || maze[currentPos.getRow()+1][currentPos.getColumn()] == 'E') {
					stack.push(new MyCoordinates(currentPos.getRow()+1,currentPos.getColumn()));				
				}
			}
			if(currentPos.getColumn() <= 18) {   //check south
				if(maze[currentPos.getRow()][currentPos.getColumn()+1] == '0' || maze[currentPos.getRow()][currentPos.getColumn()+1] == 'E') {
					stack.push(new MyCoordinates(currentPos.getRow(),currentPos.getColumn()+1));
				}
			}
		} // end while loop
		if (hasEscaped) {
			System.out.println("I am free!");
		} else
			System.out.println("Help, I am trapped!");
	}
	
	void printMaze() {
		System.out.print("   ");
		for (int i = 0; i < 20; i++) {
			if (i < 10)
				System.out.print(i + "  ");
			else 
				System.out.print(i+ " ");
		}
		
		System.out.println();
		for (int r = 0; r < 20; r++) { // colum
			if (r < 10)
				System.out.print(r + "  ");
			else 
				System.out.print(r+ " ");
			for (int m = 0; m < 20; m++) { // row
				System.out.print(maze[m][r] + "  ");
			}
			System.out.println();
		}
	}
	 
}