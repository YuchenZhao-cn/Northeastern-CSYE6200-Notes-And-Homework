package Week3Class;

import java.io.IOException;

public class Week3Class {
	public static void main(String[] args) throws IOException
	{
		/*
		 * char gridMap[][] = new char[8][8];
		 * public void printMap2()
		 * {
		 * for (int row = 0; row < 8; row++)
				{
					for (int col = 0; col < 8; col++)
					{
						System.out.print(gridMap[row][col] + " ");
						
					}
					System.out.println("");
				}
				printMap(gridMap);
			}
			
			
		 * public void printMap(char map[][])
		 * {
		 * for (int row = 0; row < 8; row++)
				{
					for (int col = 0; col < 8; col++)
					{
						System.out.print(gridMap[row][col] + " ");
						
					}
					System.out.println("");
				}
				printMap(gridMap);
			}
		 */
		
		
		//System.out.println
		System.out.println("Hello World!");
		
		//for loop
		for (int count = 0; count < 10; count++)
		{
			System.out.println("This is 'for' loop " + count);
		}
		
		//while loop
		int counter = 0;
		boolean done = false;
		while(!done)
		{
			System.out.println("This is 'while' loop pass " + counter);
			counter++;
			if (counter == 10) done = true;
		}
		
		//do-while loop
		counter = 0;
		done = false;
		do
		{
			System.out.println("This is 'do-while' loop pass " + counter);
			counter++;
			if (counter == 10) done = true;
		}
		while(!done);
		
		//System.in.read()
		//add "throws IOException" at the beginning
		//switch
		//break
		char inVal;
		done = false;
		while(!done) 
		{
			System.out.println("Enter a value - q to quit");
			inVal = (char) System.in.read();
			System.out.println("We read a " + inVal + " character " + (int) inVal);
			
			switch(inVal)
			{
			case 'a':
			case 'A':
				System.out.println("We found an A *****");
				break;
			case 'b':
				System.out.println("We found an B *****");
				break;
			case 'q':
			case '\n':
				//do nothing
				break;
			default:
				System.out.println("Invalid selection");
					
			}
			
			if (inVal == 'q') done = true;
		}
		System.out.println("End of construction");
		
		//array
		//initializing with literals
		/*
		 * int nums[] = {1,99,12,10,15,45,23,88,90,20};
		//Dynamic allication
		int samples[] = new int [10];
		samples[0] = 12;
		samples[4] = 38;
		samples[9] = 90;
		for (int i = 0; i < samples.length; i++)
			samples[i] = i + 5;
		
		int sqrs[][] = { {1,1},
				{2,2},
				{3,9} };
		int num[][] = new int[5][3];
		
		int numss[] = {1,2,3,4,5,6,7,8,9,10};
		
		int sum = 0;
		for (int x : nums)
			sum += x;
		*/
		char gridMap[][] = new char[8][8];
		
		for (int row = 0; row < 8; row++)
		{
			for(int col = 0; col < 8; col++)
			{
				gridMap[row][col] = '+';
			}
		}
		gridMap[3][5] = '*';//Set a special location
		
		done = false;
		while(!done) 
		{
			System.out.println("Enter a value - q to quit");
			inVal = (char) System.in.read();
			System.out.println("We read a " + inVal + " character " + (int) inVal);
			
			switch(inVal)
			{
			case 'a':
			case 'A':
				System.out.println("We found an A *****");
				break;
			case 'b':
				System.out.println("We found an B *****");
				break;
			case 'p':
				for (int row = 0; row < 8; row++)
				{
					for (int col = 0; col < 8; col++)
					{
						System.out.print(gridMap[row][col] + " ");
						
					}
					System.out.println("");
				}
				done = true;
			default:
				System.out.println("Invalid selection");
					
			}
			
			if (inVal == 'q') done = true;
		}
		System.out.println("End of construction");
		
		
	}
}
