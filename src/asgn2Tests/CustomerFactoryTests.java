package asgn2Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Exceptions.CustomerException;

/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author Person A
 *
 */
public class CustomerFactoryTests {
	// TO DO
	
	@Test(expected = CustomerException.class)
	public void InvalidCustomerCodeException() throws CustomerException{
		Customer test = CustomerFactory.getCustomer("PUW", "rick", "0123456789", 5, 5);
	}
	
	@Test(expected = CustomerException.class)
	public void InvalidCustomerCodeException1() throws CustomerException{
		Customer test = CustomerFactory.getCustomer("RIC", "rick", "0123456789", 5, 5);
	}
	
	@Test
	public void CheckReturnPickUpCustomerObject() throws CustomerException {
		Customer cus = new PickUpCustomer("rick", "0123456789", 5, 5);
		Customer test = CustomerFactory.getCustomer("PUC", "rick", "0123456789", 5, 5);
		assertEquals(true, test.equals(cus));
	}
	
	@Test
	public void CheckReturnDriverDeliveryCustomerObject() throws CustomerException {
		Customer cus = new DriverDeliveryCustomer("rick", "0123456789", 5, 5);
		Customer test = CustomerFactory.getCustomer("DVC", "rick", "0123456789", 5, 5);
		assertEquals(true, test.equals(cus));
	}
	
	@Test
	public void CheckReturnDroneDeliveryCustomerObject() throws CustomerException {
		Customer cus = new DroneDeliveryCustomer("rick", "0123456789", 5, 5);
		Customer test = CustomerFactory.getCustomer("DNC", "rick", "0123456789", 5, 5);
		assertEquals(true, test.equals(cus));
	}
}
