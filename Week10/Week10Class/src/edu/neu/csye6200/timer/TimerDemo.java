package edu.neu.csye6200.timer;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
	
	private Timer timer; // A timer to run our task

	public TimerDemo() {
		timer = new Timer(); // Create the timer
		// Task, 3 secs, 1 second periodic
		timer.schedule(new RemindTask(), 3000L, 1000L);
	}
	
	class RemindTask extends TimerTask{
		private int ctr = 0;
		@Override
		public void run() {
			System.out.println("Timer alert " + ctr++);
			Toolkit.getDefaultToolkit().beep(); // Ring bell
			
			if (ctr >= 5) timer.cancel();
		}
		
	}

	public static void main(String[] args) {
		new TimerDemo();
		System.out.println("We're done!!!");
	}

}
