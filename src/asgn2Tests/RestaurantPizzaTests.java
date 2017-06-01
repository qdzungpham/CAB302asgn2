package asgn2Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that tests the methods relating to the handling of Pizza objects in the asgn2Restaurant.PizzaRestaurant class as well as
 * processLog and resetDetails.
 * 
 * @author n9326448/Hang Su
 *
 */


public class RestaurantPizzaTests {
	private static final double DELTA = 1e-15;
	@Test (expected = PizzaException.class)
	public void getPizzaByIndexInvalidIndexException() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant Restaurant = new PizzaRestaurant();
		Restaurant.processLog("20170101.txt");
		Restaurant.getPizzaByIndex(-1);
	}
	
	@Test (expected = PizzaException.class)
	public void getPizzaByIndexInvalidIndex1Exception() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant Restaurant = new PizzaRestaurant();
		Restaurant.processLog("20170101.txt");
		Restaurant.getPizzaByIndex(3);
	}
	
	@Test 
	public void getNumPizzaOrders() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant Restaurant = new PizzaRestaurant();
		Restaurant.processLog("20170101.txt");
		assertEquals(3, Restaurant.getNumPizzaOrders());
	}
	
	@Test 
	public void getTotalProfit() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant Restaurant = new PizzaRestaurant();
		Restaurant.processLog("20170101.txt");
		assertEquals(36.5, Restaurant.getTotalProfit(), DELTA);
	}
	
	@Test 
	public void resetDetails() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant Restaurant = new PizzaRestaurant();
		Restaurant.processLog("20170101.txt");
		Restaurant.resetDetails();
		assertEquals(0, Restaurant.getNumPizzaOrders());
	}
	
	@Test (expected = LogHandlerException.class)
	public void processLogFileNotFoundLogHandlerException() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant Restaurant = new PizzaRestaurant();
		Restaurant.processLog("Test.txt");
	}
	
	@Test 
	public void processLogNormalCase() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant Restaurant = new PizzaRestaurant();
		assertEquals(true, Restaurant.processLog("20170101.txt"));
		
	}
}
