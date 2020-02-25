package ana.maze;

import java.io.File;
import java.util.Scanner;

/*
 * TO-DO: start working on solving the maze
 * Task finished: 
 *  - make linked list 
 *  - implement stack w/ linked list
 *  - import text file
 *  - let user input starting point 
 *  - traverse through maze starting from left and clockwise
 *  - use stack to keep track of potential paths
 *  - mark paths already traveled
 *  
 *  Task to accomplish: 
 *  [FINISHED]
 */
/*
 * INSTRUCTIONS: 
 * to type in a coordinate, user type in a number for the x coordinate and then
 * click enter to type in the y coordinate.
 */

public class StackMaze {
	
	public static void main(String[] args) {
		int xCoord;
		int yCoord;
		File file = new File("maze.txt");
		@SuppressWarnings("resource")
		Scanner userScan = new Scanner(System.in);	
		ImportMaze myMaze = new ImportMaze(file);
		
	
		char[][] maze = myMaze.getMaze();	
		NavigateMaze firstMaze = new NavigateMaze(maze);
		myMaze.printMaze();
		/*
		 * For loop allows user to retype a new coordinate to find an exit.
		 */
		while(!firstMaze.hasEscaped) {
		
			System.out.println("Please enter a starting position(x,y)");
		
			xCoord = userScan.nextInt();
			yCoord = userScan.nextInt();
		
		
			MyCoordinates userCoord = new MyCoordinates(xCoord,yCoord);
		
			userCoord.setDisplay(maze[xCoord][yCoord]);
				
			//check if start point is 1 or E
			while(!firstMaze.isWall(userCoord)) {
				System.out.println("You cannot start from this coordinate. Please type in another starting position (x,y): ");
				xCoord = userScan.nextInt();
				yCoord = userScan.nextInt();
			
				userCoord = new MyCoordinates(xCoord,yCoord);
			
				if (userCoord.isOutOfBound()) {
				continue;
				}
				userCoord.setDisplay(maze[xCoord][yCoord]);
				System.out.println(userCoord.getDisplay());
			}
		
			firstMaze.startNavigation(userCoord);
	
			firstMaze.printMaze();
			if(!firstMaze.hasEscaped) {
			System.out.println("Please try again.");
			}
		} // end for loop
	}// end main class
} // end stackMaze class
/*
 * This class imports the maze from a text file
 */
