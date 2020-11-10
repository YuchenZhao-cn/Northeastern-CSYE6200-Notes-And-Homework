package Week3Homework;

import java.io.IOException;

public class Week3Homework {
	public static void main(String[] args) throws IOException
	{
		//Define the 8*8 Map
		char gridMap[][] = new char[8][8];
		for (int row = 0; row < 8; row++)
		{
			for (int col = 0; col < 8; col++)
			{
				gridMap[row][col] = '+';
			}
		}
		
		//Define the Home Position and Integers
		int c = 3;
		int r = 3;
		int c1 = 3;
		int r1 = 3;
		int c2 = 3;
		int r2 = 3;
		int c3 = 3;
		int r3 = 3;
		int c4 = 3;
		int r4 = 3;
		int judge = 3;
		gridMap[r][c] = '0';
		
		//Print the Map and the Rules
		System.out.println("'0' means the robot's position right now");
		System.out.println("'1' means the robot's position one step before");
		System.out.println("'2' means the robot's position two steps before");
		System.out.println("'3' means the robot's position three steps before");
		System.out.println("if '0' is at the same position as '2', there will be a '*' instead");
		System.out.println("if '1' is at the same position as '3', there will be a '/' instead");
		for (int row = 0; row < 8; row++)
		{
			for (int col = 0; col < 8; col++)
			{
				System.out.print(gridMap[row][col] + " ");
				
			}
			System.out.println("");
		}
		
		
		//Read & Execute commands
		char command = 1;
		boolean done = false;
		while (!done)
		{
			if (!((command == 13) || (command == 10)))
			System.out.println("Please enter 'N' or 'E' or 'S' or 'W' to move; Enter 'Q' to Quit");
			command = (char) System.in.read();
			switch(command)
			{
			case 'N':
				if(r == 0)
				{
					System.out.println("Invalid command");
					judge = r;
					break;
				}
				else 
				{
					r--;
					judge = 3;
					break;
				}
			case 'E':
				if(c == 7)
				{
					System.out.println("Invalid command");
					judge = c;
					break;
				}
				else
				{
					c++;
					judge = 3;
					break;
				}
			case 'S':
				if(r == 7)
				{
					System.out.println("Invalid command");
					judge = r;
					break;
				}
				else
				{
					r++;
					judge = 3;
					break;
				}
			case 'W':
				if(c == 0)
				{
					System.out.println("Invalid command");
					judge = c;
					break;
				}
				else
				{
					c--;
					judge = 3;
					break;
				}
			case 'Q':
				done = true;
				break;
			case 13:
				break;
			case 10:
				break;
			default:
				System.out.println("Invalid command");
				break;
			}
			if (((command == 'N') || (command == 'W') || (command == 'S') || (command == 'E')) && !((judge == 0) || (judge == 7)))
			{
	    		r4 = r3; c4 = c3; r3 = r2; c3 = c2; r2 = r1; c2 = c1; r1 = r; c1 = c;
	    		for (int row = 0; row < 8; row++)
	    		{
		    		for (int col = 0; col < 8; col++)
	    			{
	    				gridMap[row][col] = '+';
	    			}
	    		}
	    		    gridMap[r4][c4] = '3';
	    		    gridMap[r3][c3] = '2';
	    		    if (gridMap[r2][c2] == '3')
	    		    	gridMap[r2][c2] = '/';
		    	    else
	    		        gridMap[r2][c2] = '1';
		    	    if (gridMap[r1][c1] == '2')
		        		gridMap[r1][c1] = '*';
		        	else
		        	    gridMap[r1][c1] = '0';
		        	for (int row = 0; row < 8; row++)
		        	{
		        		for (int col = 0; col < 8; col++)
		        		{
	        				System.out.print(gridMap[row][col] + " ");
	        			}
	        			System.out.println("");
	        		}
	        		if ((c == 3) && (r == 3))
	        			System.out.println("You are home!");
			}
		}
	}
}
