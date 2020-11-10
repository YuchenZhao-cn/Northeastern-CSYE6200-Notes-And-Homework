package edu.neu.csye6200.concrun;

public class MyRunnable implements Runnable {
	
	private String name = "";
	private int ctr = 0;
	private boolean done = false;

	public MyRunnable(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		while (!done) {
			doWork();
			try {
				Thread.sleep(100L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ctr++;
			if ((ctr %10) == 0) // every tenth
				System.out.println("Thread " + name + " - loop # " + ctr);
		}

	}
	
	// Kill some time
		private void doWork() {
			for (int i = 0; i < 100000; i++) {
				double val = Math.exp((double) i);
			}
		}

}
