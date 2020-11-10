package edu.neu.csye6200.ca;

import java.util.ArrayList;

/**
 * 2D array of the cells
 * @author Yuchen Zhao
 *
 */

public class CACrystal {
	
	// Initialize the parameters
	private int width;
	private int height;
	private CACell[][] field;
	
	/**
	 * Define the parameters of the 2D array
	 * @param width
	 * @param height
	 */
	public CACrystal(int width, int height) {
		this.width = width;
		this.height = height;
		field = new CACell[height][width];
	}

	/**
	 * Getter of the width
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Getter of the height
	 * @return
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Placing the cells into the places
	 * @param row
	 * @param col
	 * @param o
	 * @return
	 */
	public CACell place(int row, int col, CACell o) {
		CACell cell = field[row][col];
		field[row][col] = o;
		return cell;
	}
	
	/**
	 * Getting the field of the cells
	 * @param row
	 * @param col
	 * @return
	 */
	public CACell get(int row, int col) {
		return field[row][col];
	}
	
	/**
	 * Getting the neighbours of the cell
	 * @param row
	 * @param col
	 * @return
	 */
	public CACell[] getNeighbour(int row, int col) {
		ArrayList<CACell> list = new ArrayList<CACell>();
		if (row % 2 == 1) {
			for ( int i=-1; i<2; i++ ) {
				for ( int j=-1; j<2; j++ ) {
					int r = row+i;
					int c = col+j;
					if ( r >-1 && r<height && c>-1 && c<width && !(r== row && c == col) && !(i == 1 && j == 1) && !(i == -1 && j == 1)) {
						list.add(field[r][c]);
					}
				}
			}
		}
		else {
			for ( int i=-1; i<2; i++ ) {
				for ( int j=-1; j<2; j++ ) {
					int r = row+i;
					int c = col+j;
					if ( r >-1 && r<height && c>-1 && c<width && !(r== row && c == col) && !(i == 1 && j == -1) && !(i == -1 && j == -1) ) {
						list.add(field[r][c]);
					}
				}
			}
		}
		
		return list.toArray(new CACell[list.size()]);
	}

	public CACrystal() {
		
	}

}
