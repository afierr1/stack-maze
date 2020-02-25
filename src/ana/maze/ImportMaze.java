package ana.maze;

import java.io.File;
import java.util.Scanner;

class ImportMaze {
	private char[][] maze;
	
	ImportMaze(File file) {
		this.maze = new char[20][20];
		createMaze(file);		
	}
	
	private void createMaze(File file) {
		
		try {
			Scanner scan = new Scanner(file);
			int k = 0; // represents row index
			
			while (scan.hasNext()) {
				String input = scan.next();
				
				for (int i = 0; i < 20; i++) { // imports the entire row
					this.maze[i][k] = input.charAt(i);
				}
				k++; // move to next column
			} 
		} catch (Exception e) {
				System.out.println("File not read.");
		}
	}
	
	char[][] getMaze() {
		return maze;
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
	
} // end import class