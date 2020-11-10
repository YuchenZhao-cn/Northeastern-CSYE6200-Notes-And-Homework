package edu.neu.csye6200.ca;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Setting the JPanel
 * @author Yuchen Zhao
 *
 */
public class CAPanel extends JPanel {
	private static final long serialVersionUID = -5258995676212660595L;
	private static final int GRID_SIZE = 2;
	private CACrystal theField;
	
	public CAPanel(CACrystal field) {
		theField = field;
	}

	/**
	 * Overriding the paint method of JPanel
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for ( int row = 0; row<theField.getHeight(); row++ ) {
			if (row % 2 == 1) {
				for ( int col = 0; col<theField.getWidth(); col++ ) {
					CACell cell = theField.get(row, col);
					if ( cell != null ) {
						cell.draw(g, col*GRID_SIZE, row*GRID_SIZE, GRID_SIZE);
					}
				}
			}
			else {
				for ( int col = 0; col<theField.getWidth(); col++ ) {
					CACell cell = theField.get(row, col);
					if ( cell != null ) {
						cell.draw(g, col*GRID_SIZE+ GRID_SIZE / 2, row*GRID_SIZE, GRID_SIZE);
					}
				}
			}
			
		}
		
	}

	/**
	 * Overriding the getPreferredSize method of JPanel
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(theField.getWidth()*GRID_SIZE+1, theField.getHeight()*GRID_SIZE+1);
	}


}
