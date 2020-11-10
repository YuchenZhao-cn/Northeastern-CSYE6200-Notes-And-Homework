package edu.neu.csye6200.error;

import java.io.IOException;

public class TestErrorHandler {

	public TestErrorHandler() {
		
	}
	
	public void run() {//constructor
		testCatch();
	}
	
	public void testCatch() {//Catch problems
		
		try {
			testError(6);//This method causes problems
		} catch (IOException e) {
			System.out.println("IO Error caught");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("IA Error caught");
			e.printStackTrace();
		} finally {
			System.out.println("Final cleanup");
		}
		
	}
	
	public void testError(int value) throws IOException {
		if (value > 5) {
		    throw new IOException("This is an IO error");
		}
		if (value < 2)
			throw new IllegalArgumentException("This is an IA error)");
	}
	
	public static void main(String[] args) {
		TestErrorHandler teh = new TestErrorHandler();
		teh.run();
	}

}
