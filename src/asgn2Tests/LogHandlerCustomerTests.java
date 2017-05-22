package asgn2Tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Restaurant.LogHandler;

/**
 * A class that tests the methods relating to the creation of Customer objects in the asgn2Restaurant.LogHander class.
 *
 * @author Person A
 */
public class LogHandlerCustomerTests {
	// TO DO
	
	@Test (expected = LogHandlerException.class)
	public void createCustomerParsingLineLogHandlerException() throws CustomerException, LogHandlerException {
		Customer test = LogHandler.createCustomer("adasdzxczxasd");
	}
	
	@Test (expected = LogHandlerException.class)
	public void createCustomerParsingLocationXDoubleLogHandlerException() throws CustomerException, LogHandlerException {
		Customer test = LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5.2,5,PZV,2");
	}
	
	@Test (expected = LogHandlerException.class)
	public void createCustomerParsingLocationXStringLogHandlerException() throws CustomerException, LogHandlerException {
		Customer test = LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789,DVC,asd,5,PZV,2");
	}
	
	@Test (expected = LogHandlerException.class)
	public void createCustomerParsingLocationYDoubleLogHandlerException() throws CustomerException, LogHandlerException {
		Customer test = LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5.2,PZV,2");
	}
	
	@Test (expected = LogHandlerException.class)
	public void createCustomerParsingLocationYStringLogHandlerException() throws CustomerException, LogHandlerException {
		Customer test = LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,asd,PZV,2");
	}
	
	@Test (expected = LogHandlerException.class)
	public void createCustomerParsingLocationTimeLogHandlerException() throws CustomerException, LogHandlerException {
		Customer test = LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789,DVC,asd,5,PZV,2");
	}
	
	@Test (expected = CustomerException.class)
	public void createCustomerInvalidNameCustomerException() throws CustomerException, LogHandlerException {
		Customer test = LogHandler.createCustomer("19:00:00,19:20:00,asdf asdf asdf asdf asdf,0123456789,DVC,5,5,PZV,2");
	}
	
	@Test (expected = CustomerException.class)
	public void createCustomerInvalidPhoneNumCustomerException() throws CustomerException, LogHandlerException {
		Customer test = LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,01234567890,DVC,5,5,PZV,2");
	}
	
	@Test (expected = CustomerException.class)
	public void createCustomerInvalidCodeCustomerException() throws CustomerException, LogHandlerException {
		Customer test = LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789,RIC,5,5,PZV,2");
	}
	
	@Test (expected = CustomerException.class)
	public void createCustomerInvalidLocationXNumCustomerException() throws CustomerException, LogHandlerException {
		Customer test = LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789,DVC,11,5,PZV,2");
	}
	
	@Test (expected = CustomerException.class)
	public void createCustomerInvalidLocationYCustomerException() throws CustomerException, LogHandlerException {
		Customer test = LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,11,PZV,2");
	}
	
	@Test
	public void createCustomerNormalTest() throws CustomerException, LogHandlerException {
		Customer test = LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2");
		assertEquals("Casey Jones", test.getName());
		assertEquals("0123456789", test.getMobileNumber());
		assertEquals("Driver Delivery", test.getCustomerType());
		assertEquals(10, test.getDeliveryDistance(), 0.001);
		assertEquals(5, test.getLocationX());
		assertEquals(5, test.getLocationY());
	}
	
	@Test
	public void createCustomerNormalTest2() throws CustomerException, LogHandlerException {
		Customer test = LogHandler.createCustomer("19:00:00,19:40:00,rick,0123456788,DVC,3,2,PZV,4");
		Customer cus = new DriverDeliveryCustomer("rick", "0123456788", 3, 2);
		assertEquals(true, test.equals(cus));
	}
	
	@Test (expected = LogHandlerException.class)
	public void populateCustomerDatasetFileNotFoundLogHandlerException() throws CustomerException, LogHandlerException {
		ArrayList<Customer> test = LogHandler.populateCustomerDataset("asdadsasdwqqc.txt");
	}
	
	@Test (expected = LogHandlerException.class)
	public void populateCustomerParsingLineLogHandlerException() throws CustomerException, LogHandlerException {
		ArrayList<Customer> test = LogHandler.populateCustomerDataset("RicktestLogParsingLineErrors.txt");
	}
	
	@Test (expected = CustomerException.class)
	public void populateCustomerSemanticErrorsCustomerException() throws CustomerException, LogHandlerException {
		ArrayList<Customer> test = LogHandler.populateCustomerDataset("RicktestLogSementicErrors.txt");
	}
	
	
	
}
