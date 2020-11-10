package edu.neu.csye6200.ca;

import java.awt.Color;
import java.awt.Graphics;

/**
 * The stages of the cells
 * @author Yuchen Zhao
 *
 */

public class CACell {
	
	//Initialize the stages
	private boolean alive = false;
	private boolean alive1 = false;
	private int age = 1;
	
	public CACell() {
		
	}
	
	/**
	 * Switching the living state to death
	 */
	public void die() {
		alive1 = false;
		}
	
	/**
	 * Switching the living state to live
	 */
	public void reborn() {
		alive1 = true;
		}
	
	/**
	 * Getting the living state of the cells
	 * @return
	 */
	public boolean isAlive() {
		return alive;
		}
	
	/**
	 * Save the living state of the cells to another boolean
	 */
	public void change() {
		alive = alive1;
	}
	
	/**
	 * The age of the cell plus one
	 */
	public void grow() {
		if (alive)
			age++;
		else age = 0;
	}
	
	/**
	 * Getting the age of the cell
	 * @return
	 */
	public int age() {
		return age;
	}
	
	/**
	 * Initializing the age of the cell
	 */
	public void setage() {
		age = 1;
	}
	
	/**
	 * Draw the cell (Defined as a circle in Blue color)
	 * @param g
	 * @param x
	 * @param y
	 * @param size
	 */
	public void draw(Graphics g, int x, int y, int size) {
		if (alive) {
            g.setColor(Color.BLUE);
            g.fillArc(x, y, size, size, 0, 360);
		}
	}

}
