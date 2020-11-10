package edu.neu.csye6200.ca;

/**
 * Setting the rules of initializing, reborn and death
 * @author Yuchen Zhao
 *
 */

public class CARule {
	
	// Initialize the parameters
	static final int height = 400, width = 400;

	static CACrystal field = new CACrystal(height, width);
	
	/**
	 * Setting the first rule of initializing
	 */
	public void RuleInitialize1() {
		for (int row = 0; row < field.getHeight(); row++) {
			for (int col = 0; col < field.getWidth(); col++) {
				field.place(row, col, new CACell());
			}
		}
		
		CACell a = field.get(height / 2, width / 2);
		a.reborn();
		
		for (int row = 0; row < field.getHeight(); row++) {
			for (int col = 0; col < field.getWidth(); col++) {
				CACell cell = field.get(row, col);
				cell.change();
				cell.setage();
			}
		}
	}
	
	/**
	 * Setting the second rule of initializing
	 */
	public void RuleInitialize2() {
		for (int row = 0; row < field.getHeight(); row++) {
			for (int col = 0; col < field.getWidth(); col++) {
				field.place(row, col, new CACell());
			}
		}
		
		for (int i = height / 2; i < height / 2 + 2; i++ ) {
			for (int j = width / 2; j < width / 2 + 2; j++ ) {
				CACell a = field.get(i,  j);
				a.reborn();
			}
		}
		
		for (int row = 0; row < field.getHeight(); row++) {
			for (int col = 0; col < field.getWidth(); col++) {
				CACell cell = field.get(row, col);
				cell.change();
				cell.setage();
			}
		}
	}
	
	/**
	 * Setting the third rule of initializing
	 */
	public void RuleInitialize3() {
		for (int row = 0; row < field.getHeight(); row++) {
			for (int col = 0; col < field.getWidth(); col++) {
				field.place(row, col, new CACell());
			}
		}
		
		CACell a = field.get(height / 4, width / 4);
		a.reborn();
		CACell b = field.get(3 * height / 4, 3 * width / 4);
		b.reborn();
		CACell c = field.get(height / 4, 3 * width / 4);
		c.reborn();
		CACell d = field.get(3 * height / 4, width / 4);
		d.reborn();
		
		for (int row = 0; row < field.getHeight(); row++) {
			for (int col = 0; col < field.getWidth(); col++) {
				CACell cell = field.get(row, col);
				cell.change();
				cell.setage();
			}
		}
	}
	
	/**
	 * Setting the first rule of Born
	 * @param cell
	 * @param row
	 * @param col
	 */
	public void RuleBorn1(CACell cell, int row, int col) {
		CACell[] neighbour = field.getNeighbour(row, col);  // get the neighbors of the cell
		int numOfLive = 0;
		for ( CACell c : neighbour ) {  // calculate the live cells in the neighbors
			if ( c.isAlive() ) {
				numOfLive++;
			}
		}
		if ( numOfLive == 1) { // reborn the cells
			cell.reborn();
		}
	}
	
	/**
	 * Setting the second rule of Born
	 * @param cell
	 * @param row
	 * @param col
	 */
	public void RuleBorn2(CACell cell, int row, int col) {
		CACell[] neighbour = field.getNeighbour(row, col);  // get the neighbors of the cell
		int numOfLive = 0;
		for ( CACell c : neighbour ) {  // calculate the live cells in the neighbors
			if ( c.isAlive() ) {
				numOfLive++;
			}
		}
		if ( numOfLive == 1 || numOfLive == 3 || numOfLive == 5) {  // reborn the cells
			cell.reborn();
		}
	}
	
	/**
	 * Setting the rule of Death
	 * @param cell
	 * @param row
	 * @param col
	 * @param dur
	 */
	public void RuleDie(CACell cell, int row, int col, int dur) {
		if ( cell.isAlive() ) {  // kill the cells
			if ( cell.age() > dur ) {
				cell.die();
			}
		}
	}
	
	/**
	 * Getter of the field
	 * @return
	 */
	public static CACrystal getField() {
		return field;
	}

	public CARule() {
		
	}
}
