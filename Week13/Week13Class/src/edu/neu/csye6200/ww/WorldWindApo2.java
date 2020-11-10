package edu.neu.csye6200.ww;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import gov.nasa.worldwind.BasicModel;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;

public class WorldWindApo2 {

	private JFrame frame; // Application frame
	private WorldWindowGLCanvas wwd = null;
	private StatusBar statusBar;
	private boolean hasStatusBar = true;
	private LayerPanel layerPanel;
	private boolean hasLayerPanel = true;

	public WorldWindApo2() {
		frame = new JFrame(); // It's a Swing App!!!

		frame.setVisible(false); // Don't see it yet
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true); // We can resize the display
		frame.setLayout(new BorderLayout());

		wwd = new WorldWindowGLVanvas(); // our globe canvas

		wwd.setPreferredSize(new Dimension(1000, 800));
		wwd.setModel(new BasicMode());
		// Add the world to the center area
		frame.getContentPane().add(wwd, BorderLayout.CENTER);

		if (hasStatusBar) {
			statusBar = new StatusBar(); // Create a WW status bard
			frame.getContentPane().add(statusBar, BorderLayout.SOUTH);
			statusBar.setEventSource(wwd); // Get events from the wwd
		}

		if (hasLayerPanel) {
			layerPanel = new LayerPanel(wwd);
			frame.getContentPane().add(layerPanel, BorderLayout.WEST);
		}

		frame.pack();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public static void main(String[] args) {

		WorldWindApo2 wwApp = new WorldWindApo2();

		// Anonymous inner class - running later on the GUI thread
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				wwApp.getFrame().setVisible(true);
			}
		});

	}

}
