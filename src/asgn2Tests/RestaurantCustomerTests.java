package asgn2Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that that tests the methods relating to the handling of Customer objects in the asgn2Restaurant.PizzaRestaurant
 * class as well as processLog and resetDetails.
 * 
 * @author Person A
 */
public class RestaurantCustomerTests {
	// TO DO
	
	@Test (expected = CustomerException.class)
	public void getCustomerByIndexInvalidIndexException() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant test = new PizzaRestaurant();
		test.processLog("20170101.txt");
		test.getCustomerByIndex(-1);
	}
	
	@Test (expected = CustomerException.class)
	public void getCustomerByIndexInvalidIndex1Exception() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant test = new PizzaRestaurant();
		test.processLog("20170101.txt");
		test.getCustomerByIndex(3);
	}
	
	@Test 
	public void getNumCustomerOrders() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant test = new PizzaRestaurant();
		test.processLog("20170101.txt");
		assertEquals(3, test.getNumCustomerOrders());
	}
	
	@Test 
	public void getNumCustomerOrders2() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant test = new PizzaRestaurant();
		test.processLog("20170102.txt");
		assertEquals(10, test.getNumCustomerOrders());
	}
	
	@Test 
	public void getTotalDeliveryDistance() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant test = new PizzaRestaurant();
		test.processLog("20170101.txt");
		assertEquals(15, test.getTotalDeliveryDistance(), 0.001);
	}
	
	@Test 
	public void getTotalDeliveryDistance2() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant test = new PizzaRestaurant();
		test.processLog("20170102.txt");
		assertEquals(41.41, test.getTotalDeliveryDistance(), 0.001);
	}
	
	@Test 
	public void resetDetails() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant test = new PizzaRestaurant();
		test.processLog("20170101.txt");
		test.resetDetails();
		assertEquals(0, test.getNumCustomerOrders());
	}
	
	@Test (expected = LogHandlerException.class)
	public void processLogFileNotFoundLogHandlerException() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant test = new PizzaRestaurant();
		test.processLog("asdfxz.txt");
	}
	
	@Test (expected = LogHandlerException.class)
	public void processLogParsingLineLogHandlerException() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant test = new PizzaRestaurant();
		test.processLog("RicktestLogLineParsingErrors.txt");
	}
	
	@Test (expected = CustomerException.class)
	public void processLogCustomerException() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant test = new PizzaRestaurant();
		test.processLog("RicktestLogCustomerException.txt");
	}
	
	@Test (expected = PizzaException.class)
	public void processLogPizzaException() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant test = new PizzaRestaurant();
		test.processLog("RicktestLogPizzaException.txt");
	}
	
	@Test 
	public void processLogNormalCase() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant test = new PizzaRestaurant();
		assertEquals(true, test.processLog("20170101.txt"));
		
	}
	
	

}
