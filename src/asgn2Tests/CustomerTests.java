package asgn2Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Exceptions.CustomerException;

/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer, asgn2Customers.DriverDeliveryCustomer,
 * asgn2Customers.DroneDeliveryCustomer classes. Note that an instance of asgn2Customers.DriverDeliveryCustomer 
 * should be used to test the functionality of the  asgn2Customers.Customer abstract class. 
 * 
 * @author Person A
 * 
 *
 */
public class CustomerTests {
	// TO DO
	
	// PickUpCustomer Class
	@Test(expected = CustomerException.class)
	public void PickUpCustomerClassName0CharactersException() throws CustomerException{
		Customer test = new PickUpCustomer("", "0123456789", 1, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void PickUpCustomerClassName21CharactersException() throws CustomerException{
		Customer test = new PickUpCustomer("asdf asdf asdf asdf a", "0123456789", 1, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void PickUpCustomerClassName30CharactersException() throws CustomerException{
		Customer test = new PickUpCustomer("asdf asdf asdf asdf asdf asdf ", "0123456789", 1, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void PickUpCustomerClassNameOnlyWhiteSpacesException() throws CustomerException{
		Customer test = new PickUpCustomer("  ", "0123456789", 1, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void PickUpCustomerClassPhoneNumLess10digitsException() throws CustomerException{
		Customer test = new PickUpCustomer("rick", "012345678", 1, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void PickUpCustomerClassPhoneNumGreater10digitsException() throws CustomerException{
		Customer test = new PickUpCustomer("rick", "01234567891", 1, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void PickUpCustomerClassPhoneNumNotBeginWith0Exception() throws CustomerException{
		Customer test = new PickUpCustomer("rick", "1123456789", 1, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void PickUpCustomerClassMoreThan10BlocksWestException() throws CustomerException{
		Customer test = new PickUpCustomer("rick", "0123456789", -11, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void PickUpCustomerClassMoreThan10BlocksEstException() throws CustomerException{
		Customer test = new PickUpCustomer("rick", "0123456789", 11, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void PickUpCustomerClassMoreThan10BlocksSouthException() throws CustomerException{
		Customer test = new PickUpCustomer("rick", "0123456789", 1, -11);
	}
	
	@Test(expected = CustomerException.class)
	public void PickUpCustomerClassMoreThan10BlocksNorthException() throws CustomerException{
		Customer test = new PickUpCustomer("rick", "0123456789", 1, 11);
	}
	
	@Test
	public void PickUpCustomerClassCheckInitialType() throws CustomerException{
		Customer test = new PickUpCustomer("rick", "0123456789", 1, 1);
		assertEquals("Pick Up", test.getCustomerType());
	}
	
	@Test
	public void PickUpCustomerClassCheckDistance() throws CustomerException{
		Customer test = new PickUpCustomer("rick", "0123456789", 1, 1);
		assertEquals(0, test.getDeliveryDistance(), 0.001);
	}
	
	//===========================================================================================
	// DriverDeliveryCustomer Class
	@Test(expected = CustomerException.class)
	public void DriverDeliveryCustomerClassName0CharactersException() throws CustomerException{
		Customer test = new DriverDeliveryCustomer("", "0123456789", 1, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void DriverDeliveryCustomerClassName21CharactersException() throws CustomerException{
		Customer test = new DriverDeliveryCustomer("asdf asdf asdf asdf a", "0123456789", 1, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void DriverDeliveryCustomerClassName30CharactersException() throws CustomerException{
		Customer test = new DriverDeliveryCustomer("asdf asdf asdf asdf asdf asdf ", "0123456789", 1, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void DriverDeliveryCustomerClassNameOnlyWhiteSpacesException() throws CustomerException{
		Customer test = new DriverDeliveryCustomer("  ", "0123456789", 1, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void DriverDeliveryCustomerClassPhoneNumLess10digitsException() throws CustomerException{
		Customer test = new DriverDeliveryCustomer("rick", "012345678", 1, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void DriverDeliveryCustomerClassPhoneNumGreater10digitsException() throws CustomerException{
		Customer test = new DriverDeliveryCustomer("rick", "01234567891", 1, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void DriverDeliveryCustomerClassPhoneNumNotBeginWith0Exception() throws CustomerException{
		Customer test = new DriverDeliveryCustomer("rick", "1123456789", 1, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void DriverDeliveryCustomerClassMoreThan10BlocksWestException() throws CustomerException{
		Customer test = new DriverDeliveryCustomer("rick", "0123456789", -11, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void DriverDeliveryCustomerClassMoreThan10BlocksEstException() throws CustomerException{
		Customer test = new DriverDeliveryCustomer("rick", "0123456789", 11, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void DriverDeliveryCustomerClassMoreThan10BlocksSouthException() throws CustomerException{
		Customer test = new DriverDeliveryCustomer("rick", "0123456789", 1, -11);
	}
	
	@Test(expected = CustomerException.class)
	public void DriverDeliveryCustomerClassMoreThan10BlocksNorthException() throws CustomerException{
		Customer test = new DriverDeliveryCustomer("rick", "0123456789", 1, 11);
	}
	
	@Test(expected = CustomerException.class)
	public void DriverDeliveryCustomerAtTheRestaurantException() throws CustomerException{
		Customer test = new DriverDeliveryCustomer("rick", "0123456789", 0, 0);
	}
	
	@Test
	public void DriverDeliveryCustomerClassCheckInitialType() throws CustomerException{
		Customer test = new DriverDeliveryCustomer("rick", "0123456789", 1, 1);
		assertEquals("Driver Delivery", test.getCustomerType());
	}
	
	@Test
	public void DriverDeliveryCustomerClassCheckDistance() throws CustomerException{
		Customer test = new DriverDeliveryCustomer("rick", "0123456789", 5, 5);
		assertEquals(10, test.getDeliveryDistance(), 0.001);
	}
	
	//===========================================================================================
	// DroneDeliveryCustomer Class
	@Test(expected = CustomerException.class)
	public void DroneDeliveryCustomerClassName0CharactersException() throws CustomerException{
		Customer test = new DroneDeliveryCustomer("", "0123456789", 1, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void DroneDeliveryCustomerClassName21CharactersException() throws CustomerException{
		Customer test = new DroneDeliveryCustomer("asdf asdf asdf asdf a", "0123456789", 1, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void DroneDeliveryCustomerClassName30CharactersException() throws CustomerException{
		Customer test = new DroneDeliveryCustomer("asdf asdf asdf asdf asdf asdf ", "0123456789", 1, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void DroneDeliveryCustomerClassNameOnlyWhiteSpacesException() throws CustomerException{
		Customer test = new DroneDeliveryCustomer("  ", "0123456789", 1, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void DroneDeliveryCustomerClassPhoneNumLess10digitsException() throws CustomerException{
		Customer test = new DroneDeliveryCustomer("rick", "012345678", 1, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void DroneDeliveryCustomerClassPhoneNumGreater10digitsException() throws CustomerException{
		Customer test = new DroneDeliveryCustomer("rick", "01234567891", 1, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void DroneDeliveryCustomerClassPhoneNumNotBeginWith0Exception() throws CustomerException{
		Customer test = new DroneDeliveryCustomer("rick", "1123456789", 1, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void DroneDeliveryCustomerClassMoreThan10BlocksWestException() throws CustomerException{
		Customer test = new DroneDeliveryCustomer("rick", "0123456789", -11, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void DroneDeliveryCustomerClassMoreThan10BlocksEstException() throws CustomerException{
		Customer test = new DroneDeliveryCustomer("rick", "0123456789", 11, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void DroneDeliveryCustomerClassMoreThan10BlocksSouthException() throws CustomerException{
		Customer test = new DroneDeliveryCustomer("rick", "0123456789", 1, -11);
	}
	
	@Test(expected = CustomerException.class)
	public void DroneDeliveryCustomerClassMoreThan10BlocksNorthException() throws CustomerException{
		Customer test = new DroneDeliveryCustomer("rick", "0123456789", 1, 11);
	}
	
	@Test(expected = CustomerException.class)
	public void DroneDeliveryCustomerAtTheRestaurantException() throws CustomerException{
		Customer test = new DroneDeliveryCustomer("rick", "0123456789", 0, 0);
	}
	
	@Test
	public void DroneDeliveryCustomerClassCheckInitialType() throws CustomerException{
		Customer test = new DroneDeliveryCustomer("rick", "0123456789", 1, 1);
		assertEquals("Drone Delivery", test.getCustomerType());
	}
	
	@Test
	public void DroneDeliveryCustomerClassCheckDistance() throws CustomerException{
		Customer test = new DroneDeliveryCustomer("rick", "0123456789", 4, 3);
		assertEquals(5, test.getDeliveryDistance(), 0.001);
	}
}
