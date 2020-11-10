package edu.neu.csye6200.ca;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Setting the Crystal App
 * @author Yuchen Zhao
 *
 */

public class CrystalApp extends CAApp{
	
	// Initialize the parameters
	private Logger log = Logger.getLogger(CrystalApp.class.getName());
	
	CACrystal field = CARule.getField();
	static JFrame frame = new JFrame();
	
	CARule rule = new CARule();
	
	private JButton startBtn = null;
	private JButton stopBtn = null;
	private JButton pauseBtn = null;
	private JComboBox comboBox1 = null;
	
	public static JComboBox comboBox2 = null;
	public static JButton submit = null;
	public static JTextField textfield = null;
	
	private JPanel mainPanel = null;
	private CACrystalSet simCtrl = null;
	
	private int Initialize = 1;

	public CrystalApp() {
		caApp();
	}
	
	/**
	 * Setting the initializing rule selections
	 */
	public void RuleInitialize() {
		switch(Initialize){
		case 1:
			rule.RuleInitialize1();
			break;
		case 2:
			rule.RuleInitialize2();
			break;
		case 3:
			rule.RuleInitialize3();
			break;
		default:
			break;
		}
	}
	
	/**
	 * Sample App constructor
	 */
	private void caApp() {
		CAPanel view = new CAPanel(field);
		frame.add(getNorthPanel(), BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setTitle("Crystal");
		frame.add(view);
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * Overriding the method of interface class
	 */
	@Override
	public JPanel getNorthPanel() {
		mainPanel = new JPanel();
		
		mainPanel.setLayout(new FlowLayout());
		startBtn = new JButton("Start");
		pauseBtn = new JButton("Pause");
		stopBtn = new JButton("Stop");
		
		startBtn.addActionListener(this);
		
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				simCtrl.startSim();
				RuleInitialize();
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
		
		comboBox1 = new JComboBox();
		comboBox1.addItem("Rule 1");
		comboBox1.addItem("Rule 2");
		comboBox1.addItem("Rule 3");
		
		comboBox1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				switch((String)comboBox1.getSelectedItem()) {
				case "Rule 1":
					Initialize = 1;
					break;
				case "Rule 2":
					Initialize = 2;
					break;
				case "Rule 3":
					Initialize = 3;
					break;
				default:
					break;
				}
			}
		});
		
		comboBox2 = new JComboBox();
		comboBox2.addItem("Rule 1");
		comboBox2.addItem("Rule 2");
		
		mainPanel.add(new JLabel("InitializeRule:"));
		mainPanel.add(comboBox1);
		comboBox1.addActionListener(this);
		
		mainPanel.add(new JLabel("RebornRule:"));
		mainPanel.add(comboBox2);
		comboBox2.addActionListener(this);
		
		mainPanel.add(new JLabel("CA lifetime(number only):"));
		textfield = new JTextField(8);
        mainPanel.add(textfield);
        
        submit = new JButton("submit");
        
        mainPanel.add(submit);

		simCtrl = new CACrystalSet();
		setButtonStates();
		
		return mainPanel;
	}
	
	/**
	 * Setting the states of start, pause and stop buttons
	 */
	private void setButtonStates() {
		boolean running = simCtrl.isRunning();
		
		startBtn.setEnabled(!running);
		pauseBtn.setEnabled(running);
		stopBtn.setEnabled(running);
	}

	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) {
		CrystalApp test = new CrystalApp();
		System.out.println("MyAppUI is exiting");
	}

	/**
	 * Overriding the method of ActionListener interface
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		log.info("We recieve an actionEvent " + e);
		
		if (e.getActionCommand().equalsIgnoreCase("Start"))
			System.out.println("Let's start something");
		if (e.getActionCommand().equalsIgnoreCase("Stop"))
			System.out.println("Let's stop something");
	}

	/**
	 * getter of frame
	 * @return
	 */
	public static JFrame getFrame() {
		return frame;
	}

	/**
	 * Overriding the method of WindowListener interface
	 */
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Overriding the method of WindowListener interface
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Overriding the method of WindowListener interface
	 */
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Overriding the method of WindowListener interface
	 */
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Overriding the method of WindowListener interface
	 */
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Overriding the method of WindowListener interface
	 */
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Overriding the method of WindowListener interface
	 */
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


}
