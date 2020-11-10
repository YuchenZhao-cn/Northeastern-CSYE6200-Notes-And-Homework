package edu.neu.csye6200.ca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.logging.Logger;

import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * Setting the movements of the CACrystals, Thread and the Bottoms
 * @author Yuchen Zhao
 *
 */

public class CACrystalSet implements Runnable,ActionListener {
	
	// Initialize the parameters
	private Thread myThread = null;
	private Runnable myRunnable = null;
	private int reborn = 1;
	private int die = 1;

	CARule rule = new CARule();
	
	JFrame frame = CrystalApp.getFrame();
	
	private boolean paused = false;
	private boolean done = false;
	private boolean running = false;
	
	/**
	 * Setting the thread
	 */
	public CACrystalSet() {
		this.myRunnable = this;
	}
	
	/**
	 * Setting the thread
	 * @param myRunnable
	 */
	public CACrystalSet(Runnable myRunnable) {
		this.myRunnable = myRunnable;
	}
	
	/**
	 * Setting the choices of the Born Bottom
	 * @param cell
	 * @param row
	 * @param col
	 */
	public void Reborn(CACell cell, int row, int col) {
		switch(reborn){
		case 1:
			rule.RuleBorn1(cell, row, col);
			break;
		case 2:
			rule.RuleBorn2(cell, row, col);
			break;
		default:
			break;
		}
	}
	
	/**
	 * Setting the Start Bottom
	 */
	public void startSim() {
		if (myThread == null) {
			myThread = new Thread(myRunnable);
			System.out.println("Thread is created!");
		}
		
		if (!myThread.isAlive()) {
			myThread.start();
			System.out.println("Thread is started!");
		}
		running = true;
		paused = false;
	}
	
	/**
	 * Setting the Pause Bottom
	 */
	public void pauseSim() {
		paused = !paused;
	}
	
	/**
	 * Setting the Stop Bottom
	 */
	public void quitSim() {
		for (int row = 0; row < CARule.field.getHeight(); row++) {
			for (int col = 0; col < CARule.field.getWidth(); col++) {
				CACell cell = CARule.field.get(row, col);
				cell.die();
				cell.change();
			}
		}
		frame.repaint();
		done = false;
		running = false;
		paused = true;
	}
	
	/**
	 * Setting delay method
	 * @param millis
	 */
	private void delayThread(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Overriding run method for runnable interface
	 */
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			while(!done) {
				if (!paused)
					doWork();
				delayThread(200L);
			}
		}
		
		System.out.println("We've stopped the simulation");
		myThread = null;
		running = false;
		
	}
	
	/**
	 * Setting the work that needs to be done each step
	 */
	public void doWork() {
		// Reading the reborn rules
		CrystalApp.comboBox2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				switch((String)CrystalApp.comboBox2.getSelectedItem()) {
				case "Rule 1":
					reborn = 1;
					break;
				case "Rule 2":
					reborn = 2;
					break;
				default:
					break;
				}
			}
		});
		
		// Reading the die rules
		CrystalApp.submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int n = Integer.parseInt(CrystalApp.textfield.getText());
            	die = n;
            }
        });
		
		// Kill all the cells older than the typed in number
		for (int row = 0; row < CARule.field.getHeight(); row++) {
			for (int col = 0; col < CARule.field.getWidth(); col++) {
				CACell cell = CARule.field.get(row, col);
				Reborn(cell, row, col);
				rule.RuleDie(cell, row, col, die);
			}
		}
		
		// Save all the states to another boolean and all the cells grow up one step
		for (int row = 0; row < CARule.field.getHeight(); row++) {
			for (int col = 0; col < CARule.field.getWidth(); col++) {
				CACell cell = CARule.field.get(row, col);
				cell.change();
				cell.grow();
			}
		}
		frame.repaint();
	}
	
	/**
	 * Getting the running boolean of the thread
	 * @return
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * Overriding actionPerformed for ActionListener interface
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
