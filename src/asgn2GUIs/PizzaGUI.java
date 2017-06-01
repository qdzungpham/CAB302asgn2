package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultCaret;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
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
 * @author Rick Pham-n9579249 and n9326448/Hang Su
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {
	
	private static final long serialVersionUID = -8363697766626046823L;
	private PizzaRestaurant restaurant;
	
	private static PizzaGUI gui;
	private JTextField filePath;
	private JTextField totalProfit;
	private JTextField totalDistance;
	private JButton browseFileBtn;
	private JButton resetBtn;
	private JButton displayOrdersBtn;
	private JButton displayCustomersBtn;
	private JButton calTotalProfitBtn;
	private JButton calTotalDistanceBtn;
	private JFileChooser fc;
	private String fileName;
	private DefaultTableModel customersModel;
	private DefaultTableModel pizzasModel;
	private DecimalFormat df;
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		// TO DO
		super(title);
		initComponents();
		gui = this;
		df = new DecimalFormat("0.00");
	}
 
	// creates GUI components
	private void initComponents() {
		// creates top panel containing file name text field, choose file button, reset button
		JPanel filePanel = new JPanel();
		JLabel selectFileLabel = new JLabel("File name: ");
		filePath = new JTextField(35);
		filePath.setEditable(false);
		browseFileBtn = new JButton("Browse...");
		browseFileBtn.addActionListener(this);
		resetBtn = new JButton("Reset");
		resetBtn.setEnabled(false);
		resetBtn.addActionListener(this);
		filePanel.add(selectFileLabel);
		filePanel.add(filePath);
		filePanel.add(browseFileBtn);
		filePanel.add(resetBtn);
		fc = new JFileChooser();
		fc.setCurrentDirectory(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "logs"));
		
		// creates customer panel
		JPanel customersPanel = new JPanel();
		customersPanel.setLayout(new BorderLayout());
		customersPanel.setBorder(BorderFactory.createTitledBorder("Customers"));	
		/////// inits table for customers
		customersModel = new DefaultTableModel();
		customersModel.addColumn("Customer Name");
		customersModel.addColumn("Mobile Number");
		customersModel.addColumn("Customer Type");
		customersModel.addColumn("X and Y Location");
		customersModel.addColumn("Distance from Restaurant");
		JTable customersTable = new JTable(customersModel);
		// creates scroller wrapping the table
		JScrollPane customersScroller = new JScrollPane(customersTable);
		customersScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		customersScroller.setPreferredSize(new Dimension(600, 200));
		// panel to hold display button, calculate button and calculate text field
		JPanel calTotalDistancePanel = new JPanel();
		displayCustomersBtn = new JButton("Display customers");
		displayCustomersBtn.setEnabled(false);
		displayCustomersBtn.addActionListener(this);
		JLabel totalDistanceLabel = new JLabel("Total distance travelled: ");
		totalDistance = new JTextField(20);
		totalDistance.setEditable(false);
		calTotalDistanceBtn = new JButton("Calculate");
		calTotalDistanceBtn.setEnabled(false);
		calTotalDistanceBtn.addActionListener(this);
		calTotalDistancePanel.add(displayCustomersBtn);
		calTotalDistancePanel.add(totalDistanceLabel);
		calTotalDistancePanel.add(totalDistance);
		calTotalDistancePanel.add(calTotalDistanceBtn);
		// adds scroller and buttons panel to main customer panel
		customersPanel.add(customersScroller, BorderLayout.PAGE_START);
		customersPanel.add(calTotalDistancePanel, BorderLayout.PAGE_END);
		
		// creates pizza panel
		JPanel pizzasPanel = new JPanel();
		pizzasPanel.setLayout(new BorderLayout());
		pizzasPanel.setBorder(BorderFactory.createTitledBorder("Orders"));
		////////// inits pizzas table
		pizzasModel = new DefaultTableModel();
		pizzasModel.addColumn("Pizza Type");
		pizzasModel.addColumn("Quantity");
		pizzasModel.addColumn("Order Price");
		pizzasModel.addColumn("Order Cost");
		pizzasModel.addColumn("Order Profit");
		JTable pizzasTable = new JTable(pizzasModel);
		// creates scroller wrapping the table
		JScrollPane pizzasScroller = new JScrollPane(pizzasTable);
		pizzasScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pizzasScroller.setPreferredSize(new Dimension(600, 200));
		// panel to hold display button, calculate button and calculate text field
		JPanel calTotalProfitPanel = new JPanel();
		displayOrdersBtn = new JButton("Display orders");
		displayOrdersBtn.setEnabled(false);
		displayOrdersBtn.addActionListener(this);
		JLabel totalProfitLabel = new JLabel("Total profit made: ");
		totalProfit = new JTextField(20);
		totalProfit.setEditable(false);
		calTotalProfitBtn = new JButton("Calculate");
		calTotalProfitBtn.setEnabled(false);
		calTotalProfitBtn.addActionListener(this);
		calTotalProfitPanel.add(displayOrdersBtn);
		calTotalProfitPanel.add(totalProfitLabel);
		calTotalProfitPanel.add(totalProfit);
		calTotalProfitPanel.add(calTotalProfitBtn);
		// adds scroller and buttons panel to main pizza panel
		pizzasPanel.add(pizzasScroller, BorderLayout.PAGE_START);
		pizzasPanel.add(calTotalProfitPanel, BorderLayout.PAGE_END);
		
		// creates main panel that wraps all panels above
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(filePanel, BorderLayout.NORTH);
		mainPanel.add(customersPanel, BorderLayout.CENTER);
		mainPanel.add(pizzasPanel, BorderLayout.SOUTH);
		
		// adds main panel to the frame
		getContentPane().add(mainPanel);
	}
	
	@Override
	public void run() {
		// TO DO
		createAndShowGUI();
	}
	
	// creates the GUI and shows it
	private static void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		gui.setResizable(false);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setLocation(new Point(700, 200));
		// displays the window
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
				processLogFile();
			} 
		} else if (source == displayCustomersBtn) {
			displayCustomersTable();
		} else if (source == displayOrdersBtn) {
			displayPizzasTable();
		} else if (source == calTotalDistanceBtn) {
			totalDistance.setText(String.valueOf(df.format(restaurant.getTotalDeliveryDistance())));
			JOptionPane.showMessageDialog(gui, "Total distance calculated.", "Information", JOptionPane.INFORMATION_MESSAGE);
		} else if (source == calTotalProfitBtn) {
			totalProfit.setText(String.valueOf(df.format(restaurant.getTotalProfit())));
			JOptionPane.showMessageDialog(gui, "Total profit calculated.", "Information", JOptionPane.INFORMATION_MESSAGE);
		} else if (source == resetBtn) {
			resetAllData();
		}
		
	}

	// reset all fields, tables and buttons to its initially state
	private void resetAllData() {
		restaurant.resetDetails();
		customersModel.setRowCount(0);
		pizzasModel.setRowCount(0);
		displayCustomersBtn.setEnabled(false);
		displayOrdersBtn.setEnabled(false);
		resetBtn.setEnabled(false);
		calTotalDistanceBtn.setEnabled(false);
		calTotalProfitBtn.setEnabled(false);
		browseFileBtn.setEnabled(true);
		filePath.setText("");
		totalDistance.setText("");
		totalProfit.setText("");
		JOptionPane.showMessageDialog(gui, "All data reset.", "Information", JOptionPane.INFORMATION_MESSAGE);
	}

	// add data to the table
	private void displayPizzasTable() {
		for (int i = 0; i < restaurant.getNumPizzaOrders(); i++) {
			Pizza currentPizza = null;
			try {
				currentPizza = restaurant.getPizzaByIndex(i);
				pizzasModel.addRow(new Object[]{currentPizza.getPizzaType(), currentPizza.getQuantity(), String.valueOf(df.format(currentPizza.getOrderPrice())), 
						String.valueOf(df.format(currentPizza.getOrderCost())), String.valueOf(df.format(currentPizza.getOrderProfit()))});
				displayOrdersBtn.setEnabled(false);
			} catch (PizzaException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(gui, e1.getMessage() + " (index " + i +").", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		JOptionPane.showMessageDialog(gui, "Orders displayed.", "Information", JOptionPane.INFORMATION_MESSAGE);
	}

	// adds data to the table
	private void displayCustomersTable() {
		for (int i = 0; i < restaurant.getNumCustomerOrders(); i++) {
			Customer currentCustomer = null;
			try {
				currentCustomer = restaurant.getCustomerByIndex(i);	
				customersModel.addRow(new Object[]{currentCustomer.getName(), currentCustomer.getMobileNumber(), currentCustomer.getCustomerType(),
						currentCustomer.getLocationX()+", "+currentCustomer.getLocationY(),String.valueOf(df.format(currentCustomer.getDeliveryDistance()))});
				displayCustomersBtn.setEnabled(false);
			} catch (CustomerException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(gui, e1.getMessage() + " (index " + i +").", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		JOptionPane.showMessageDialog(gui, "Customers displayed.", "Information", JOptionPane.INFORMATION_MESSAGE);
	}

	// processes log file when user selected a file
	private void processLogFile() {
		File file = fc.getSelectedFile();
		fileName = file.getName();
		filePath.setText(fileName);
		restaurant = new PizzaRestaurant();
		boolean logProcessStatus = false;
		try {
			logProcessStatus = restaurant.processLog(fileName);
		} catch (CustomerException | PizzaException | LogHandlerException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
			e1.printStackTrace();
			JOptionPane.showMessageDialog(gui, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		if (logProcessStatus) {
			displayCustomersBtn.setEnabled(true);
			displayOrdersBtn.setEnabled(true);
			calTotalDistanceBtn.setEnabled(true);
			calTotalProfitBtn.setEnabled(true);
			resetBtn.setEnabled(true);
			browseFileBtn.setEnabled(false);
			JOptionPane.showMessageDialog(gui, "File loaded.", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	

}
