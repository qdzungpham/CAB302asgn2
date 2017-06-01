package asgn2Restaurant;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

/**
 *
 * A class that contains methods that use the information in the log file to return Pizza 
 * and Customer object - either as an individual Pizza/Customer object or as an
 * ArrayList of Pizza/Customer objects.
 * 
 * @author Rick Pham-n9579249 and n9326448/Hang Su
 *
 */
public class LogHandler {
	


	/**
	 * Returns an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file.
	 * @param filename The file name of the log file
	 * @return an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file. 
	 * @throws CustomerException If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above such as cannot find/read file
	 * 
	 */
	public static ArrayList<Customer> populateCustomerDataset(String filename) throws CustomerException, LogHandlerException{
		// TO DO
		String logFile = ".//logs/" + filename;
		String line = "";
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		// read file
		try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {		
            while ((line = br.readLine()) != null) {
            	try {
            		// analyses each line and creates pizza object based on processed data
            		customerList.add(createCustomer(line));
				} catch (CustomerException | LogHandlerException e) {
					throw e;
				}
            }

        } catch (IOException e1) {
        	throw new LogHandlerException("LogHandlerException: Invalid file.");
        }
		
		return customerList;
	}		

	/**
	 * Returns an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @param filename The file name of the log file
	 * @return an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Pizza> populatePizzaDataset(String filename) throws PizzaException, LogHandlerException{
		// TO DO
		String logFile = ".//logs/" + filename;
		String line = "";
		ArrayList<Pizza> pizzasList = new ArrayList<Pizza>();
		// reads file
		try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {		
            while ((line = br.readLine()) != null) {
            	try {
            		// analyses each line and creates pizza object based on processed data
					pizzasList.add(createPizza(line));
				} catch (PizzaException | LogHandlerException e) {
					throw e;
				}
            }
            return pizzasList;

        } catch (IOException e1) {
        	throw new LogHandlerException("LogHandlerException: Invalid file.");
        }
		
	}		

	
	/**
	 * Creates a Customer object by parsing the  information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Customer object containing the information from the line in the log file
	 * @throws CustomerException - If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Customer createCustomer(String line) throws CustomerException, LogHandlerException{
		// TO DO
		String customerCode;
		String Name;
		String MobileNumber;
		int LocationX;
		int LocationY;
		String[] currentLine = line.split(",");
		// parses data from line and throw exception if there is an error
		try {
			//stores data form the line
			customerCode = currentLine[4];
			Name = currentLine[2];
			MobileNumber =currentLine[3];
			LocationX = Integer.parseInt(currentLine[5]);
			LocationY = Integer.parseInt(currentLine[6]);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			throw new LogHandlerException("LogHandlerException: Problem parsing the line from the log file.");
		}
		
		try {
			// creates customer object
			return CustomerFactory.getCustomer(customerCode, Name, MobileNumber, LocationX, LocationY);
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}
	
	/**
	 * Creates a Pizza object by parsing the information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Pizza object containing the information from the line in the log file
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Pizza createPizza(String line) throws PizzaException, LogHandlerException{
		// TO DO		
		
		String pizzaCode;
		int quantity;
		LocalTime orderTime;
		LocalTime deliveryTime;
		// parses data from line and throw exception if there is an error
		try {
			// stores data from the line
			String[] currentLine = line.split(",");
			pizzaCode = currentLine[7];
			quantity = Integer.parseInt(currentLine[8]);
			orderTime = LocalTime.parse(currentLine[0]);
			deliveryTime = LocalTime.parse(currentLine[1]);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			throw new LogHandlerException("LogHandlerException: Problem parsing the line from the log file.");
		}
		
		try {
			// creates pizza object
			return PizzaFactory.getPizza(pizzaCode, quantity, orderTime, deliveryTime);
		} catch (PizzaException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}

}
