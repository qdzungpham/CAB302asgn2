package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultCaret;

import asgn2Customers.Customer;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;

import javax.swing.JFrame;

import java.awt.*;
import javax.swing.*;


/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a ‘dummy’ class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature – as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Person A and Person B
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {
	
	
	private PizzaRestaurant restaurant;
	
	private static PizzaGUI gui;
	JTextField filePath;
	private JButton browseFileBtn;
	private JButton displayInfoBtn;
	private JFileChooser fc;
	private String fileName;
	private JTable customersTable;
	private JTable pizzasTable;
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		// TO DO
		super(title);
		initComponents();
		gui = this;
	}

	private void initComponents() {
		JPanel filePanel = new JPanel();
		JLabel fileLabel = new JLabel("Select a file: ");
		filePath = new JTextField(30);
		filePath.setEditable(false);
		browseFileBtn = new JButton("Browse...");
		browseFileBtn.addActionListener(this);
		displayInfoBtn = new JButton("Display the information");
		filePanel.add(fileLabel);
		filePanel.add(filePath);
		filePanel.add(browseFileBtn);
		filePanel.add(displayInfoBtn);
		fc = new JFileChooser();
		fc.setCurrentDirectory(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "logs"));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		JPanel customersPanel = new JPanel();
		customersPanel.setBorder(BorderFactory.createTitledBorder("Customers"));
		customersTable = new JTable();
		JScrollPane customersScroller = new JScrollPane(customersTable);
		customersScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		customersPanel.add(customersScroller);
		
		JPanel pizzasPanel = new JPanel();
		pizzasPanel.setBorder(BorderFactory.createTitledBorder("Pizzas"));
		pizzasTable = new JTable();
		JScrollPane pizzasScroller = new JScrollPane(pizzasTable);
		pizzasScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pizzasPanel.add(pizzasScroller);
		
		mainPanel.add(filePanel, BorderLayout.NORTH);
		mainPanel.add(customersPanel, BorderLayout.CENTER);
		mainPanel.add(pizzasPanel, BorderLayout.SOUTH);
		
		getContentPane().add(mainPanel);
	}
	
	@Override
	public void run() {
		// TO DO
		createAndShowGUI();
	}
	
	private static void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//gui.setPreferredSize(new Dimension(500, 200));
		gui.setLocation(new Point(200, 200));
		gui.pack();
		gui.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Component source = (Component) e.getSource();
		System.out.println(source);
		if (source == browseFileBtn) {
			int returnVal = fc.showOpenDialog(gui);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				fileName = file.getName();
				filePath.setText(fileName);
			} 
		}
	}

	

}
