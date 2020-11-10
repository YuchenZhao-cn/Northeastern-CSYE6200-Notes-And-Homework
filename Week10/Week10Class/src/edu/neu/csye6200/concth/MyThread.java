package edu.neu.csye6200.concth;

public class MyThread extends Thread{
	
	private boolean done = false;
	private int ctr = 0;

	public MyThread(String name) {
		super(name);
	}
	
	public void run() {
		while(!done) {
			doWork();
			ctr++;
			if ((ctr %10) == 0) // every tenth
				System.out.println("Thread " + getName() + " - loop # " + ctr);
		}
	}
	
	// Kill some time
	private void doWork() {
		for (int i = 0; i < 100000; i++) {
			double val = Math.exp((double) i);
		}
	}

}
