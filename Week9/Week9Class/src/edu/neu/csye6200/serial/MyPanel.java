package edu.neu.csye6200.serial;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	
	private int ctr = 0;
	int boxSize = 16;

	public MyPanel() {
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		Dimension size = getSize();
		
		// Fill the background
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, size.width, size.height);
		
		// Draw text
		g2d.setColor(Color.GREEN);
		g2d.drawString("Hello World2d" + ctr++, 10, 20);
		
		// Draw Line
		g2d.setColor(Color.RED);
		g2d.drawLine(0, 0, size.width, size.height);
		
		// Draw an array of boxes
		int maxRows = size.height / (boxSize + 2);
		for (int j = 0; j < maxRows; j++) {
			boolean evenRow = ((j % 2) == 0);
			for (int i = 0; i <= 20; i++) {
				// 0 - 255 Red, Green, Blue
				Color col = new Color(40 + i * 10, 255 - j * 5, 50);
				g2d.setColor(col);
				int shift = evenRow ? 0 : 10;
				g2d.fillRect(i * 18 + shift, 25 + j * 20, boxSize,  boxSize);
			}
		}
	}


}
