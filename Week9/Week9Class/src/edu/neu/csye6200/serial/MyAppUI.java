package edu.neu.csye6200.serial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyAppUI implements ActionListener {
	
	private Logger log = Logger.getLogger(MyAppUI.class.getName());
	
	private JFrame frame = null;
	private MyPanel canvas = null;
	
	private JButton startBtn = null;
	private JButton pauseBtn = null;
	private JButton stopBtn = null;
	private JComboBox comboBox = null; // Select between options
	private JPanel mainPanel = null;
	
	private SimControl simCtrl = null;

	public MyAppUI() {
		
		simCtrl = new SimControl(); // Build my simulation (before the GUI)
		initGUI();
	}
	
	private void initGUI() {
		frame = new JFrame();
		frame.setSize(400, 300);
		frame.setTitle("MyAppUI");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		JPanel panel = new JPanel();
//		panel.setBackground(Color.RED);
		frame.setLayout(new BorderLayout());
//		
		frame.add(getMainPanel(), BorderLayout.NORTH);
//		
//		
		canvas = new MyPanel();
		frame.add(canvas, BorderLayout.CENTER);
//		
		frame.setVisible(true);
		
	}
	
	// Create a panel and add buttons to it
	private JPanel getMainPanel() {
		mainPanel = new JPanel();
		
		mainPanel.setLayout(new FlowLayout());
		startBtn = new JButton("Start");
		pauseBtn = new JButton("Pause");
		stopBtn = new JButton("Stop");
		
		startBtn.addActionListener(this);
		//stopBtn.addActionListener(this);
//		stopBtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				canvas.repaint(); // Tell the panel to repaint itself (when ready)
//				System.out.println("STOP CALLED");
//			}
//		});
		
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				simCtrl.startSim();
				setButtonStates();
			}
		});
		
		pauseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				simCtrl.pauseSim();
			}
		});
		
		stopBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				simCtrl.quitSim();
				setButtonStates();
			}
		});
		
		
		mainPanel.add(startBtn);
		mainPanel.add(pauseBtn);
		mainPanel.add(stopBtn);
		
		comboBox = new JComboBox();
		comboBox.addItem("Simple");
		comboBox.addItem("Complex");
		
		mainPanel.add(new JLabel("Rule:"));
		mainPanel.add(comboBox);
		comboBox.addActionListener(this);
		
		setButtonStates();
		
		return mainPanel;
	}
	
	private void setButtonStates() {
		boolean running = simCtrl.isRunning();
		
		startBtn.setEnabled(!running);
		pauseBtn.setEnabled(running);
		stopBtn.setEnabled(running);
	}
	
	public static void main(String[] args) {
		MyAppUI myApp = new MyAppUI();
		System.out.println("MyAppUI is exiting");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		log.info("We recieve an actionEvent " + e);
		
		if (e.getActionCommand().equalsIgnoreCase("Start"))
			System.out.println("Let's start something");
		if (e.getActionCommand().equalsIgnoreCase("Stop"))
			System.out.println("Let's stop something");
	}

}
