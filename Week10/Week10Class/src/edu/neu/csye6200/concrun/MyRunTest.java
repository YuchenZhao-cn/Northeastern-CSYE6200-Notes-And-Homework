package edu.neu.csye6200.concrun;

public class MyRunTest {
	
	MyRunnable myRunA = null;
	Thread threadA = null;
	MyRunnable myRunB= null;
	Thread threadB = null;

	public MyRunTest() {
		myRunA = new MyRunnable("A");
		threadA = new Thread(myRunA);
		
		myRunB = new MyRunnable("B");
		threadB = new Thread(myRunB);
	}
	
	public void run() {
		threadA.start(); // start the thread
		threadB.start(); // start the thread
	}

	public static void main(String[] args) {
		MyRunTest mrtest = new MyRunTest();
		mrtest.run();
	}

}
