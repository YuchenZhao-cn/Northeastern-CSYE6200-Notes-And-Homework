package edu.neu.csye6200.ui2;

public class SimControl implements Runnable {
	
	private Thread myThread = null;
	private Runnable myRunnable = null;
	
	private boolean paused = false; // I'm paused, so don't work
	private boolean done = false;
	
	// I'm my own runnable
	public SimControl() {
		this.myRunnable = this;
	}
	
	// An external class is the runnable
	public SimControl(Runnable myRunnable) {
		this.myRunnable = myRunnable;
	}
	
	public void startSim() {
		if (myThread == null)
			myThread = new Thread(myRunnable); // Create a new Thread
		
		if (!myThread.isAlive())
			myThread.start();
	}
	
	public void pauseSim() {
		
		paused = !paused; // toggle the 'paused' state on/off
		
	}
	
	public void quitSim() {
		done = true; // Flag that we want to quit the sim
	}
	// Slow down the thread by sleeping
	private void delayThread(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(!done) {
			if (!paused)
				doWork();
			delayThread(500L); // half-second sleep
			
		}
		System.out.println("We've stopped the simulation");
		myThread = null; // flat that we don't need the thread
	}
	
	int ctr = 0;
	public void doWork() {
		System.out.println("Did some work - ctr " + ctr++);
	}

}
